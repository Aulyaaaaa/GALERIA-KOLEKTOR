plugins {
    id("com.android.application")
    id("kotlin-android")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.galeria.galeria"
    // Dinaikkan manual dari default flutter.compileSdkVersion (36) -- plugin
    // permission_handler_android butuh compileSdk 37+ (lihat pesan build).
    compileSdk = 37
    // Dikunci ke NDK yang sudah terpasang lokal (lihat android/sdk/ndk/) supaya
    // Gradle tidak memicu auto-download via sdkmanager.bat -- di Windows proses
    // itu kadang crash (exit -1073740791 / 0xC0000409). Skeleton ini belum
    // pakai kode native, jadi versi persisnya tidak kritis.
    ndkVersion = "30.0.16248370"

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    defaultConfig {
        // TODO: Specify your own unique Application ID (https://developer.android.com/studio/build/application-id.html).
        applicationId = "com.galeria.galeria"
        // You can update the following values to match your application needs.
        // For more information, see: https://flutter.dev/to/review-gradle-config.
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        release {
            // TODO: Add your own signing config for the release build.
            // Signing with the debug keys for now, so `flutter run --release` works.
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}
