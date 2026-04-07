package is.vidmot.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import is.vinnsla.Ferd;

/**
 * Controller fyrir dialog til að bæta við nýrri ferð (ny-ferd-dialog.fxml).
 * Sér um innsláttar reiti og staðfestingu.
 */
public class FerdDialogController {
    /** Innsláttarreitur fyrir nafn ferðar. */
    @FXML
    private TextField nafnField;
    /** Innsláttarreitur fyrir áfangastað. */
    @FXML
    private TextField afangastadurField;
    /** Innsláttarreitur fyrir dagsetningu. */
    @FXML
    private TextField dagsetningField;

    /** Ferðin sem verður til eftir staðfestingu. */
    private Ferd ferd;
    /** Hvort notandi staðfesti innslátt. */
    private boolean confirmed = false;

    /**
     * Bætir við nýrri ferð ef innsláttur er gildur og lokar dialog.
     *
     * @param event atburðurinn frá hnappinum
     */
    @FXML
    private void onBaetaVid(ActionEvent event) {
        if (validateInputs()) {
            ferd = new Ferd(nafnField.getText(), afangastadurField.getText(), dagsetningField.getText());
            confirmed = true;
            closeDialog(event);
        }
    }

    /**
     * Hættir við og lokar dialog án þess að vista.
     *
     * @param event atburðurinn frá hnappinum
     */
    @FXML
    private void onHaettaVid(ActionEvent event) {
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
     * Athugar hvort allir innsláttarreitir séu fylltir út.
     *
     * @return true ef allir reitir eru ekki tómir
     */
    private boolean validateInputs() {
        return !nafnField.getText().trim().isEmpty() &&
                !afangastadurField.getText().trim().isEmpty() &&
                !dagsetningField.getText().trim().isEmpty();
    }

    /**
     * Skilar ferðinni sem var búin til.
     *
     * @return ferð eða null ef ekki staðfest
     */
    public Ferd getFerd() {
        return ferd;
    }

    /**
     * Skilar hvort notandi staðfesti innsláttinn.
     *
     * @return true ef staðfest
     */
    public boolean isConfirmed() {
        return confirmed;
    }
}