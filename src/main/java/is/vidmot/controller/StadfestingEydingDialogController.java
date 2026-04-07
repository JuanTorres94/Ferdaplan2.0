package is.vidmot.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * Controller fyrir staðfestingardialog þegar ferð er eytt (stadfestingEyda-dialog.fxml).
 * Sýnir staðfestingarglugga og skráir svar notanda.
 */
public class StadfestingEydingDialogController {
    /** Hvort notandi staðfesti eyðinguna. */
    private boolean confirmed = false;

    /**
     * Staðfestir eyðingu og lokar dialog.
     *
     * @param event atburðurinn frá hnappinum
     */
    @FXML
    private void onConfirm(ActionEvent event) {
        confirmed = true;
        closeDialog(event);
    }

    /**
     * Hættir við eyðingu og lokar dialog.
     *
     * @param event atburðurinn frá hnappinum
     */
    @FXML
    private void onCancel(ActionEvent event) {
        confirmed = false;
        closeDialog(event);
    }

    /**
     * Lokar dialog glugganum.
     *
     * @param event atburðurinn til að finna gluggann
     */
    private void closeDialog(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    /**
     * Skilar hvort notandi staðfesti eyðinguna.
     *
     * @return true ef staðfest
     */
    public boolean isConfirmed() {
        return confirmed;
    }
}