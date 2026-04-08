package is.vinnsla;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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

    /**
     * Skilar BooleanProperty fyrir favorite.
     *
     * @return favorite property
     */
    public BooleanProperty favoriteProperty() {
        return favorite;
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
     * Setur nafn ferðarinnar.
     *
     * @param nafn nýtt nafn
     */
    public void setNafn(String nafn) {
        this.nafn.set(nafn);
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
     * Setur áfangastað ferðarinnar.
     *
     * @param afangastadur nýr áfangastaður
     */
    public void setAfangastadur(String afangastadur) {
        this.afangastadur.set(afangastadur);
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

    /**
     * Setur dagsetningu ferðarinnar.
     *
     * @param dagsetning ný dagsetning
     */
    public void setDagsetning(String dagsetning) {
        this.dagsetning.set(dagsetning);
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