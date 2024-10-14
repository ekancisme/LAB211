package fitnessmanager;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class OrderController {

    @FXML
    private TableView<Order> orderTable;
    @FXML
    private TableColumn<Order, String> userIdColumn;
    @FXML
    private TableColumn<Order, String> coachColumn;
    @FXML
    private TableColumn<Order, String> courseColumn;
    @FXML
    private TableColumn<Order, Double> totalColumn;
    @FXML
    private Label userInfoLabel;
    @FXML
    private Label balanceLabel;
    @FXML
    private Label totalLabel;
    @FXML
    private Button payButton;

    private double totalPayment; // Keep track of the total payment

    @FXML
    private void initialize() {
        // Initialize the columns in the table
        userIdColumn.setCellValueFactory(cellData -> cellData.getValue().userIdProperty());
        coachColumn.setCellValueFactory(cellData -> cellData.getValue().coachProperty());
        courseColumn.setCellValueFactory(cellData -> cellData.getValue().courseProperty());
        totalColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTotal()).asObject());

        // Example data (this would be replaced with actual data)
        orderTable.getItems().add(new Order("User1", "Coach A", "Course 1", 100.0));
        orderTable.getItems().add(new Order("User2", "Coach B", "Course 2", 150.0));

        // Set user information and balance
        userInfoLabel.setText("User Info: John Doe");
        balanceLabel.setText("Balance: $200.0");

        // Calculate total payment
        calculateTotalPayment();
    }

    private void calculateTotalPayment() {
        totalPayment = orderTable.getItems().stream()
                .mapToDouble(Order::getTotal)
                .sum();
        totalLabel.setText("Total Payment: $" + totalPayment);
    }

    @FXML
    private void handlePayment() {
        // Handle payment logic here
        System.out.println("Processing payment of $" + totalPayment);

        // Example logic to simulate payment processing
        if (totalPayment > 0) {
            // You can add additional logic here, such as updating the user's balance,
            // confirming the payment, and more.
            System.out.println("Payment of $" + totalPayment + " processed successfully.");

            // Optionally, reset the order table and total payment after successful payment
            orderTable.getItems().clear(); // Clear the order items
            totalPayment = 0; // Reset total payment
            totalLabel.setText("Total Payment: $0.0"); // Update total label
        } else {
            System.out.println("No payment to process.");
        }
    }
}

