plugins {
    `maven-publish`
    `kotlin-dsl`
    `version-catalog`
}

group = "com.hayden"
version = "0.0.4"

dependencies{
    implementation("com.squareup:javapoet:1.10.0")
}

repositories {
    mavenLocal()
    mavenCentral()
}

publishing {
    repositories {
        mavenLocal()
    }
}

gradlePlugin {
    plugins {
        create("bomPlugin") {
            id = "com.hayden.hayden-bom-plugin"
            implementationClass = "com.hayden.haydenbomplugin.BomPlugin"
            version = version.toString()
        }
    }
}
