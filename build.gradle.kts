plugins {
    kotlin("jvm") version "2.1.20"
    id("com.qqviaja.gradle.MybatisGenerator") version "2.5"
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.mybatis:mybatis:3.5.19")
    implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.5.2")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client:3.5.3")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

mybatisGenerator {
    verbose = true
    configFile = "${projectDir}/src/main/resources/generatorConfig.xml"
    mybatisProperties.putAll(mapOf(
        "driverClass" to "org.mariadb.jdbc.Driver",
        "connectionURL" to "jdbc:mariadb://127.0.0.1:3306/example",
        "username" to "root",
        "password" to "maria",
        //docker run --rm -d -e MARIADB_ROOT_PASSWORD=maria -p 3306:3306 --name mariadb mariadb:lts
        //の --name mariadb がパスワード
    ))
    dependencies {
        mybatisGenerator("org.mybatis.generator:mybatis-generator-core:1.4.2")
        mybatisGenerator("org.mariadb.jdbc:mariadb-java-client:3.5.3")
    }
}