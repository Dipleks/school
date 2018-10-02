package access;

import db.Connect;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import menu.MenuMagazine;
import root.Root;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import java.sql.*;

public class Access implements Root, Connect {

    private final TextField login = new TextField();
    private final PasswordField password = new PasswordField();
    private Label access = new Label();
    private Label loginT = new Label("Логин: ");
    private Label passT = new Label("Пароль: ");
    private VBox pane = new VBox();
    private HBox paneLogin = new HBox();
    private HBox panePass = new HBox();
    private Font font = Font.font("Time New Roman", FontWeight.BOLD, FontPosture.ITALIC, HEIGHT * 0.018);

    public void getAccessToDataBase(){
        getAccessFields();
        checkingAccess();
    }

    private void getAccessFields(){
        login.setPromptText("Введите логин...");
        login.setPrefWidth(WIDTH/7);
        password.setPromptText("Введите пароль...");
        password.setPrefWidth(WIDTH/7);
        loginT.setPrefWidth(WIDTH/17);
        loginT.setFont(font);
        passT.setPrefWidth(WIDTH/17);
        passT.setFont(font);
        access.setFont(font);

        pane.setLayoutX(WIDTH/2.7);
        pane.setLayoutY(HEIGHT/3);
        pane.setSpacing(HEIGHT/50);
        pane.setAlignment(Pos.CENTER);
        paneLogin.setSpacing(WIDTH/80);
        panePass.setSpacing(WIDTH/80);
        paneLogin.getChildren().addAll(loginT, login);
        panePass.getChildren().addAll(passT, password);
        pane.getChildren().addAll(paneLogin, panePass, access);
        ROOT.getChildren().add(pane);
    }

    private void checkingAccess(){

        password.setOnAction(e -> {
            if(checkingPassword()) {
                MenuMagazine menuDiary = new MenuMagazine();
                ROOT.getChildren().add(menuDiary.getMenuBar());
                paneLogin.getChildren().clear();
                panePass.getChildren().clear();
                pane.getChildren().clear();
                ROOT.getChildren().remove(paneLogin);
                ROOT.getChildren().remove(panePass);
                ROOT.getChildren().remove(pane);
            } else {
                access.setText("В доступе отказано!");
            }
        });
    }

    private boolean checkingPassword(){

        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            access.setText("Драйвер не найден!");
            System.out.println("Not Driver");
        }
        try(Connection connection = DriverManager.getConnection(URL_DB + NAME_DB, USER, PASS)){

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT login, password FROM access;");

            while(resultSet.next()){
                String l = resultSet.getString("login");
                String p = resultSet.getString("password");
                if(login.getText().equals(l) && password.getText().equals(p)) {
                    statement.close();
                    resultSet.close();
                    return true;
                }
            }
            statement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
