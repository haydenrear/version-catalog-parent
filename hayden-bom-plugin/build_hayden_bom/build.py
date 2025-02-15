import os
import subprocess

import build_kotlin

if "RUN_DIR" in os.environ.keys():
    home = os.environ['RUN_DIR']
else:
    home = os.path.expanduser('~') + "/IdeaProjects/versions-parent"

def run_prcesses():
    build_kotlin.build_kotlin_fn()
    subprocess.run("./gradlew version_catalog:generateCatalogAsToml", shell=True, cwd=f"{home}")
    subprocess.run(f"cp version_catalog/build/version-catalog/libs.versions.toml {home}/.gradle", shell=True, cwd=f"{home}")
    subprocess.run("./gradlew hayden-bom build", shell=True, cwd=f"{home}/hayden-bom")
    subprocess.run("./gradlew hayden-bom-plugin:build", shell=True, cwd=f"{home}")
    subprocess.run("./gradlew hayden-bom-plugin:publishToMavenLocal", shell=True, cwd=f"{home}")

run_prcesses()