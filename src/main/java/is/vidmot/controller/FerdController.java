package is.vidmot.controller;

import javafx.fxml.FXML;
import is.vidmot.view.FerdSpjald;
import is.vidmot.switcher.View;
import is.vidmot.switcher.ViewSwitcher;
import is.vinnsla.Ferd;

/**
 * Controller fyrir ferðaviðmótið (ferd-view.fxml).
 * Sýnir nánari upplýsingar um eina ferð með FerdSpjald sérhæfðum hlut.
 */
public class FerdController implements GognInterface {
    /** Sérhæfður viðmótshlutur sem sýnir upplýsingar um ferð. */
    @FXML
    private FerdSpjald fxFerdSpjald;

    /**
     * Tekur á móti ferð og bindur gögn hennar við FerdSpjald.
     *
     * @param ferd ferðin sem á að sýna
     */
    @Override
    public void setGogn(Ferd ferd) {
        if (ferd != null) {
            fxFerdSpjald.nafnProperty().bind(ferd.nafnProperty());
            fxFerdSpjald.afangastadurProperty().bind(ferd.afangastadurProperty());
            fxFerdSpjald.dagsetningProperty().bind(ferd.dagsetningProperty());
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