import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "no.nav.kontroll"
version = "1.0-SNAPSHOT"

val logbackVersion = "1.2.3"
val logstashEncoderVersion = "5.1"
val ktorVersion = "1.1.4"
val prometheusVersion = "0.5.0"

plugins {
    id ("org.jetbrains.kotlin.jvm") version "1.3.31"
    id ("com.github.johnrengelman.shadow") version "4.0.4"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
  implementation(kotlin("stdlib-jdk8"))
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("net.logstash.logback:logstash-logback-encoder:$logstashEncoderVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-auth-basic:$ktorVersion")
    implementation("io.ktor:ktor-client-jackson:$ktorVersion")
    implementation("io.prometheus:simpleclient_hotspot:$prometheusVersion")
    implementation("io.prometheus:simpleclient_common:$prometheusVersion")
}

tasks {
   withType<Jar> {
       manifest.attributes["Main-Class"] = "BootstrapKt"
   }

   create("printVersion") {
       doLast {
           println(project.version)
       }
   }

   withType<KotlinCompile> {
       kotlinOptions.jvmTarget = "1.8"
   }

}