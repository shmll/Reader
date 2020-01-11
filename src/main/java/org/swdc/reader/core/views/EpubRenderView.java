package org.swdc.reader.core.views;

import netscape.javascript.JSObject;

import javafx.application.Platform;
import javafx.concurrent.Worker;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import lombok.Getter;
import lombok.extern.apachecommons.CommonsLog;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.swdc.reader.core.BookView;
import org.swdc.reader.event.BookLocationEvent;
import org.swdc.reader.ui.ApplicationConfig;
import org.xspring.javafx.AbstractFxmlView;
import org.xspring.javafx.FXMLView;

import javax.annotation.PostConstruct;

/**
 * Created by lenovo on 2019/6/13.
 */
@FXMLView
@CommonsLog
public class EpubRenderView extends AbstractFxmlView implements BookView {

    private WebView view;

    @Autowired
    private ApplicationConfig config;

    @Getter
    private final String viewId = "epubRenderView";

    public static class PageControl {

        private ApplicationConfig config;

        public PageControl(ApplicationConfig config){
            this.config = config;
        }

        public void locate(Object location) {
            Elements elem = Jsoup.parse(location.toString()).getElementsByTag("a");
            if (elem.size() == 1) {
                config.publishEvent(new BookLocationEvent(elem.get(0).attr("href")));
            }
        }
    }

    private PageControl control;

    @PostConstruct
    protected void initUI() {
        control = new PageControl(config);
        Platform.runLater(() ->{
            this.view = new WebView();
            this.view.setId(viewId);
            WebEngine engine = this.view.getEngine();
            engine.getLoadWorker().stateProperty().addListener((observableValue, stateOld, stateNew) -> {
                if (stateNew == Worker.State.SUCCEEDED) {
                    JSObject wind = (JSObject) engine.executeScript("window");
                    wind.setMember("swdc", control);
                    engine.executeScript("init()");
                }
            });
        });
    }

    @Override
    public void initToolsView(HBox toolBox) {
        toolBox.getChildren().clear();
    }

    @Override
    public Parent getView() {
        return this.view;
    }
}
