module com.javarush.cryptoanalyzer.kaminsky {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javarush.cryptoanalyzer.kaminsky to javafx.fxml;
    exports com.javarush.cryptoanalyzer.kaminsky;
    exports service;
    opens service to javafx.fxml;
    exports controller;
    opens controller to javafx.fxml;
}