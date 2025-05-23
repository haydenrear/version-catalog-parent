plugins {
    `version-catalog`
    `maven-publish`
}

group = "com.hayden"
version = "0.0.4"

repositories {
    mavenLocal()
}

project.ext["springCloudVersion"] = "2024.0.1"
project.ext["springBootVersion"] = "3.4.5"
project.ext["springIntegrationVersion"] = "6.2.1"
project.ext["springAiVersion"] = "1.0.0"
project.ext["openTelemetryVersion"] = "1.42.1"
project.ext["springShellVersion"] = "3.4.0"

catalog {
    versionCatalog {

        library("netflixDgsLib", "com.netflix.graphql.dgs.codegen:graphql-dgs-codegen-gradle:6.4.0-SNAPSHOT")
        library("springBoot", "org.springframework.boot:spring-boot-gradle-plugin:${property("springBootVersion")}")
        library("springAiServer", "org.springframework.ai:spring-ai-starter-mcp-server:${property("springAiVersion")}")
        bundle("springAiServer", mutableListOf("springAiServer"))

        library("springAiVectorStoreAdvisor", "org.springframework.ai:spring-ai-advisors-vector-store:${property("springAiVersion")}")
        library("springAiVectorStore", "org.springframework.ai:spring-ai-starter-vector-store-pgvector:${property("springAiVersion")}")
        library("springAiChat", "org.springframework.ai:spring-ai-client-chat:${property("springAiVersion")}")
        bundle("springAi", mutableListOf("springAiVectorStoreAdvisor", "springAiVectorStore", "springAiChat"))

        library("springAiClient", "org.springframework.ai:spring-ai-starter-mcp-client:${property("springAiVersion")}")
        bundle("springAiClient", mutableListOf("springAiClient"))

        library("springDependencyManagement", "io.spring.gradle:dependency-management-plugin:1.1.7")
        library("kotlinGradle", "org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")

        library("aspectJWeaver", "org.aspectj:aspectjweaver:1.9.7")

//        library("vertexAi", "com.google.cloud:google-cloud-vertexai:1.9.0")

        library("dglPytorchJni", "ai.djl.pytorch:pytorch-jni:2.0.1-0.25.0")
        library("dglPytorchEngine", "ai.djl.pytorch:pytorch-engine:0.25.0")
        library("dglPytorchNativeCpu", "ai.djl.pytorch:pytorch-native-cpu:2.0.1")
        library("dglApi", "ai.djl:api:0.24.0")
        bundle("dgl", mutableListOf("dglPytorchJni", "dglPytorchEngine", "dglPytorchNativeCpu", "dglApi"))


        library("bcProvider", "org.bouncycastle:bcprov-jdk18on:1.76")
        library("bcTls", "org.bouncycastle:bctls-jdk18on:1.76")
        library("bcPkix", "org.bouncycastle:bcpkix-jdk18on:1.76")
        bundle("bc", mutableListOf("bcProvider", "bcTls", "bcPkix"))

        library("dgsCodegenCore","com.netflix.graphql.dgs.codegen:graphql-dgs-codegen-core:6.4.0-SNAPSHOT")
        library("dgsCodegenCoreShared","com.netflix.graphql.dgs.codegen:graphql-dgs-codegen-shared-core:6.4.0-SNAPSHOT")
        library("dgsMocking", "com.netflix.graphql.dgs:graphql-dgs-mocking:9.1.1")
        library("dgsApolloFederation", "com.apollographql.federation:federation-graphql-java-support:5.0.0")
        bundle("dgs", mutableListOf("dgsCodegenCore", "dgsMocking", "dgsApolloFederation", "dgsCodegenCoreShared"))


        library("droolsEngine", "org.drools:drools-engine:8.44.0.Final")
        library("droolsMvel", "org.drools:drools-mvel:8.44.0.Final")
        bundle("drools", mutableListOf("droolsEngine", "droolsMvel"))

        library("opentelemtrySemConv", "io.opentelemetry.instrumentation:opentelemetry-instrumentation-api-semconv:1.33.6-alpha")
        library("opentelemtryLogback", "io.opentelemetry.instrumentation:opentelemetry-logback-appender-1.0:2.8.0-alpha")
        library("opentelemtryInstrumentationApi", "io.opentelemetry.instrumentation:opentelemetry-instrumentation-api:2.8.0")
        library("opentelemtrySpringBootStarter", "io.opentelemetry.instrumentation:opentelemetry-spring-boot-starter:2.8.0")
        library("opentelemtryAnnotations", "io.opentelemetry.instrumentation:opentelemetry-instrumentation-annotations:2.8.0")
        library("opentelemtryJdbc", "io.opentelemetry.instrumentation:opentelemetry-jdbc:2.8.0-alpha")

        bundle("opentelemetry", mutableListOf(
            "opentelemtrySemConv", "opentelemtryLogback", "opentelemtryInstrumentationApi",
            "opentelemtrySpringBootStarter", "opentelemtryAnnotations", "opentelemtryJdbc"
        ))


        library("springCloudBom", "org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
        library("springBootDependenciesBom", "org.springframework.boot:spring-boot-dependencies:${property("springBootVersion")}")
        library("springIntegrationBom", "org.springframework.integration:spring-integration-bom:${property("springIntegrationVersion")}")
        library("springAiBom", "org.springframework.ai:spring-ai-bom:${property("springAiVersion")}")
        library("openTelemetryBom", "io.opentelemetry:opentelemetry-bom:${property("openTelemetryVersion")}")
        library("springShellBom", "org.springframework.shell:spring-shell-dependencies:${property("springShellVersion")}")


        bundle("externalBoms", mutableListOf(
            "springCloudBom", "springBootDependenciesBom",
            "springIntegrationBom", "openTelemetryBom",
            "springShellBom", "springAiBom"
        ))

    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["versionCatalog"])
        }
    }
}