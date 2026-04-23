package is.vinnsla;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Klasi sem táknar eina ferð.
 * Inniheldur nafn ferðar, áfangastað og dagsetningu.
 */
public class Ferd {
    /** Nafn ferðarinnar. */
    private final StringProperty nafn = new SimpleStringProperty();
    /** Áfangastaður ferðarinnar. */
    private final StringProperty afangastadur = new SimpleStringProperty();
    /** Dagsetning ferðarinnar. */
    private final StringProperty dagsetning = new SimpleStringProperty();
    /** Hvort ferðin er stjörnumerkt (favorite). */
    private final BooleanProperty favorite = new SimpleBooleanProperty(false);
    /** Hvort ferðinni sé lokið (completed). */
    private final BooleanProperty completed = new SimpleBooleanProperty(false);
    /** Slóð á forsíðumynd ferðarinnar. Null ef engin mynd valin. */
    private final StringProperty myndSlod = new SimpleStringProperty(null);

    /**
     * Smiður sem býr til nýja ferð.
     *
     * @param nafn         nafn ferðarinnar
     * @param afangastadur áfangastaður ferðarinnar
     * @param dagsetning   dagsetning ferðarinnar
     */
    public Ferd(String nafn, String afangastadur, String dagsetning) {
        this.nafn.set(nafn);
        this.afangastadur.set(afangastadur);
        this.dagsetning.set(dagsetning);
    }

    public String getMyndSlod() {
        return myndSlod.get();
    }

    public void setMyndSlod(String myndSlod) {
        this.myndSlod.set(myndSlod);
    }

    /**
     * Skilar hvort ferðin er favorite.
     *
     * @return true ef favorite, annars false
     */
    public Boolean isFavorite() {
        return favorite.get();
    }

    /**
     * Setur favorite stöðu ferðarinnar.
     *
     * @param favorite true til að stjörnumerkja, false til að afmerkja
     */
    public void setFavorite(boolean favorite) {
        this.favorite.set(favorite);
    }

    /**
     * Skilar hvort ferðinni sé lokið.
     *
     * @return true ef lokið, annars false
     */
    public boolean isCompleted() {
        return completed.get();
    }

    /**
     * Setur completed stöðu ferðarinnar.
     *
     * @param completed true til að merkja sem lokið, false til að afmerkja
     */
    public void setCompleted(boolean completed) {
        this.completed.set(completed);
    }

    /**
     * Skilar StringProperty fyrir nafn ferðarinnar.
     *
     * @return nafn property
     */
    public StringProperty nafnProperty() {
        return nafn;
    }

    /**
     * Skilar nafni ferðarinnar.
     *
     * @return nafn ferðarinnar
     */
    public String getNafn() {
        return nafn.get();
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
     * Skilar áfangastað ferðarinnar.
     *
     * @return áfangastaður
     */
    public String getAfangastadur() {
        return afangastadur.get();
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
     * Skilar dagsetningu ferðarinnar.
     *
     * @return dagsetning
     */
    public String getDagsetning() {
        return dagsetning.get();
    }

    private final ObservableList<String> pakkalisti = FXCollections.observableArrayList();

    public ObservableList<String> getPakkalisti() {
        return pakkalisti;
    }

    /**
     * Skilar strengjaframsetningu ferðarinnar.
     *
     * @return strengur á forminu "nafn - áfangastaður (dagsetning)"
     */
    @Override
    public String toString() {
        return nafn.get() + " - " + afangastadur.get() + " (" + dagsetning.get() + ")";
    }
}