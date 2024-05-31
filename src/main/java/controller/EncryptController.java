package controller;

import analyzer.BruteForce;
import analyzer.Encryptor;
import analyzer.FileManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Path;

public class EncryptController {

    private final FileManager fileManager = new FileManager();
    private final Encryptor encryptor = new Encryptor();
    private final BruteForce bruteForce = new BruteForce();
    private String encryptPath;
    private String decryptPath;
    private String bruteforcePath;
    private final String defaultPath = "/run/media/philipk/68220e73-ac0a-41b6-b3bb-cb3b9497ba49/git/com.javarush.cryptoanalyzer.kaminsky.2/src/main/resources/out.txt";

    @FXML
    private TextField enterCipherOffset;
    @FXML
    private TextField enterDecipherOffset;

    @FXML
    protected String onChooseFileEncryptButtonClick() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        encryptPath = file.getAbsolutePath();
        return encryptPath;
    }

    @FXML
    protected String onChooseFileDecipherButtonClick() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        decryptPath = file.getAbsolutePath();
        return decryptPath;
    }

    @FXML
    protected String onChooseFileBruteforceButtonClick() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        bruteforcePath = file.getAbsolutePath();
        return bruteforcePath;
    }

    @FXML
    protected void onDoDecryptButtonClick() {
        fileManager.writeFile(encryptor.decrypt(fileManager.readFile(encryptPath), Integer.parseInt(enterDecipherOffset.getText())), defaultPath);
    }

    @FXML
    protected void onDoEncryptButtonClick() {
        fileManager.writeFile(encryptor.encrypt(fileManager.readFile(encryptPath), Integer.parseInt(enterCipherOffset.getText())), defaultPath);
    }

    @FXML
    protected void onDoBruteforceButtonClick() {
        fileManager.writeFile(bruteForce.decryptByBruteForce(fileManager.readFile(bruteforcePath)), defaultPath);
    }

}
