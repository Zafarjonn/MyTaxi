package uz.zafarbek.mytaxi.buildsrc

object Constants {
    object App {
        const val applicationId = "uz.zafarbek.mytaxi"
        const val minSdk = 21
        const val targetSdk = 31
        const val versionCode = 4
        const val versionName = "1.0.0"
        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Build {
        const val compileSdk = 31
        const val jvmTarget = "1.8"
    }

    object Modules {
        const val app = ":app"
        const val core = ":core"
        const val domain = ":domain"
        const val main = ":main"
        const val navigation = ":navigation"
        const val orders = ":orders"
        const val exams = ":exams"
        const val profile = ":profile"
        const val database = ":database"
        const val network = ":network"
        const val datastore = ":datastore"
    }
}