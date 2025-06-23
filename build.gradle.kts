plugins {
    id("java")
}

group = "cv.keller"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.auth:google-auth-library-oauth2-http:1.11.0")
    implementation("com.google.apis:google-api-services-gmail:v1-rev20220404-2.0.0")
    implementation("com.google.oauth-client:google-oauth-client-jetty:1.34.1")
    implementation("javax.mail:mail:1.4.7")
    implementation("org.apache.commons:commons-csv:1.9.0")
    implementation("net.dv8tion:JDA:5.6.1")
    implementation("ch.qos.logback:logback-classic:1.5.6")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-inline:4.8.0")
    testImplementation("org.hamcrest:hamcrest:2.2")
}