import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    private int angkaTebakan;
    private int jumlahPercobaan;
    private final Random random = new Random();

    private Label feedbackLabel;
    private Label percobaanLabel;
    private TextField inputField;
    private Button tombolTebak;

    @Override
    public void start(Stage primaryStage) {
        angkaTebakan = generateAngkaBaru();
        jumlahPercobaan = 0;

        Label judulLabel = new Label("🎯 Tebak Angka 1–100");
        judulLabel.setFont(new Font("Arial", 24));
        judulLabel.setTextFill(Color.DARKBLUE);

        feedbackLabel = new Label("Masukkan tebakanmu!");
        feedbackLabel.setFont(new Font("Arial", 16));
        feedbackLabel.setTextFill(Color.GRAY);

        inputField = new TextField();
        inputField.setOnAction(e -> tombolTebak.fire());
        inputField.setPromptText("Masukkan angka di sini");
        inputField.setMaxWidth(150);

        tombolTebak = new Button("Coba Tebak!");
        tombolTebak.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

        tombolTebak.setOnAction(e -> {
            if (tombolTebak.getText().equals("Main Lagi")) {
                angkaTebakan = generateAngkaBaru();
                jumlahPercobaan = 0;
                feedbackLabel.setText("Masukkan tebakanmu!");
                feedbackLabel.setTextFill(Color.GRAY);
                percobaanLabel.setText("Jumlah percobaan: 0");
                tombolTebak.setText("Coba Tebak!");
                tombolTebak.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
                inputField.setDisable(false);
                inputField.clear();
            } else {
                try {
                    int tebakan = Integer.parseInt(inputField.getText());
                    jumlahPercobaan++;
                    if (tebakan < angkaTebakan) {
                        feedbackLabel.setText("⚠ Terlalu kecil!");
                        feedbackLabel.setTextFill(Color.ORANGE);
                    } else if (tebakan > angkaTebakan) {
                        feedbackLabel.setText("⚠ Terlalu besar!");
                        feedbackLabel.setTextFill(Color.ORANGE);
                    } else {
                        feedbackLabel.setText("✅ Tebakan benar!");
                        feedbackLabel.setTextFill(Color.GREEN);
                        tombolTebak.setText("Main Lagi");
                        tombolTebak.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
                        inputField.setDisable(true);
                    }
                    percobaanLabel.setText("Jumlah percobaan: " + jumlahPercobaan);
                } catch (NumberFormatException ex) {
                    feedbackLabel.setText("Masukkan angka yang valid!");
                    feedbackLabel.setTextFill(Color.RED);
                }
            }
        });

        percobaanLabel = new Label("Jumlah percobaan: 0");

        HBox inputBox = new HBox(10, inputField, tombolTebak);
        inputBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, judulLabel, feedbackLabel, inputBox, percobaanLabel);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #E3F2FD; -fx-padding: 25;");

        Scene scene = new Scene(root, 400, 250);
        primaryStage.setTitle("Tebak Angka Advance");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private int generateAngkaBaru() {
        return random.nextInt(100) + 1;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
