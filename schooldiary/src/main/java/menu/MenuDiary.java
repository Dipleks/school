package menu;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Screen;

public class MenuDiary {

    private final MenuBar MENU_BAR = new MenuBar();
    private final Screen SCREEN = Screen.getPrimary();
    private final double w = SCREEN.getBounds().getWidth();

    private final Menu MENU = new Menu("Меню");
    private final Menu SERVICE = new Menu("Сервис");

    public MenuBar getMenuBar(){
        getMenu();
        return MENU_BAR;
    }

    private void getMenu(){
        MENU_BAR.setPrefWidth(w);
        MENU_BAR.getMenus().addAll(MENU, SERVICE);
    }
}
