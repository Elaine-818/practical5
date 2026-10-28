# Practical Five - Chinese Municipalities Android App

## Project Structure

```
PracticalFive/
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/example/practicalfive/
│           │       ├── MainActivity.java      (Main screen)
│           │       ├── Municipality.java      (Detail screen)
│           │       └── TextProcessor.java     (Validation logic)
│           ├── res/
│           │   ├── layout/
│           │   │   ├── activity_main.xml
│           │   │   └── activity_municipality.xml
│           │   ├── values/
│           │   │   ├── strings.xml
│           │   │   ├── colors.xml
│           │   │   └── arrays.xml
│           │   ├── drawable/
│           │   │   ├── chinese_municipalities.png
│           │   │   ├── beijing.jpg
│           │   │   ├── shanghai.jpg
│           │   │   ├── tianjin.jpg
│           │   │   └── chongqing.jpg
│           │   └── mipmap-hdpi/
│           │       └── ic_launcher.png
│           └── AndroidManifest.xml
└── Quiz_9_Answers.md
```

## How to Import into Android Studio

1. Open Android Studio
2. Select **File → New → Import Project**
3. Choose this `PracticalFive` folder
4. Let Gradle sync complete

> Note: This folder contains the `app/src/main` source tree. When importing, Android Studio may ask you to set up Gradle wrapper and build files. Alternatively, create a new project named "PracticalFive" with Empty Views Activity, Java language, and copy the contents of `app/src/main` into the generated project.

## Features Implemented

- [x] Main screen with title, China map image, and input field
- [x] Case-insensitive municipality validation (TextProcessor class)
- [x] Explicit Intent navigation to detail screen
- [x] Four municipalities: Beijing, Shanghai, Tianjin, Chongqing
- [x] Dynamic colour themes per municipality
- [x] Dynamic image per municipality
- [x] Scrollable information text from string array
- [x] "Visit site" button with implicit Intent (ACTION_VIEW)
- [x] Error handling for empty / invalid input
- [x] Named colour and string resources (no hard-coded values)
