import controller.MenuController;
import model.MenuModel;
import view.MenuView;

public class Main {
    public static void main(String[] args) {
        MenuView menu = new MenuView();
        MenuModel model = new MenuModel();
        new MenuController(model,menu);
    }
}
