module fitnessmanager.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens fitnessmanager to javafx.fxml;
    exports fitnessmanager;
}