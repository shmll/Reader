package org.swdc.reader.ui.views.dialog;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.swdc.reader.anno.UIMethod;
import org.swdc.reader.ui.ApplicationConfig;
import org.swdc.reader.ui.AwsomeIconData;
import org.swdc.reader.utils.UIUtils;
import org.xspring.javafx.AbstractFxmlView;
import org.xspring.javafx.FXMLView;
import org.xspring.javafx.GUIState;

import javax.annotation.PostConstruct;

/**
 * Created by lenovo on 2019/5/25.
 */
@FXMLView("/views/dialogs/TypeAddDialog.fxml")
public class TypeAddDialog extends AbstractFxmlView {

    @Autowired
    private ApplicationConfig config;

    private Stage stage;

    @PostConstruct
    protected void initUI() throws Exception {
        UIUtils.configUI((BorderPane)this.getView(), config);
        Platform.runLater(() -> {
            stage = new Stage();
            Scene scene = new Scene(this.getView());
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initOwner(GUIState.getStage());
            stage.setTitle("添加分类");
            stage.getIcons().addAll(AwsomeIconData.getImageIcons());
            stage.initModality(Modality.APPLICATION_MODAL);
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
