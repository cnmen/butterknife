### Field and method binding for Android views which uses annotation processing to generate boilerplate code for you.
#### If you don't know, please click here : [CmonBaby](https://www.cmonbaby.com)

## ButterKnife ![Build Status](https://travis-ci.org/greenrobot/EventBus.svg?branch=master)

* Eliminate findViewById calls by using @BindView on fields
* Eliminate anonymous inner-classes for listeners by annotating methods with @OnClick and others.
* Support for library injection
* Lightweight (~32k jar)

## Usage example

### 1. App projects
```java
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv; // Don't set private or static for properties

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this); // just support activity current
    }

    @OnClick(R.id.btn) // just support one id event
    public void click(View view) {
        startActivity(new Intent(this, LibraryActivity.class));
    }
}
```

### 2. Library projects
#### 1. Your rootDir build.gradle
* To use ButterKnife in a library, add the plugin to your buildscript:
```gradle
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.5.2'

        // add plugin path
        classpath 'com.cmonbaby.butterknife.plugin:butterknife_plugin:2.1.0'
    }
}
```

#### 2. Your android library build.gradle
* And then apply it in your module:
```gradle
apply plugin: 'com.android.library'
apply plugin: 'com.cmonbaby.butterknife.plugin' // add plugin (must be android library)
```

#### 3. Coding
* Now make sure you use R2 instead of R inside all ButterKnife annotations.
```java
public class LibraryActivity extends AppCompatActivity {

    @BindView(id = R2.id.tv) // Use R2 Injection
    TextView tv; // Don't set private or static for properties

    @BindView(id = R2.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        ButterKnife.bind(this); // just support activity current
    }

    @OnClick(id = R2.id.btn) // just support one id event
    public void click(View view) {
        Toast.makeText(this, "hello simon", Toast.LENGTH_SHORT).show();
    }
}
```

## Add ButterKnife to your project
<a href="https://www.cmonbaby.com">
<img src="https://img.shields.io/bintray/v/cmonbaby/simon/butterknife_annotation?label=maven-central"></a>

Via Gradle:
```gradle
implementation 'com.cmonbaby.butterknife.annotation:butterknife_annotation:2.1.0'
implementation 'com.cmonbaby.butterknife.core:butterknife_core:2.1.0'
annotationProcessor 'com.cmonbaby.butterknife.compiler:butterknife_compiler:2.1.0'
```

Via Maven:
```xml
<dependency>
    <groupId>com.cmonbaby.butterknife.annotation</groupId>
    <artifactId>butterknife_annotation</artifactId>
    <version>2.1.0</version>
</dependency>
<dependency>
    <groupId>com.cmonbaby.butterknife.compiler</groupId>
    <artifactId>butterknife_compiler</artifactId>
    <version>2.1.0</version>
</dependency>
<dependency>
    <groupId>com.cmonbaby.butterknife.core</groupId>
    <artifactId>butterknife_core</artifactId>
    <version>2.1.0</version>
</dependency>
```

## License

Copyright (C) 2013-2020 Markus Junginger, Simon (https://www.cmonbaby.com)  
ButterKnife binaries and source code can be used according to the [Apache License, Version 2.0](LICENSE).
