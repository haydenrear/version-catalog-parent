plugins {
    `java-platform`
    `maven-publish`
}


group = "com.hayden"
version = "0.0.3"

javaPlatform {
    allowDependencies()
}

repositories {
    mavenLocal()
}

dependencies {
//    api(platform(vC.vertexAi))
}

publishing {
    publications {
        create<MavenPublication>("bom") {
            from(components["javaPlatform"])
        }
    }
}
