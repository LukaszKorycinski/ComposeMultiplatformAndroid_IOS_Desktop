plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader

//    kotlin("android").version("1.8.0").apply(false)
//    kotlin("multiplatform").version("1.8.0").apply(false)
    kotlin("multiplatform").apply(false)
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    id("org.jetbrains.compose").apply(false)
}
