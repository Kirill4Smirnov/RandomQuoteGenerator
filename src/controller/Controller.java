package controller;

import model.Model;

public class Controller {
    Model model;

    public Controller(){
        model = new Model();
    }
    public void startProgram() {
        model.printQuotes(10);
    }

}
