package org.swdc.reader.core.views;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import lombok.Getter;
import org.swdc.reader.core.BookView;
import org.xspring.javafx.AbstractFxmlView;
import org.xspring.javafx.FXMLView;

import javax.annotation.PostConstruct;

/**
 * Created by lenovo on 2019/6/9.
 */
@FXMLView
public class PDFRenderView extends AbstractFxmlView implements BookView {

    private Canvas canvas;
    private ScrollPane pane;

    @Getter
    private final String viewId = "pdfRenderView";

    @PostConstruct
    protected void initUI(){
        Platform.runLater(() -> {
            canvas = new Canvas();
            pane = new ScrollPane(canvas);
            canvas.widthProperty().bind(pane.widthProperty());
            pane.setId(viewId);
        });
    }

    @Override
    public Parent getView() {
        return pane;
    }

    @Override
    public void initToolsView(HBox toolBox) {
        toolBox.getChildren().clear();
    }
}
