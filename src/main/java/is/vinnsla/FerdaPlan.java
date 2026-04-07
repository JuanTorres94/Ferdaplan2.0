package is.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Klasi sem heldur utan um lista af ferðum (Singleton).
 * Notaður sem gagnalíkan fyrir forritið.
 */
public class FerdaPlan {
    /** Eina tilvik klasans (Singleton). */
    private static FerdaPlan instance;
    /** Listi af ferðum sem er ObservableList til að tengjast viðmóti. */
    private final ObservableList<Ferd> ferdir;

    /**
     * Einkasmiður sem býr til ferðaplanið og hleður inn sýnigögnum.
     */
    private FerdaPlan() {
        ferdir = FXCollections.observableArrayList();
        initializeSampleTrips();
    }

    /**
     * Skilar eina tilviki af FerdaPlan (Singleton).
     *
     * @return tilvik af FerdaPlan
     */
    public static FerdaPlan getInstance() {
        if (instance == null) {
            instance = new FerdaPlan();
        }
        return instance;
    }

    /**
     * Hleður inn sýnidæmum af ferðum þegar forritið ræsist.
     */
    private void initializeSampleTrips() {
        ferdir.add(new Ferd("Akranes útilegumenn", "Akranesborg", "15.01.2025"));
        ferdir.add(new Ferd("Snæfellsjökull leiðangur", "Stykkishólmur", "22.02.2025"));
        ferdir.add(new Ferd("Mývatn rannsóknir", "Mývatn", "10.03.2025"));
    }

    /**
     * Skilar lista af ferðum.
     *
     * @return ObservableList af ferðum
     */
    public ObservableList<Ferd> getFerdir() {
        return ferdir;
    }
}