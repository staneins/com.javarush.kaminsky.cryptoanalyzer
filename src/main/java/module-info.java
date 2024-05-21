module com.javarush.cryptoanalyzer.kaminsky {
    requires javafx.controls;
    requires javafx.fxml;


    opens analyzer to javafx.fxml;
    exports analyzer;
    exports service;
    opens service to javafx.fxml;
    exports controller;
    opens controller to javafx.fxml;
}