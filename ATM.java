import java.time.LocalDate;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

public class ATM extends Application {

    // Account number and PIN for demo purposes
    private static final String ACCOUNT_NUMBER = "1234567890";
    private static final String PIN = "1234";

    // Balance for demo purposes
    private double BALANCE = 500.0;
    private Stage primaryStage;
    private double amount;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showLoginPage();
    }

    private void showLoginPage() {
        // Login page UI
        Label welcomeLabel = new Label("Welcome to EasyCash Bank ATM");
        welcomeLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: #1abc9c;");
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Log In");
        Label errorLabel = new Label();
        Label nameLabel = new Label("Created by Sarah , Araa and Sahar");
        nameLabel.setStyle("-fx-font-size: 10px;");

        // Add some users to the map
        Map<String, String> users = new HashMap<>();
        users.put("1234567890", "0000");
        users.put("1234567891", "1111");
        users.put("1234567892", "2222");

        // Login button action
        loginButton.setOnAction(e -> {
            String enteredUsername = usernameField.getText();
            String enteredPassword = passwordField.getText();
            if (users.containsKey(enteredUsername) && users.get(enteredUsername).equals(enteredPassword)) {
                showMenuPage();
            } else {
                errorLabel.setText("Incorrect username or password.");
                errorLabel.setStyle("-fx-text-fill: #ff0000;");
            }
        });

        // Login page layout
        GridPane loginLayout = new GridPane();
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setHgap(10);
        loginLayout.setVgap(10);
        loginLayout.setPadding(new Insets(25, 25, 25, 25));
        loginLayout.add(welcomeLabel, 0, 0, 2, 1);
        loginLayout.add(usernameLabel, 0, 1);
        loginLayout.add(usernameField, 1, 1);
        loginLayout.add(passwordLabel, 0, 2);
        loginLayout.add(passwordField, 1, 2);
        loginLayout.add(loginButton, 1, 3);
        loginLayout.add(errorLabel, 1, 4);
        loginLayout.add(nameLabel, 0, 5, 2, 1);

        Scene loginScene = new Scene(loginLayout, 400, 300);
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private void showMenuPage() {
        // Menu page UI
        Label balanceLabel = new Label("Current Balance: $" + BALANCE);
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        Button backButton = new Button("Back");
        Button exitButton = new Button("Exit");

        // Menu button actions
        depositButton.setOnAction(e -> {
            showDepositPage();
        });
        withdrawButton.setOnAction(e -> {
            showWithdrawPage();
        });
        backButton.setOnAction(e -> {
            showLoginPage();
        });
        exitButton.setOnAction(e -> {
            primaryStage.close();
        });

        // Menu page layout
        BorderPane menuLayout = new BorderPane();
        VBox buttonBox = new VBox(10);
        buttonBox.getChildren().addAll(depositButton, withdrawButton, backButton, exitButton);
        buttonBox.setAlignment(Pos.CENTER);
        menuLayout.setTop(balanceLabel);
        menuLayout.setCenter(buttonBox);

        Scene menuScene = new Scene(menuLayout, 400, 300);
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    private void showWithdrawPage() {
        // Withdraw page UI
        Label withdrawLabel = new Label("Enter amount to withdraw:");
        TextField amountField = new TextField();
        Button withdrawButton = new Button("Withdraw");
        Button cancelButton = new Button("Cancel");
        Label errorLabel = new Label();

        // Withdraw button actions
        withdrawButton.setOnAction(e -> {
            try {
                amount = Double.parseDouble(amountField.getText());
                if (amount > BALANCE) {
                    errorLabel.setText("Insufficient funds.");
                } else {
                    BALANCE -= amount;
                    showReceiptPage("Withdrawal", amount);
                }
            } catch (NumberFormatException ex) {
                errorLabel.setText("Invalid amount.");
            }
        });
        cancelButton.setOnAction(e -> {
            showMenuPage();
        });

        // Withdraw page layout
        GridPane withdrawLayout = new GridPane();
        withdrawLayout.setAlignment(Pos.CENTER);
        withdrawLayout.setHgap(10);
        withdrawLayout.setVgap(10);
        withdrawLayout.setPadding(new Insets(25, 25, 25, 25));
        withdrawLayout.add(withdrawLabel, 0, 0);
        withdrawLayout.add(amountField, 1, 0);
        withdrawLayout.add(withdrawButton, 1, 1);
        withdrawLayout.add(cancelButton, 2, 1);
        withdrawLayout.add(errorLabel, 1, 2);

        Scene withdrawScene = new Scene(withdrawLayout, 400, 300);
        primaryStage.setScene(withdrawScene);
        primaryStage.show();
    }

    private void showReceiptPage(String transactionType, double amount) {
        // Receipt page UI
        Label receiptLabel = new Label("Transaction Receipt");
        Label typeLabel = new Label("Transaction Type: " + transactionType);

        Label amountLabel = new Label("Amount: $" + amount);
        Label dateLabel = new Label("Date: " + LocalDate.now());
        Button backButton = new Button("Back to Menu");
        Button exitButton = new Button("Exit");

        // Receipt button actions
        backButton.setOnAction(e -> {
            showMenuPage();
        });
        exitButton.setOnAction(e -> {
            primaryStage.close();
        });

        // Receipt page layout
        VBox receiptLayout = new VBox(10);
        receiptLayout.getChildren().addAll(receiptLabel, typeLabel, amountLabel, dateLabel, backButton, exitButton);
        receiptLayout.setAlignment(Pos.CENTER);

        Scene receiptScene = new Scene(receiptLayout, 400, 300);
        primaryStage.setScene(receiptScene);
        primaryStage.show();
    }
    
    private void showDepositPage() {
    // Deposit page UI
    Label depositLabel = new Label("Enter amount to deposit:");
    TextField amountField = new TextField();
    Button depositButton = new Button("Deposit");
    Button cancelButton = new Button("Cancel");
    Label errorLabel = new Label();

    // Deposit button actions
    depositButton.setOnAction(e -> {
        try {
            amount = Double.parseDouble(amountField.getText());
            BALANCE += amount;
            showReceiptPage("Deposit", amount);
        } catch (NumberFormatException ex) {
            errorLabel.setText("Invalid amount.");
        }
    });
    cancelButton.setOnAction(e -> {
        showMenuPage();
    });

    // Deposit page layout
    GridPane depositLayout = new GridPane();
    depositLayout.setAlignment(Pos.CENTER);
    depositLayout.setHgap(10);
    depositLayout.setVgap(10);
    depositLayout.setPadding(new Insets(25, 25, 25, 25));
    depositLayout.add(depositLabel, 0, 0);
    depositLayout.add(amountField, 1, 0);
    depositLayout.add(depositButton, 1, 1);
    depositLayout.add(cancelButton, 2, 1);
    depositLayout.add(errorLabel, 1, 2);
    
    Scene depositScene = new Scene(depositLayout, 400, 300);
    primaryStage.setScene(depositScene);
    primaryStage.show();
    
    }
    
    public static void main(String[] args) {
    launch(args);
    }
}