module FReader {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires java.sql;
    requires net.bytebuddy;
    requires lombok;
    requires com.fasterxml.classmate;

    requires spring.core;

    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    requires spring.boot.starter;
    requires java.annotation;
    requires fx.spring.boot.starter;
    requires java.desktop;
    requires pinyin4j;
    requires epublib.core;
    requires org.jsoup;
    requires org.controlsfx.controls;
    requires spring.context;
    requires pdfbox;
    requires javafx.web;
    requires spring.beans;
    requires cpdetector;
    requires org.aspectj.weaver;
    requires jdk.jsobject;
    requires mobi.java;

    opens org.swdc.reader to
            spring.core,
            spring.beans,
            spring.context,
            spring.data.jpa,
            javafx.graphics,
            fx.spring.boot.starter;

    opens org.swdc.reader.ui to
            spring.beans,
            spring.boot,
            spring.core,
            spring.context,
            org.controlsfx.controls,
            fx.spring.boot.starter;

    opens org.swdc.reader.ui.views to
            spring.beans,
            spring.boot,
            spring.core;

    opens org.swdc.reader.ui.views.dialog to
            spring.context,
            spring.beans,
            spring.boot,
            spring.core;

    opens org.swdc.reader.ui.controllers.dialog to
            spring.context,
            spring.beans,
            spring.boot,
            javafx.fxml,
            spring.core;

    opens org.swdc.reader.ui.controllers to
            spring.core,
            spring.beans,
            spring.context,
            javafx.fxml;

    opens org.swdc.reader.services to
            spring.core,
            spring.beans,
            spring.context;

    opens org.swdc.reader.repository to
            spring.core,spring.beans,
            spring.context,
            spring.data.jpa;

    opens org.swdc.reader.entity to
            spring.core,
            spring.beans,
            org.hibernate.orm.core;

    opens org.swdc.reader.aspects to
            spring.core,
            spring.aop,
            spring.beans;

    opens org.swdc.reader.anno to
            spring.core,
            spring.beans,
            spring.context;

    opens org.swdc.reader.event to
            spring.core,
            spring.beans,
            spring.context;

    opens org.swdc.reader.core.configs to
            spring.core,
            spring.boot,
            org.controlsfx.controls,
            spring.beans;

    opens org.swdc.reader.core.ext to
            spring.core,
            spring.beans;

    opens org.swdc.reader.core.readers to
            spring.core,
            spring.beans;

    opens org.swdc.reader.core.views to
            spring.core,
            spring.beans;

    opens org.swdc.reader.ui.cells to
            spring.core,
            spring.beans;

    opens views to fx.spring.boot.starter;
    opens views.cells to fx.spring.boot.starter;
    opens views.dialogs to fx.spring.boot.starter;
    opens icon to fx.spring.boot.starter;
    opens images to fx.spring.boot.starter;
    opens style to fx.spring.boot.starter;
}