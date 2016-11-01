# GemBaseProject
Core and sample for VIPER code structure

The sample of VIPER is on ```master``` branch.
The sameple of MVP is on ```mvp``` branch

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
Use VIPER
compile 'com.github.tuandt-gem:GemBaseProject:1.0.2'

Use MVP
compile 'com.github.tuandt-gem:GemBaseProject:mvp1.0'
```
3. Sync project & <b>ENJOY</b>

