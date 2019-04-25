package View;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuArea extends MenuBar {

    public Menu menu = new Menu("Menu");
    public Menu design = new Menu("Design");
    public MenuItem exit = new MenuItem("Exit");
    public MenuItem odds = new MenuItem("Odds");
    public MenuItem lottoMode = new MenuItem("Lotto Mode");
    public MenuItem darkMode = new MenuItem("Dark Mode");
    public MenuItem reset = new MenuItem("Reset");

    public MenuArea(){
        super();
        this.menu.getItems().addAll(odds, reset, exit);
        this.design.getItems().addAll(lottoMode, darkMode);
        this.getMenus().addAll(menu, design);

    }
}
