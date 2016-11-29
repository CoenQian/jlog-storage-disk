# jlog-storage-disk

[![License](https://img.shields.io/badge/License-Apache%202.0-brightgreen.svg)](https://github.com/JiongBull/jlog-storage-disk/blob/master/LICENSE.md)
[![Download](https://jitpack.io/v/JiongBull/jlog-storage-disk.svg)](https://jitpack.io/#JiongBull/jlog-storage-disk)
[![Build Status](https://travis-ci.org/JiongBull/jlog-storage-disk.svg?branch=master)](https://travis-ci.org/JiongBull/jlog-storage-disk)

jlog-storage-disk是[jlog](https://github.com/JiongBull/jlog)的扩展插件，设置日志的存储空间，超过容量后会按日志的最后修改时间清理，时间越早的越先被清理掉，大约清理出一半配置空间的时停止。

## 特点

* 设置日志存储的空间
* 定期清理日志释放空间

## 依赖

在根目录的build.gradle里添加仓库。

```groovy
allprojects {
 repositories {
    jcenter()
    maven { url "https://jitpack.io" }
 }
```

在模块的build.gradle中添加依赖。

```groovy
dependencies {
     compile 'com.github.JiongBull:jlog-storage-disk:0.0.1'
}
```

## 配置

### 初始化

建议在你的application的`onCreate()`方法里初始化jlog和jlog-storage-disk的全局配置，设置一次终身受用。

```java
public class RootApp extends Application {

    private static Logger sLogger;

    @Override
    public void onCreate() {
        super.onCreate();

        DiskConfigs diskConfigs = DiskConfigs.Builder.newBuilder()
                /* 下面的属性都是默认值，你可以根据需求决定是否修改他们. */
                .setCapacity(20 * 1024 * 1024)
                .build();

        sLogger = Logger.Builder.newBuilder(getApplicationContext(), "jlog")
                .setWriteToFile(true)
                .setStorage(new DiskStorage(diskConfigs)).build();
    }

    public static Logger getLogger() {
        return sLogger;
    }
}
```

## 关于

[![GitHub](https://img.shields.io/badge/GitHub-JiongBull-blue.svg)](https://github.com/JiongBull)
[![WeiBo](https://img.shields.io/badge/weibo-JiongBull-blue.svg)](https://weibo.com/jiongbull)
[![Blog](https://img.shields.io/badge/Blog-JiongBull-blue.svg)](http://jiongbull.com)
