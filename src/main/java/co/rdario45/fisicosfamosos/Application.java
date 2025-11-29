package co.rdario45.fisicosfamosos;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Application extends javafx.application.Application {
    static String timeline = "";
    static String input = "";
    static ArrayList<Fisico> fisicos = new ArrayList<>();
    static FisicosService service = new FisicosService();
    static TimelineService timelineService = new TimelineService();

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("start");
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Fisicos Famosos!");

        final Menu menu1 = new Menu("File");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu1);

        MenuItem openMenuItem = new MenuItem("Open...");
        menu1.getItems().add(openMenuItem);



        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        // Optional: Add extension filters to limit visible file types
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );


        final TextArea ta2 = new TextArea ("input");
        ta2.setFont(Font.font("Consolas", 14));
        ta2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Text changed from: \"" + oldValue + "\" to: \"" + newValue + "\"");
                // Perform actions based on the text change
                // For example, update a character count label, save the content, etc.
            }
        });

        final TextArea ta = new TextArea ("timeline");
        ta.setFont(Font.font("Consolas", 14));
        ta.setPrefHeight(500); // Sets the preferred height to 200 pixels


        openMenuItem.setOnAction(event -> {
            File selectedFile = fileChooser.showOpenDialog(stage); // 'stage' is your primary Stage
            if (selectedFile != null) {
                // Logic to load and process the selected file
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                // Example: read content from the file
                try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                        service.populateOne(fisicos, line);
                        input += line;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                timelineService.fillTimeline(this.fisicos);

                ta.setText(timeline);

                ta2.setText(input);

            }
        });







        VBox root = new VBox(menuBar);
        root.getChildren().add(ta2);
        root.getChildren().add(ta);

        Scene scene = new Scene(root, 200, 100);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("main");
        launch();
    }

}