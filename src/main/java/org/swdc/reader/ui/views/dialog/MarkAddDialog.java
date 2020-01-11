package org.swdc.reader.ui.views.dialog;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.swdc.reader.anno.UIMethod;
import org.swdc.reader.core.BookReader;
import org.swdc.reader.ui.ApplicationConfig;
import org.swdc.reader.ui.AwsomeIconData;
import org.swdc.reader.utils.UIUtils;
import org.xspring.javafx.AbstractFxmlView;
import org.xspring.javafx.FXMLView;
import org.xspring.javafx.GUIState;

import javax.annotation.PostConstruct;

/**
 * Created by lenovo on 2019/6/7.
 */
@FXMLView("/views/dialogs/MarkCreateDialog.fxml")
public class MarkAddDialog extends AbstractFxmlView {

    @Autowired
    private ApplicationConfig config;

    private Stage stage;

    @Setter
    @Getter
    private BookReader book;

    @PostConstruct
    protected void initUI() throws Exception {
        UIUtils.configUI((BorderPane)getView(), config);
        Platform.runLater(() -> {
            stage = new Stage();
            Scene scene = new Scene(this.getView());
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("添加书签");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(GUIState.getStage());
            stage.getIcons().addAll(AwsomeIconData.getImageIcons());
        });
    }

    @UIMethod
    public void show() {
        if (stage.isShowing()) {
                stage.requestFocus();
        } else {
                stage.show();
        }
    }

    @UIMethod
    public void close() {
        if (stage.isShowing()) {
            stage.close();
        }
    }

}
