package is.vidmot.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Sérhæfður viðmótshlutur (custom component) sem sýnir upplýsingar um ferð.
 * Hleður ferd-spjald.fxml og býður upp á properties til gagnabindingar.
 */
public class FerdSpjald extends VBox {
    /** Textareitur fyrir nafn ferðar. */
    @FXML
    private TextField fxHeiti;
    /** Textareitur fyrir áfangastað. */
    @FXML
    private TextField fxAfangastadur;
    /** Textareitur fyrir dagsetningu. */
    @FXML
    private TextField fxDagsetning;

    /** Property fyrir nafn ferðar. */
    private final StringProperty heiti = new SimpleStringProperty();
    /** Property fyrir áfangastað. */
    private final StringProperty afangastadur = new SimpleStringProperty();
    /** Property fyrir dagsetningu. */
    private final StringProperty dagsetning = new SimpleStringProperty();

    /**
     * Smiður sem hleður FXML skránni og bindur textareiti við properties.
     */
    public FerdSpjald() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/is/vidmot/ferd-spjald.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bindTextFields();
    }

    /**
     * Bindur textareiti við tilsvarandi properties svo þau haldist samstillt.
     */
    private void bindTextFields() {
        fxHeiti.textProperty().bindBidirectional(heiti);
        fxAfangastadur.textProperty().bindBidirectional(afangastadur);
        fxDagsetning.textProperty().bindBidirectional(dagsetning);
    }

    /**
     * Skilar StringProperty fyrir nafn ferðar.
     *
     * @return nafn property
     */
    public StringProperty nafnProperty() {
        return heiti;
    }

    /**
     * Skilar StringProperty fyrir áfangastað.
     *
     * @return áfangastaður property
     */
    public StringProperty afangastadurProperty() {
        return afangastadur;
    }

    /**
     * Skilar StringProperty fyrir dagsetningu.
     *
     * @return dagsetning property
     */
    public StringProperty dagsetningProperty() {
        return dagsetning;
    }

    /**
     * Skilar nafni ferðar.
     *
     * @return nafn
     */
    public String getNafn() {
        return heiti.get();
    }

    /**
     * Skilar áfangastað.
     *
     * @return áfangastaður
     */
    public String getAfangastadur() {
        return afangastadur.get();
    }

    /**
     * Skilar dagsetningu.
     *
     * @return dagsetning
     */
    public String getDagsetning() {
        return dagsetning.get();
    }

    /**
     * Setur nafn ferðar.
     *
     * @param value nýtt nafn
     */
    public void setNafn(String value) {
        heiti.set(value);
    }

    /**
     * Setur áfangastað.
     *
     * @param value nýr áfangastaður
     */
    public void setAfangastadur(String value) {
        afangastadur.set(value);
    }

    /**
     * Setur dagsetningu.
     *
     * @param value ný dagsetning
     */
    public void setDagsetning(String value) {
        dagsetning.set(value);
    }
}