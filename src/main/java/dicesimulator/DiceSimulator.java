package dicesimulator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class DiceSimulator extends Application {

    private final Random random = new Random();
    private ImageView dice1;
    private ImageView dice2;
    private final int IMAGE_SIZE = 100;

    @Override
    public void start(Stage stage) {
        // Initialize dice images showing face 1 initially
        dice1 = new ImageView(loadDiceImage(1));
        dice2 = new ImageView(loadDiceImage(1));

        dice1.setFitWidth(IMAGE_SIZE);
        dice1.setFitHeight(IMAGE_SIZE);
        dice2.setFitWidth(IMAGE_SIZE);
        dice2.setFitHeight(IMAGE_SIZE);

        Button rollButton = new Button("Roll Dice");
        rollButton.setOnAction(e -> rollDice());

        HBox diceBox = new HBox(20, dice1, dice2);
        diceBox.setStyle("-fx-alignment: center;");

        VBox root = new VBox(20, diceBox, rollButton);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 400, 250);
        stage.setTitle("Dice Simulator");
        stage.setScene(scene);
        stage.show();
    }

    private void rollDice() {
        int roll1 = random.nextInt(6) + 1;
        int roll2 = random.nextInt(6) + 1;

        dice1.setImage(loadDiceImage(roll1));
        dice2.setImage(loadDiceImage(roll2));
    }

    private Image loadDiceImage(int value) {
        // This loads images from resources/DiceImages/dice1.png etc.
        String path = "/DiceImages/dice" + value + ".png";
        return new Image(getClass().getResourceAsStream(path));
    }

    public static void main(String[] args) {
        launch(args);
    }
}