package root;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import menu.MenuMagazine;

public class Magazine extends Application implements Root {

    @Override
    public void start (Stage primaryStage) throws Exception {

        /////////////////
        String name = "zagorodnev";
        Label l = new Label();
        l.setLayoutX(400);
        l.setLayoutY(450);
        TextField login = new TextField();
        login.setLayoutX(200);
        login.setLayoutY(170);
        PasswordField pass = new PasswordField();
        pass.setLayoutX(200);
        pass.setLayoutY(200);
        pass.setOnAction(e -> {
            System.out.println(pass.getText());
            if(login.getText().equalsIgnoreCase(name)) {
                if (!pass.getText().equals("1234567")) {
                    l.setText("Пароль не верен!");
                    l.setTextFill(Color.RED);
                    pass.clear();
                } else {
                    l.setText("Добро пожаловать, " + name + "!");
                    l.setTextFill(Color.GREEN);
                    MenuMagazine menuDiary = new MenuMagazine();
                    ROOT.getChildren().add(menuDiary.getMenuBar());
                    ROOT.getChildren().remove(login);
                    ROOT.getChildren().remove(pass);
                }
            } else {
                l.setText("Неверный логин");
            }
        });
        ////////////////



        ROOT.getChildren().addAll(login, pass, l);

        WINDOW.setScene(SCENE_WINDOW);
        WINDOW.setTitle("Школьный журнал");
        WINDOW.show();
    }

    public static void main (String[] args){
        launch (args);
    }
}
