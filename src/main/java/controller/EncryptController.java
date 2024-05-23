package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

public class EncryptController {

    @FXML
    TextField insertKeyField;

    @FXML
    protected void onChooseFileEncryptButtonClick() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
    }

    @FXML
    protected void onDoEncryptButtonClick() {
        System.out.println("Нажата кнопка Ave Caesar");
    }


}
