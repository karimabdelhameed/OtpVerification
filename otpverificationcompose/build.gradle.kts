plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    `maven-publish`
//    signing
}

android {
    namespace = "com.libfactory.otpverificationcompose"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

// Maven publishing configuration
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.karimabdelhameed"
                artifactId = "OtpVerification"
                version = "1.0.0-alpha04"
            }
        }
    }
//    publishing {
//        publications {
//            register<MavenPublication>("release") {
//                groupId = "io.github.karimabdelhameed"
//                artifactId = "otp-verification-compose"
//                version = "1.0.0-alpha03"
//                artifact("$buildDir/outputs/aar/otpverificationcompose-release.aar") {
//                    classifier = "release" // Prevents duplicate artifacts
//                }
//
//                from(components.getByName("release"))
//
//                pom {
//                    name.set("otp-verification-compose")
//                    description.set("A Jetpack Compose library for OTP verification.")
//                    url.set("https://github.com/karimabdelhameed/OtpVerification")
//
//                    licenses {
//                        license {
//                            name.set("The Apache License, Version 2.0")
//                            url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
//                        }
//                    }
//
//                    developers {
//                        developer {
//                            id.set("karimabdelhameed")
//                            name.set("Karim")
//                            email.set("karim.abdelhameed2909@gmail.com")
//                        }
//                    }
//
//                    scm {
//                        connection.set("scm:git:https://github.com/karimabdelhameed/OtpVerification.git")
//                        developerConnection.set("scm:git:https://github.com/karimabdelhameed/OtpVerification.git")
//                        url.set("https://github.com/karimabdelhameed/OtpVerification")
//                    }
//                }
//            }
//        }
//
//        // Publish to Maven Central
//        repositories {
//            maven {
//                name = "sonatype"
//                url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
////                val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
////                val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
////                url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
//
//                credentials {
//                    username = findProperty("ossrhUsername") as String? ?: ""
//                    password = findProperty("ossrhPassword") as String? ?: ""
//                }
//            }
//        }
//    }
//
//    // GPG signing
//    signing {
//        useGpgCmd()
//        sign(publishing.publications)
//    }
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}