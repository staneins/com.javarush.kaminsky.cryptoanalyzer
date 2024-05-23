module com.javarush.cryptoanalyzer.kaminsky {
    requires javafx.controls;
    requires javafx.fxml;


    opens analyzer to javafx.fxml;
    exports analyzer;
    exports controller;
    opens controller to javafx.fxml;
    exports service;
    opens service to javafx.fxml;
}