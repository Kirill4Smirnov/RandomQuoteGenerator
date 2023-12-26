package controller;

import model.Model;
import view.ConsoleUI;
import view.UI;

public class Controller {
    Model model;
    UI ui;

    public Controller(){
        model = new Model();
        ui = new ConsoleUI();
    }
    public void startProgram() {
        ui.showQuotes(model.getFirstQuotes(5));
    }

}
