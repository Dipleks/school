package root;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public interface Root {

    Screen SCREEN = Screen.getPrimary();
    double WIDTH = SCREEN.getBounds().getWidth();
    double HEIGHT = SCREEN.getBounds().getHeight();
    Stage WINDOW = new Stage();
    Group ROOT = new Group();
    Scene SCENE_WINDOW = new Scene(ROOT, WIDTH, HEIGHT, Color.web("#dfdcd8"));
}
