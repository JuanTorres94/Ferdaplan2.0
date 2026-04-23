package is.vidmot.controller;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import is.vidmot.view.FerdSpjald;
import is.vidmot.switcher.View;
import is.vidmot.switcher.ViewSwitcher;
import is.vinnsla.Ferd;
import java.io.File;

/**
 * Controller fyrir ferðaviðmótið (ferd-view.fxml).
 * Sýnir nánari upplýsingar um eina ferð með FerdSpjald sérhæfðum hlut.
 */
public class FerdController implements GognInterface {
    /** Sérhæfður viðmótshlutur sem sýnir upplýsingar um ferð. */
    @FXML
    private FerdSpjald fxFerdSpjald;
    private Ferd currentFerd;

    /**
     * Tekur á móti ferð og bindur gögn hennar við FerdSpjald.
     *
     * @param ferd ferðin sem á að sýna
     */
    @Override
    public void setGogn(Ferd ferd) {
        if (ferd != null) {
            currentFerd = ferd;
            fxFerdSpjald.nafnProperty().bind(ferd.nafnProperty());
            fxFerdSpjald.afangastadurProperty().bind(ferd.afangastadurProperty());
            fxFerdSpjald.dagsetningProperty().bind(ferd.dagsetningProperty());
            fxFerdSpjald.setCoverImage(ferd.getMyndSlod());
            fxFerdSpjald.setPakkalistiItems(ferd.getPakkalisti());
        }
    }

    @FXML
    private void onVeljamynd() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Veldu forsíðumynd");

        // Leyfa bara myndir
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Myndir", "*.png", "*.jpg", "*.jpeg", "*.gif"));

        // Opna file picker
        Stage stage = (Stage) fxFerdSpjald.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);

        // Ef notandi valdi mynd, vista og sýna hana
        if (file != null) {
            String filePath = file.getAbsolutePath();
            currentFerd.setMyndSlod(filePath);
            fxFerdSpjald.setCoverImage(filePath);
        }
    }

    /**
     * Fer til baka í aðalviðmótið.
     */
    @FXML
    private void onTilBaka() {
        ViewSwitcher.switchTo(View.ADAL, false);
    }
}