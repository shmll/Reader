package org.swdc.reader.core.views;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserContext;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.swdc.reader.core.BookView;
import org.xspring.javafx.AbstractFxmlView;
import org.xspring.javafx.FXMLView;

import javax.annotation.PostConstruct;

/**
 * Created by lenovo on 2019/5/31.
 */
@FXMLView
public class TextRenderView extends AbstractFxmlView implements BookView {

    private BrowserView view;

    @Getter
    private final String viewId = "webRenderView";

    @Autowired
    private BrowserContext context;

    @PostConstruct
    protected void initUI() {
        Platform.runLater(() ->{
            this.view = new BrowserView(new Browser(context));
            this.view.setId(viewId);
        });
    }

    @Override
    public Parent getView() {
        return this.view;
    }

    @Override
    public void initToolsView(HBox toolBox) {
        toolBox.getChildren().clear();
    }

}
