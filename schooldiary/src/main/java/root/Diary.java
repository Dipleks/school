package root;

import javafx.application.Application;
import javafx.stage.Stage;
import menu.MenuDiary;

public class Diary extends Application implements Root {

    @Override
    public void start(Stage primaryStage) throws Exception {

        MenuDiary menuDiary = new MenuDiary();
        ROOT.getChildren().add(menuDiary.getMenuBar());

        WINDOW.setScene(SCENE_WINDOW);
        WINDOW.setTitle("Дневник");
        WINDOW.show();
    }

    public static void main (String[] args) {
        launch(args);
    }
}
