package com.hayden.haydenbomplugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware

open class Libraries {

        val aspectJWeaver = "org.aspectj:aspectjweaver:1.9.7"
        

        val bcPkix = "org.bouncycastle:bcpkix-jdk18on:1.76"
        

        val bcProvider = "org.bouncycastle:bcprov-jdk18on:1.76"
        

        val bcTls = "org.bouncycastle:bctls-jdk18on:1.76"
        

        val dglApi = "ai.djl:api:0.24.0"
        

        val dglPytorchEngine = "ai.djl.pytorch:pytorch-engine:0.25.0"
        

        val dglPytorchJni = "ai.djl.pytorch:pytorch-jni:2.0.1-0.25.0"
        

        val dglPytorchNativeCpu = "ai.djl.pytorch:pytorch-native-cpu:2.0.1"
        

        val dgsApolloFederation = "com.apollographql.federation:federation-graphql-java-support:5.0.0"
        

        val dgsCodegenCore = "com.netflix.graphql.dgs.codegen:graphql-dgs-codegen-core:6.4.0-SNAPSHOT"
        

        val dgsCodegenCoreShared = "com.netflix.graphql.dgs.codegen:graphql-dgs-codegen-shared-core:6.4.0-SNAPSHOT"
        

        val dgsMocking = "com.netflix.graphql.dgs:graphql-dgs-mocking:9.1.1"
        

        val droolsEngine = "org.drools:drools-engine:8.44.0.Final"
        

        val droolsMvel = "org.drools:drools-mvel:8.44.0.Final"
        

        val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.0"
        

        val netflixDgsLib = "com.netflix.graphql.dgs.codegen:graphql-dgs-codegen-gradle:6.4.0-SNAPSHOT"
        

        val openTelemetryBom = "io.opentelemetry:opentelemetry-bom:1.42.1"
        

        val opentelemtryAnnotations = "io.opentelemetry.instrumentation:opentelemetry-instrumentation-annotations:2.8.0"
        

        val opentelemtryInstrumentationApi = "io.opentelemetry.instrumentation:opentelemetry-instrumentation-api:2.8.0"
        

        val opentelemtryJdbc = "io.opentelemetry.instrumentation:opentelemetry-jdbc:2.8.0-alpha"
        

        val opentelemtryLogback = "io.opentelemetry.instrumentation:opentelemetry-logback-appender-1.0:2.8.0-alpha"
        

        val opentelemtrySemConv = "io.opentelemetry.instrumentation:opentelemetry-instrumentation-api-semconv:1.33.6-alpha"
        

        val opentelemtrySpringBootStarter = "io.opentelemetry.instrumentation:opentelemetry-spring-boot-starter:2.8.0"
        

        val springAiBom = "org.springframework.ai:spring-ai-bom:1.0.0"
        

        val springAiChat = "org.springframework.ai:spring-ai-client-chat:1.0.0"
        

        val springAiClient = "org.springframework.ai:spring-ai-starter-mcp-client:1.0.0"
        

        val springAiServer = "org.springframework.ai:spring-ai-starter-mcp-server:1.0.0"
        

        val springAiVectorStore = "org.springframework.ai:spring-ai-starter-vector-store-pgvector:1.0.0"
        

        val springAiVectorStoreAdvisor = "org.springframework.ai:spring-ai-advisors-vector-store:1.0.0"
        

        val springBoot = "org.springframework.boot:spring-boot-gradle-plugin:3.4.5"
        

        val springBootDependenciesBom = "org.springframework.boot:spring-boot-dependencies:3.4.5"
        

        val springCloudBom = "org.springframework.cloud:spring-cloud-dependencies:2024.0.1"
        

        val springDependencyManagement = "io.spring.gradle:dependency-management-plugin:1.1.7"
        

        val springIntegrationBom = "org.springframework.integration:spring-integration-bom:6.2.1"
        

        val springModulithBom = "org.springframework.modulith:spring-modulith-bom:1.4.3"
        

        val springShellBom = "org.springframework.shell:spring-shell-dependencies:3.4.0"
        }

open class Plugins {
}

open class Bundles {

        open class BcBundle {
                val bcProvider = "org.bouncycastle:bcprov-jdk18on:1.76"
            
                val bcTls = "org.bouncycastle:bctls-jdk18on:1.76"
            
                val bcPkix = "org.bouncycastle:bcpkix-jdk18on:1.76"
            
        open fun inBundle(): List<String> {
            return mutableListOf(
        bcProvider, bcTls, bcPkix)}}
val bcBundle = BcBundle()

        

        open class DglBundle {
                val dglPytorchJni = "ai.djl.pytorch:pytorch-jni:2.0.1-0.25.0"
            
                val dglPytorchEngine = "ai.djl.pytorch:pytorch-engine:0.25.0"
            
                val dglPytorchNativeCpu = "ai.djl.pytorch:pytorch-native-cpu:2.0.1"
            
                val dglApi = "ai.djl:api:0.24.0"
            
        open fun inBundle(): List<String> {
            return mutableListOf(
        dglPytorchJni, dglPytorchEngine, dglPytorchNativeCpu, dglApi)}}
val dglBundle = DglBundle()

        

        open class DgsBundle {
                val dgsCodegenCore = "com.netflix.graphql.dgs.codegen:graphql-dgs-codegen-core:6.4.0-SNAPSHOT"
            
                val dgsMocking = "com.netflix.graphql.dgs:graphql-dgs-mocking:9.1.1"
            
                val dgsApolloFederation = "com.apollographql.federation:federation-graphql-java-support:5.0.0"
            
                val dgsCodegenCoreShared = "com.netflix.graphql.dgs.codegen:graphql-dgs-codegen-shared-core:6.4.0-SNAPSHOT"
            
        open fun inBundle(): List<String> {
            return mutableListOf(
        dgsCodegenCore, dgsMocking, dgsApolloFederation, dgsCodegenCoreShared)}}
val dgsBundle = DgsBundle()

        

        open class DroolsBundle {
                val droolsEngine = "org.drools:drools-engine:8.44.0.Final"
            
                val droolsMvel = "org.drools:drools-mvel:8.44.0.Final"
            
        open fun inBundle(): List<String> {
            return mutableListOf(
        droolsEngine, droolsMvel)}}
val droolsBundle = DroolsBundle()

        

        open class ExternalbomsBundle {
                val springCloudBom = "org.springframework.cloud:spring-cloud-dependencies:2024.0.1"
            
                val springBootDependenciesBom = "org.springframework.boot:spring-boot-dependencies:3.4.5"
            
                val springIntegrationBom = "org.springframework.integration:spring-integration-bom:6.2.1"
            
                val openTelemetryBom = "io.opentelemetry:opentelemetry-bom:1.42.1"
            
                val springShellBom = "org.springframework.shell:spring-shell-dependencies:3.4.0"
            
                val springAiBom = "org.springframework.ai:spring-ai-bom:1.0.0"
            
                val springModulithBom = "org.springframework.modulith:spring-modulith-bom:1.4.3"
            
        open fun inBundle(): List<String> {
            return mutableListOf(
        springCloudBom, springBootDependenciesBom, springIntegrationBom, openTelemetryBom, springShellBom, springAiBom, springModulithBom)}}
val externalBomsBundle = ExternalbomsBundle()

        

        open class OpentelemetryBundle {
                val opentelemtrySemConv = "io.opentelemetry.instrumentation:opentelemetry-instrumentation-api-semconv:1.33.6-alpha"
            
                val opentelemtryLogback = "io.opentelemetry.instrumentation:opentelemetry-logback-appender-1.0:2.8.0-alpha"
            
                val opentelemtryInstrumentationApi = "io.opentelemetry.instrumentation:opentelemetry-instrumentation-api:2.8.0"
            
                val opentelemtrySpringBootStarter = "io.opentelemetry.instrumentation:opentelemetry-spring-boot-starter:2.8.0"
            
                val opentelemtryAnnotations = "io.opentelemetry.instrumentation:opentelemetry-instrumentation-annotations:2.8.0"
            
                val opentelemtryJdbc = "io.opentelemetry.instrumentation:opentelemetry-jdbc:2.8.0-alpha"
            
        open fun inBundle(): List<String> {
            return mutableListOf(
        opentelemtrySemConv, opentelemtryLogback, opentelemtryInstrumentationApi, opentelemtrySpringBootStarter, opentelemtryAnnotations, opentelemtryJdbc)}}
val opentelemetryBundle = OpentelemetryBundle()

        

        open class SpringaiBundle {
                val springAiVectorStoreAdvisor = "org.springframework.ai:spring-ai-advisors-vector-store:1.0.0"
            
                val springAiVectorStore = "org.springframework.ai:spring-ai-starter-vector-store-pgvector:1.0.0"
            
                val springAiChat = "org.springframework.ai:spring-ai-client-chat:1.0.0"
            
        open fun inBundle(): List<String> {
            return mutableListOf(
        springAiVectorStoreAdvisor, springAiVectorStore, springAiChat)}}
val springAiBundle = SpringaiBundle()

        

        open class SpringaiclientBundle {
                val springAiClient = "org.springframework.ai:spring-ai-starter-mcp-client:1.0.0"
            
        open fun inBundle(): List<String> {
            return mutableListOf(
        springAiClient)}}
val springAiClientBundle = SpringaiclientBundle()

        

        open class SpringaiserverBundle {
                val springAiServer = "org.springframework.ai:spring-ai-starter-mcp-server:1.0.0"
            
        open fun inBundle(): List<String> {
            return mutableListOf(
        springAiServer)}}
val springAiServerBundle = SpringaiserverBundle()

        }

open class BuildSrcVersionCatalogCollector(val project: Project) {

    val libs = Libraries()
    val plugins = Plugins()
    val bundles = Bundles()

}

// TODO: hayden bom generator - generate this plugin with accessors.
class BomPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        val extension = target.extensions.create("buildSrcLibs", BuildSrcVersionCatalogCollector::class.java)
    }
}