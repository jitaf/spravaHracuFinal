package org.example.spravahracu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SpravaHracuApplication extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SpravaHracuApplication.class.getResource("hraci.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 480, 360);
        stage.setTitle("Správa hráčů");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}