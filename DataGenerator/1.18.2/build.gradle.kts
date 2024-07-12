plugins {
    id("org.spongepowered.gradle.vanilla")
}

dependencies {
    implementation(project(":DataGenerator:1.16.3"))
    implementation(project(":DataGenerator:1.17"))
    implementation(project(":DataGenerator:1.18"))
    implementation(project(":DataGenerator:core"))
}

configurations {
    runtimeClasspath {
        // We want to exclude the 1.18 JAR from the runtime, we include the version we want in the run options.
        exclude("net.minecraft", "server")
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
        vendor.set(JvmVendorSpec.ADOPTIUM)
    }
}

minecraft {
    version("1.18.2")
    platform(org.spongepowered.gradle.vanilla.repository.MinecraftPlatform.SERVER)
}