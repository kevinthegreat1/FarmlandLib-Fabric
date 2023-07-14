# Farmland Lib

Makes adding custom farmland blocks much easier. There are several hardcoded checks for the farmland block in vanilla, and mixins are needed to change those. With this library you only need to add the `c:farmlands` tag to your farmland block, and it will function as a normal farmland block in game.  
Currently works on 1.19.3 to 1.20.1.

## Usage

You can install this library using [Jitpack](https://jitpack.io/)

To install the library, add the jitpack repository to your repositories block as described on the website and this to your dependencies block in build.gradle:

```groovy
include modImplementation("com.github.kevinthegreat1:FarmlandLib-Fabric:main-SNAPSHOT")
```
This will use the latest commit as build target, but will cache that build target every time. To get a specific version you can replace `main-SNAPSHOT` with the version number (e.g. `1.0.0`).