package Controller;

import Models.MainModel;

public class MainController {

    private MainModel mainModel;

    public MainController(MainModel mainModel) {
        this.mainModel = mainModel;
        mainModel.setInMainMenu(true);
    }
}
