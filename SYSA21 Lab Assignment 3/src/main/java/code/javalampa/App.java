package code.javalampa;

import javafx.application.Application;
import javafx.stage.Stage;
import code.javalampa.controllers.AppController;
import code.javalampa.models.AppModel;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AppModel appModel = new AppModel();
        AppController appController = new AppController(primaryStage, appModel);
        appController.showMainView();
    }
}