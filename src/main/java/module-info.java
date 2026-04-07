module is.vidmot {
    requires javafx.controls;
    requires javafx.fxml;


    opens is.vidmot to javafx.fxml;
    opens is.vidmot.controller to javafx.fxml;
    opens is.vidmot.switcher to javafx.fxml;
    opens is.vidmot.view to javafx.fxml;
    exports is.vidmot;
    exports is.vidmot.controller;
    exports is.vidmot.switcher;
}