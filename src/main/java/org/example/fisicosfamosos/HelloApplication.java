package org.example.fisicosfamosos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    static String text = "";
    static FisicoService service = new FisicoService();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");

        TextArea ta = new TextArea ("fisicos");
        ta.setText(text);
        Scene scene = new Scene(ta, 200, 100);
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        List<Fisico> fisicos = new ArrayList<>();
        try {
            service.populate(fisicos, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i<2025; i++){
            if( service.includes(fisicos, i) ){
                text = text + "+";
            } else {
                text = text + "-";
            }
        }
        launch();

    }

}