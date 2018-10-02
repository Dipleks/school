package root;

import javafx.application.Application;
import javafx.stage.Stage;
import access.Access;

public class Magazine extends Application implements Root {

    private Access access = new Access();

    @Override
    public void start (Stage primaryStage) throws Exception {

        access.getAccessToDataBase();

        WINDOW.setScene(SCENE_WINDOW);
        WINDOW.setTitle("Школьный журнал");
        WINDOW.show();
    }

    public static void main (String[] args){
        launch (args);
    }
}
