/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package carloan;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author chris
 */
public class CarLoan extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Creating input fields
        TextField loanAmountField = new TextField();
        loanAmountField.setPromptText("Loan Amount");

        TextField loanLengthField = new TextField();
        loanLengthField.setPromptText("Loan Length (in years)");

        TextField interestRateField = new TextField();
        interestRateField.setPromptText("Interest Rate as a whole number or decimal number");

        TextField downPaymentField = new TextField();
        downPaymentField.setPromptText("Down Payment Amount");

        // Button for calculation
        Button calculateButton = new Button("Calculate Monthly Payment");

        // Label to display result
        Label resultLabel = new Label();

        // Layout setup
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(
            new Label("Enter Loan Details:"),
            loanAmountField,
            loanLengthField,
            interestRateField,
            downPaymentField,
            calculateButton,
            resultLabel
        );

        // Calculate button action
        calculateButton.setOnAction(e -> {
            try {
                int carLoan = Integer.parseInt(loanAmountField.getText());
                int loanLength = Integer.parseInt(loanLengthField.getText());
                double interestRate = Double.parseDouble(interestRateField.getText()) / 100;
                int downPayment = Integer.parseInt(downPaymentField.getText());

                if (loanLength <= 0 || interestRate <= 0) {
                    resultLabel.setText("Please take out a valid car loan.");
                } else if (downPayment >= carLoan) {
                    resultLabel.setText("The car can be paid in full.");
                } else {
                    int remainingBalance = carLoan - downPayment;
                    int months = loanLength * 12;
                    int monthlyBalance = remainingBalance / months;
                    double interest = monthlyBalance * interestRate;
                    double monthlyPayment = monthlyBalance + interest;
                    resultLabel.setText(String.format("Monthly Payment: %.2f", monthlyPayment));
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        });

        // Set the scene
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Car Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}