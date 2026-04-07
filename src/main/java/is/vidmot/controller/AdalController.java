package is.vidmot.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import is.vidmot.switcher.View;
import is.vidmot.switcher.ViewSwitcher;
import is.vinnsla.Ferd;
import is.vinnsla.FerdaPlan;

import java.io.IOException;

/**
 * Controller fyrir aðalviðmótið (adal-view.fxml).
 * Sýnir lista af ferðum og veitir aðgerðir til að skoða, bæta við og eyða ferðum.
 */
public class AdalController {
    /** ListView sem sýnir allar ferðir. */
    @FXML
    private ListView<Ferd> ferdaListView;
    /** Hnappur til að skoða valda ferð. */
    @FXML
    private Button skodaButton;
    /** Hnappur til að eyða valinni ferð. */
    @FXML
    private Button eydaButton;

    /** Ferðaplanið sem heldur utan um gögn. */
    private FerdaPlan ferdaPlan;

    /**
     * Frumstillir controllerinn, tengir gögn við ListView og bindur hnappa.
     */
    @FXML
    public void initialize() {
        ferdaPlan = FerdaPlan.getInstance();
        ferdaListView.setItems(ferdaPlan.getFerdir());
        bindButtonStates();
    }

    /**
     * Bindur disable-eiginleika hnappa við val í ListView.
     * Hnapparnir eru óvirkir þegar ekkert er valið.
     */
    private void bindButtonStates() {
        skodaButton.disableProperty().bind(
                ferdaListView.getSelectionModel().selectedItemProperty().isNull());
        eydaButton.disableProperty().bind(
                ferdaListView.getSelectionModel().selectedItemProperty().isNull());
    }

    /**
     * Opnar Ferð viðmótstré í sama glugga og sýnir upplýsingar um valda ferð.
     */
    @FXML
    private void onSkoda() {
        Ferd selectedFerd = ferdaListView.getSelectionModel().getSelectedItem();
        if (selectedFerd != null) {
            ViewSwitcher.switchTo(View.FERD, false, selectedFerd);
        }
    }

    /**
     * Opnar modal dialog til að bæta við nýrri ferð.
     * Ef notandi staðfestir er ferðin bætt í listann.
     */
    @FXML
    private void onBaetaVid() {
        Ferd newFerd = FerdDialogWrapper.showAddFerdDialog(
                (Stage) ferdaListView.getScene().getWindow());
        if (newFerd != null) {
            ferdaPlan.getFerdir().add(newFerd);
        }
    }

    /**
     * Eyðir valinni ferð eftir staðfestingu í modal dialog.
     */
    @FXML
    private void onEyda() {
        Ferd selectedFerd = ferdaListView.getSelectionModel().getSelectedItem();
        if (selectedFerd != null) {
            showDeleteConfirmationDialog(selectedFerd);
        }
    }

    /**
     * Sýnir staðfestingardialog fyrir eyðingu og eyðir ferð ef staðfest.
     *
     * @param selectedFerd ferðin sem á að eyða
     */
    private void showDeleteConfirmationDialog(Ferd selectedFerd) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/is/vidmot/stadfestingEyda-dialog.fxml"));
            Parent root = loader.load();
            StadfestingEydingDialogController controller = loader.getController();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Staðfesta eyðingu");
            dialogStage.setScene(new Scene(root, 300, 150));
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.showAndWait();

            if (controller.isConfirmed()) {
                ferdaPlan.getFerdir().remove(selectedFerd);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}