package com.aetherwars;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
// import java.util.List;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

// import com.aetherwars.model.Type;
// import com.aetherwars.model.Player;
import com.aetherwars.util.CSVReader;

public class AetherWars extends Application {
    private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
    private static final String FXML_PATH = "fxml/main.fxml";

    public void loadCards() throws IOException, URISyntaxException {
        File characterCSVFile = new File(getClass().getResource(CHARACTER_CSV_FILE_PATH).toURI());
        CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
        characterReader.setSkipHeader(true);
        // List<String[]> characterRows = characterReader.read();
        // for (String[] row : characterRows) {
        //     // Character c = new Character(row[1], row[3], row[2]);
        //     // System.out.println(c);
        // }
    }

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_PATH));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.getScene().setRoot(root);
            stage.setTitle("Aether Wars");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
