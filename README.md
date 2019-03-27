# Android RoundButton
<img src ="https://img.shields.io/badge/version-0.0.4-brightgreen.svg"/>

## Gradle
``` gradle
allprojects {
   repositories {
     ...
      maven { url "https://jitpack.io" }
    }
}
```
``` gradle
dependencies {
    implementation 'com.github.hyeyeon2371:RoundButton:<Latest_Version>'
}
```

## Usage
``` xml
<com.hyeyeon2371.roundbutton.RoundButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"                              
    app:radius="12dp"
    app:txt="text you want"
    app:txtSize="20sp"
    app:bgColor="@color/yellow"
    app:txtColor="@android:color/white"/>
```

## Screenshot
<img src="https://user-images.githubusercontent.com/42951723/55060686-56f96b80-50b5-11e9-82dc-92d3c04541fd.PNG" width="200"/>
