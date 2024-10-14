package fitnessmanager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {
    @FXML private Button button_log_out;
    @FXML private Button lg_dashboard;
    @FXML private Button lg_coach;
    @FXML private Button lg_order;
    @FXML private Button lg_feedback;
    @FXML private Button lg_pay;
    @FXML private Button pay_button;
    @FXML private AnchorPane lg_dash;
    @FXML private AnchorPane lg_coaches;
    @FXML private AnchorPane lg_orderview;
    @FXML private AnchorPane lg_feedbackview;
    @FXML private AnchorPane lg_payview;
    @FXML private Label label_payname;
    @FXML private Label label_user;
    @FXML private TextField pay_money;
    @FXML private Label pay_card;
    @FXML private Pane tab_order;
    @FXML private Button bt_addcourse;
    @FXML private Button bt_addcourse1;
    @FXML private Button bt_addcourse2;
    @FXML private Button bt_addcourse3;
    @FXML private Button bt_addcourse4;
    @FXML private Button bt_addcourse5;
    @FXML private Button orderButton;
    @FXML private Button cancelButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showDashboard();
        lg_dashboard.setOnAction(event -> showDashboard());
        lg_coach.setOnAction(event -> showCoaches());
        lg_order.setOnAction(event -> showOrder());
        lg_pay.setOnAction(event -> showPay());
        lg_feedback.setOnAction(event -> showFeedBack());

        button_log_out.setOnAction(event -> {
            DBUtis.changeScene(event, "Login.fxml", "Login", null, null);
        });

        lg_dashboard.setOnMouseClicked(event -> highlightButton(lg_dashboard));
        lg_coach.setOnMouseClicked(event -> highlightButton(lg_coach));
        lg_order.setOnMouseClicked(event -> highlightButton(lg_order));
        lg_pay.setOnMouseClicked(event -> highlightButton(lg_pay));
        lg_feedback.setOnMouseClicked(event -> highlightButton(lg_feedback));
        // tab_order
        tab_order.setVisible(false);
        bt_addcourse.setOnAction(event -> {tab_order.setVisible(true);});
        bt_addcourse1.setOnAction(event -> {tab_order.setVisible(true);});
        bt_addcourse2.setOnAction(event -> {tab_order.setVisible(true);});
        bt_addcourse3.setOnAction(event -> {tab_order.setVisible(true);});
        bt_addcourse4.setOnAction(event -> {tab_order.setVisible(true);});
        bt_addcourse5.setOnAction(event -> {tab_order.setVisible(true);});
        orderButton.setOnAction(event -> {tab_order.setVisible(false);});
        cancelButton.setOnAction(event -> {tab_order.setVisible(false);});
    }

    private void highlightButton(Button button) {
        resetButtonStyles();
        button.setStyle("-fx-background-color: transparent; -fx-cursor: pointer; -fx-font-weight: bold; -fx-text-fill: yellow;"); // Highlight the selected button
    }
    private void showDashboard() {
        System.out.println("showDashboard called");
        lg_dash.setVisible(true);
        lg_coaches.setVisible(false);
        lg_orderview.setVisible(false);
        lg_feedbackview.setVisible(false);
        lg_payview.setVisible(false);
    }

    private void showCoaches() {
        System.out.println("showCoaches called");
        lg_dash.setVisible(false);
        lg_coaches.setVisible(true);
        lg_orderview.setVisible(false);
        lg_feedbackview.setVisible(false);
        lg_payview.setVisible(false);
    }

    private void showOrder() {
        System.out.println("showOrder called");
        lg_dash.setVisible(false);
        lg_coaches.setVisible(false);
        lg_orderview.setVisible(true);
        lg_feedbackview.setVisible(false);
        lg_payview.setVisible(false);
    }

    private void showPay() {
        System.out.println("showPay called");
        lg_dash.setVisible(false);
        lg_coaches.setVisible(false);
        lg_orderview.setVisible(false);
        lg_feedbackview.setVisible(false);
        lg_payview.setVisible(true);
    }

    private void showFeedBack() {
        System.out.println("showFeedBack called");
        lg_dash.setVisible(false);
        lg_coaches.setVisible(false);
        lg_orderview.setVisible(false);
        lg_feedbackview.setVisible(true);
        lg_payview.setVisible(false);
    }

    private void resetButtonStyles() {
        lg_dashboard.setStyle("");
        lg_coach.setStyle("");
        lg_order.setStyle("");
        lg_pay.setStyle("");
        lg_feedback.setStyle("");
    }


    public void setUserInfomation(String username, String favRapper) {
        label_payname.setText("NAP" +" "+ username);
        label_user.setText(username);
    }
}
