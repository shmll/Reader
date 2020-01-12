# BookReader Project

## 概述 Abstract

这个是阅读器，用于看电子书的那种，计划支持多数常见的电子书格式以及
RSS（Feed）电子订阅，基于SpringBoot，javaFX。

终于成功升级到JDK13了，终于成功升级到模块化后的java了！！！

this is a Reader for EBooks ，planning supports most common formats like txt epub pdf and more
include RSS （Feeds），based javaFX and SpringBoot

## 如何Build How to build it

别的没啥，启动需要加这个jvm参数。

```
--add-opens=javafx.controls/javafx.scene.control.skin=org.controlsfx.controls
```

## 进度 Process

 - [x] 基础结构搭建（Basic Data Structs)
 - [x] 基础UI的设计和美化 (UI Design)
 - [x] 数据结构建模（DataStruct Design）
 - [x] 核心接口（Core interface）
 - [x] 文本阅读的实现（Text reader implemented）
 - [x] PDF阅读的实现（Adobe PDF reader implement）
 - [x] EPublic阅读的实现（EPUB File Reader implement）