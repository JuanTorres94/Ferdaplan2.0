package is.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import is.vidmot.switcher.ViewSwitcher;

import java.io.IOException;

/**
 * Aðalklasi forritsins sem ræsir JavaFX forritið.
 * Hleður inn aðalviðmótinu (adal-view.fxml) og sýnir glugga.
 */
public class FerdaplanApp extends Application {

    /**
     * Ræsir forritið og sýnir aðalglugga.
     *
     * @param stage aðalsviðið (gluggi) sem JavaFX býr til
     * @throws IOException ef ekki tekst að hlaða FXML skrá
     */
    @Override
    public void start(Stage stage) throws IOException {
        ViewSwitcher.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(FerdaplanApp.class.getResource("adal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Ferðaplan");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main aðferð sem ræsir JavaFX forritið.
     *
     * @param args skipanalínubreytur
     */
    public static void main(String[] args) {
        launch();
    }
}