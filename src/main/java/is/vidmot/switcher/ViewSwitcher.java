package is.vidmot.switcher;

import is.vidmot.controller.GognInterface;
import is.vinnsla.Ferd;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Sér um að skipta um view í forriti
 */
public class ViewSwitcher {
    private static Stage stage;
    private static Scene scene;
    private static final Map<View, Parent> cache = new HashMap<>();
    private static final Map<View, Object> controllerCache = new HashMap<>();

    public static void setStage(Stage stage) {
        ViewSwitcher.stage = stage;
    }

    public static void switchTo(View view, boolean isCache, Ferd ferd) {
        try {
            Parent root;
            Object controller;

            if (cache.containsKey(view) && isCache) {
                root = cache.get(view);
                controller = controllerCache.get(view);
            } else {
                FXMLLoader loader = new FXMLLoader(ViewSwitcher.class.getResource(
                        "/is/vidmot/" + getViewFileName(view)));
                root = loader.load();
                controller = loader.getController();
                if (isCache) {
                    cache.put(view, root);
                    controllerCache.put(view, controller);
                }
            }

            if (controller instanceof GognInterface && ferd != null) {
                ((GognInterface) controller).setGogn(ferd);
            }

            if (scene == null) {
                scene = new Scene(root, stage.getWidth(), stage.getHeight());
                stage.setScene(scene);
            } else {
                scene.setRoot(root);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void switchTo(View view, boolean isCache) {
        switchTo(view, isCache, null);
    }

    private static String getViewFileName(View view) {
        return switch (view) {
            case ADAL -> "adal-view.fxml";
            case FERD -> "ferd-view.fxml";
        };
    }
}
