package uz.zafarbek.mytaxi.buildsrc

object Libs {

    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.3"

    object Google {
        private const val googleServicesVersion = "4.3.10"
        private const val googleAuthVersion = "20.1.0"
        const val googleServicesGradlePlugin =
            "com.google.gms:google-services:$googleServicesVersion"
        const val googleAuth = "com.google.android.gms:play-services-auth:$googleAuthVersion"
    }

    object Firebase {
        private const val firebaseBoomVersion = "29.1.0"
        private const val crashlyticsGradlePluginVersion = "2.8.1"

        const val bom = "com.google.firebase:firebase-bom:$firebaseBoomVersion"
        const val analytics = "com.google.firebase:firebase-analytics-ktx"
        const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"

        const val crashlyticsGradlePlugin =
            "com.google.firebase:firebase-crashlytics-gradle:$crashlyticsGradlePluginVersion"
    }

    object Kotlin {
        private const val version = "1.6.0"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"
    }

    object Lifecycle {
        private const val version = "2.4.0"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
    }

    object Coroutines {
        private const val version = "1.5.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object OkHttp {
        private const val version = "4.9.1"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val logging = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val fragment = "androidx.fragment:fragment-ktx:1.3.6"
        const val window = "androidx.window:window:1.0.0-beta04"

        object Constraint {
            private const val version = "2.1.1"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:$version"
        }
    }

    object Material {
        private const val version = "1.4.0"
        const val material = "com.google.android.material:material:$version"
    }

    object Room {
        private const val version = "2.4.0"
        const val runtime = "androidx.room:room-runtime:$version"
        const val ktx = "androidx.room:room-ktx:$version"
        const val kapt = "androidx.room:room-compiler:$version"
    }

    object Coil {
        private const val version = "1.4.0"
        const val coil = "io.coil-kt:coil:$version"
    }

    object Multidex {
        private const val version = "2.0.1"
        const val multidex = "androidx.multidex:multidex:$version"
    }

    object Hilt {
        private const val version = "2.38.1"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val hilt = "com.google.dagger:hilt-android:$version"
        const val hiltKapt = "com.google.dagger:hilt-android-compiler:$version"
    }

    object ConstraintLayout {
        private const val version = "2.1.2"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:$version"
    }

    object Navigation {
        private const val version = "2.3.5"
        const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val navigation_ui = "androidx.navigation:navigation-ui-ktx:$version"
        const val navigation_dynamic =
            "androidx.navigation:navigation-dynamic-features-fragment:$version"
        const val safe_args = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        const val common = "androidx.navigation:navigation-common-ktx:$version"
    }

    object DataStore {
        private const val version = "1.0.0"
        const val datastore =
            "androidx.datastore:datastore-preferences:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val retrofit_moshi = "com.squareup.retrofit2:converter-moshi:$version"
    }

    object Moshi {
        private const val version = "1.13.0"
        const val moshi = "com.squareup.moshi:moshi-kotlin:$version"
        const val kapt = "com.squareup.moshi:moshi-kotlin-codegen:$version"
    }

    object Paging {
        private const val version = "3.1.0"
        const val paging = "androidx.paging:paging-runtime-ktx:$version"
    }

    object Chucker {
        private const val version = "3.5.2"
        const val chucker_debug = "com.github.chuckerteam.chucker:library:$version"
        const val chucker_release = "com.github.chuckerteam.chucker:library-no-op:$version"
    }

    object Tests {
        private const val junitVersion = "4.13.2"
        private const val junitTestVersion = "1.1.3"
        private const val espressoCoreVersion = "3.4.0"
        private const val coroutineVersion = "1.3.2"

        const val junit = "junit:junit:$junitVersion"
        const val junitTest = "androidx.test.ext:junit:$junitTestVersion"
        const val espresso = "androidx.test.espresso:espresso-core:$espressoCoreVersion"
        const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion"
    }

    object Binding {
        private const val version = "7.0.4"
        private const val delegateVersion = "1.5.3"
        const val dataBinding = "androidx.databinding:viewbinding:$version"
        const val viewBindingDelegate =
            "com.github.kirich1409:viewbindingpropertydelegate:$delegateVersion"
    }

    object ExoPlayer {
        private const val version = "2.16.1"

        const val exoPlayer = "com.google.android.exoplayer:exoplayer:$version"
    }

    object Shimmer {
        private const val version = "0.5.0"
        const val shimmer = "com.facebook.shimmer:shimmer:$version"
    }

    object Toasty {
        private const val version = "1.5.2"
        const val toasty = "com.github.GrenderG:Toasty:$version"
    }

    object Glide {
        private const val version = "4.12.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val kapt = "com.github.bumptech.glide:compiler:$version"
    }

    object Zelory {
        private const val version = "3.0.1"
        const val zelory = "id.zelory:compressor:$version"
    }

    object Lottie {
        private const val version = "3.4.0"
        const val lottie = "com.airbnb.android:lottie:$version"
    }

    object PlayCore {
        private const val version = "1.10.3"
        private const val ktxVersion = "1.8.1"
        const val playCore = "com.google.android.play:core:$version"
        const val playCoreKtx = "com.google.android.play:core-ktx:$ktxVersion"
    }

    object WorkManager {
        private const val version = "2.8.0-alpha01"
        const val work = "androidx.work:work-runtime-ktx:$version"
    }

    object ScrollProgress {
        private const val version="1.5.1"
        const val scrollProgress="com.shuhart.stepview:stepview:$version"
    }
}