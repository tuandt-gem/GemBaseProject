# GemBaseProject
Core and sample for VIPER code structure

## Usage ##
Add following settings to your project gradle

1. Add to your root project build.gradle.
If already have ```"allprojects"``` block, just add jitpack maven repo url only

```
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

2. Add dependency to your module build.gradle
```
compile 'com.github.tuandt-gem:GemBaseProject:1.0.1'
```
3. Sync project & <b>ENJOY</b>

