package fitnessmanager;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    @FXML private Button button_signup;
    @FXML private Button button_log_in;
    @FXML private RadioButton rb_youngltc;
    @FXML private RadioButton rb_mck;
    @FXML private TextField tf_username;
    @FXML private TextField tf_password;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup toggleGroup = new ToggleGroup();
        rb_youngltc.setToggleGroup(toggleGroup);
        rb_mck.setToggleGroup(toggleGroup);

        rb_youngltc.setSelected(true);

        button_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
                if (!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty()) {
                    DBUtis.signUpUser(event, tf_username.getText(), tf_password.getText(), toggleName);
                }else {
                    System.out.println("Username and password cannot be empty");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Username and password cannot be empty");
                    alert.show();
                }
            }
        });
        button_log_in.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtis.changeScene(event, "Login.fxml", "Login", null, null);
            }
        });
    }
}
