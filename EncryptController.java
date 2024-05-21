package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EncryptController {

    @FXML
    TextField insertKeyField;

    @FXML
    protected void onChooseFileButtonClick() {
        System.out.println("Нажать кнопка выбора файла");
    }

    @FXML
    protected void onDoEncryptButtonClick() {
        System.out.println("Нажата кнопка Ave Caesar");
    }


}
