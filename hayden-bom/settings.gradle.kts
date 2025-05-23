rootProject.name = "hayden-bom"

dependencyResolutionManagement {
    versionCatalogs {
        repositories {
            mavenLocal()
        }
        create("vC") {
            from("com.hayden:version_catalog:0.0.4")
        }
    }
    repositories {
        mavenLocal()
    }
}
