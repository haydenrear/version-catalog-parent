import dataclasses
import os
import subprocess

import toml

if "RUN_DIR" in os.environ.keys():
    home = os.environ['RUN_DIR']
else:
    home = os.path.expanduser('~') + "/IdeaProjects/versions-parent"

@dataclasses.dataclass(init=True)
class Library:
    key: str
    name: str
    group: str
    version: str

    def to_code(self):
        return f"val {self.key} = \"{self.group}:{self.name}:{self.version}\""

@dataclasses.dataclass(init=True)
class Plugin:
    key: str
    id: str
    version: str

    def to_code(self):
        return f"val {self.key} = \"{self.id}:{self.version}\""

class Plugins:
    plugins: dict[str, Plugin]

    def __init__(self, initialize: dict[str, dict[...]]):
        if 'plugins' in initialize.keys():
            self.plugins = {
                k: Plugin(k, v['id'], v['version']) for k, v in initialize['plugins'].items()
            }
        else:
            self.plugins = {}

    def plugin_accessors(self) -> str:
        return '\n'.join([f"""
        {v.to_code()}
        """ for k, v in self.plugins.items()])


class Versions:
    versions: dict[str, Library]

    def __init__(self, initialize: dict[str, dict[...]]):
        if 'libraries' in initialize.keys():
            self.versions = {
                k: Library(k, v['name'], v['group'], v['version']) for k, v in initialize['libraries'].items()
            }
        else:
            self.versions = {}

    def version_accessors(self) -> str:
        return '\n'.join([f"""
        {v.to_code()}
        """ for k, v in self.versions.items()])


@dataclasses.dataclass(init=True)
class Bundle:
    name: str
    versions: list[Library]

    def iterate_fn(self) -> str:
        return """
        open fun inBundle(): List<String> {
            return mutableListOf(
        """ + ', '.join([f'{v.key}' for v in self.versions]) + ")}"

    def to_code(self) -> str:
        beginning = "open class " + self.name.capitalize() + "Bundle " + "{"

        for v in self.versions:
            beginning += f"""
                {v.to_code()}
            """
        beginning += self.iterate_fn()
        beginning += "}\n"
        beginning += f"val {self.name}Bundle = {self.name.capitalize()}Bundle()\n"
        return beginning

class Bundles:
    bundles: dict[str, Bundle]

    def __init__(self, initialize: dict[str, dict[...]], versions: Versions):
        if 'bundles' in initialize.keys():
            self.bundles = {
                k: Bundle(k, [versions.versions[versi] for versi in v]) for k, v in initialize['bundles'].items()
            }
        else:
            self.bundles = {}

    def bundle_accessors(self) -> str:
        return '\n'.join([f"""
        {v.to_code()}
        """ for k, v in self.bundles.items()])

class VersionCatalog:
    versions: Versions
    bundles: Bundles
    plugins: Plugins

    def __init__(self, tomls: dict[str, dict[...]]):
        self.versions = Versions(tomls)
        self.plugins = Plugins(tomls)
        self.bundles = Bundles(tomls, self.versions)


def load_version_catalog() -> VersionCatalog:
    pass

def build_kotlin_fn():
    with open(f"{home}/hayden-bom-plugin/build_hayden_bom/BomTemplate.txt", 'r') as b:
        print("Opened Bom template.")
        lines = b.readlines()
        loaded = toml.load(f"{home}/.gradle/libs.versions.toml")
        with open(f"{home}/hayden-bom-plugin/src/main/kotlin/com/hayden/haydenbomplugin/BomPlugin.kt", 'w') as out:
            for l in lines:
                version_catalog = VersionCatalog(loaded)
                if '{libraryAccessors}' in l:
                    out.write(version_catalog.versions.version_accessors())
                elif '{pluginAccessors}' in l:
                    out.write(version_catalog.plugins.plugin_accessors())
                elif '{bundleAccessors}' in l:
                    out.write(version_catalog.bundles.bundle_accessors())
                else:
                    out.write(l)