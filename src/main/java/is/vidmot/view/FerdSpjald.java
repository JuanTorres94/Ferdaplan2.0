package is.vidmot.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;

/** * Sérhæfður viðmótshlutur (custom component) sem sýnir upplýsingar um ferð. * Hleður ferd-spjald.fxml og býður upp á properties til gagnabindingar og pakkalista. */
public class FerdSpjald extends VBox {
    /**
     * Textareitur fyrir nafn ferðar.
     */
    @FXML
    private TextField fxHeiti;
    /**
     * Textareitur fyrir áfangastað.
     */
    @FXML
    private TextField fxAfangastadur;
    /**
     * Textareitur fyrir dagsetningu.
     */
    @FXML
    private TextField fxDagsetning;
    @FXML
    private ImageView fxCoverImage;

    /**
     * Element fyrir pakkalista HUX
     **/
    @FXML
    private ListView<String> fxPakkalistiView;
    @FXML
    private TextField fxNyrHluturField;

    private final StringProperty heiti = new SimpleStringProperty();
    private final StringProperty afangastadur = new SimpleStringProperty();
    private final StringProperty dagsetning = new SimpleStringProperty();

    /**
     * Sjálfgefin forsíðumynd sem hleðst úr resources.
     */
    private final Image defaultImage;

    public FerdSpjald() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/is/vidmot/ferd-spjald.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (Exception e) {
            System.err.println("Gat ekki hlaðið skrá: " + e.getMessage());
        }

        // Hlaða sjálfgefna mynd
        var isStream = getClass().getResourceAsStream("/is/vidmot/images/StockImage.jpg");
        if (isStream != null) {
            defaultImage = new Image(isStream);
            fxCoverImage.setImage(defaultImage);
        } else {
            defaultImage = null; // Ef myndin finnst ekki í resources
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
     * Stillir inn pakkalistann fyrir ferðina inni í UI listanum
     */
    public void setPakkalistiItems(ObservableList<String> listi) {
        if (fxPakkalistiView != null && listi != null) {
            fxPakkalistiView.setItems(listi);
        }
    }

    /**
     * Bætir nýjum hlut úr TextField í pakkalistann.
     */
    @FXML
    private void onBaetaVidPakka() {
        String nyrHlutur = fxNyrHluturField.getText();
        if (nyrHlutur != null && !nyrHlutur.trim().isEmpty() && fxPakkalistiView != null) {
            fxPakkalistiView.getItems().add(nyrHlutur.trim());
            fxNyrHluturField.clear();
        }
    }

    /**
     * Eyðir útvöldum hlut úr pakkalistanum.
     */
    @FXML
    private void onEydaPakka() {
        if (fxPakkalistiView != null) {
            String valinn = fxPakkalistiView.getSelectionModel().getSelectedItem();
            if (valinn != null) {
                fxPakkalistiView.getItems().remove(valinn);
            }
        }
    }

    /**
     * Setur forsíðumynd ferðarinnar.     * Ef slóðin er null eða tóm er sjálfgefna myndin sýnd.     *     * @param filePath slóð á mynd á tölvunni
     */
    public void setCoverImage(String filePath) {
        if (filePath != null && !filePath.isEmpty()) {
            File file = new File(filePath);
            if (file.exists()) {
                Image image = new Image(file.toURI().toString());
                fxCoverImage.setImage(image);
                return;
            }
        }
        // Ef engin mynd eða skrá finnst ekki, sýna sjálfgefna
        if (defaultImage != null) {
            fxCoverImage.setImage(defaultImage);
        }
    }

    /**
     * Skilar StringProperty fyrir nafn ferðar.     *     * @return nafn property
     */
    public StringProperty nafnProperty() {
        return heiti;
    }

    /**
     * Skilar StringProperty fyrir áfangastað.     *     * @return áfangastaður property
     */
    public StringProperty afangastadurProperty() {
        return afangastadur;
    }

    /**
     * Skilar StringProperty fyrir dagsetningu.     *     * @return dagsetning property
     */
    public StringProperty dagsetningProperty() {
        return dagsetning;
    }
}
