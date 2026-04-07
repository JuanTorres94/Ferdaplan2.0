package is.vidmot.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
import is.vinnsla.Ferd;
import java.io.IOException;

/**
 * Wrapper klasi sem sér um að opna og stjórna dialog til að bæta við ferð.
 * Hleður ny-ferd-dialog.fxml og skilar nýrri ferð ef notandi staðfestir.
 */
public class FerdDialogWrapper {

    /**
     * Opnar modal dialog til að bæta við nýrri ferð.
     *
     * @param parentStage foreldra glugginn sem á dialoginn
     * @return ný ferð ef staðfest, annars null
     */
    public static Ferd showAddFerdDialog(Stage parentStage) {
        try {
            FXMLLoader loader = new FXMLLoader(FerdDialogWrapper.class.getResource("/is/vidmot/ny-ferd-dialog.fxml"));
            Parent root = loader.load();
            FerdDialogController controller = loader.getController();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Bæta við ferð");
            dialogStage.setScene(new Scene(root, 400, 300));
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initOwner(parentStage);
            dialogStage.showAndWait();

            if (controller.isConfirmed()) {
                return controller.getFerd();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}