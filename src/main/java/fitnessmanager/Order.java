package fitnessmanager;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order {
    private final StringProperty userId;
    private final StringProperty coach;
    private final StringProperty course;
    private final SimpleDoubleProperty total;

    public Order(String userId, String coach, String course, double total) {
        this.userId = new SimpleStringProperty(userId);
        this.coach = new SimpleStringProperty(coach);
        this.course = new SimpleStringProperty(course);
        this.total = new SimpleDoubleProperty(total);
    }

    public StringProperty userIdProperty() {
        return userId;
    }

    public StringProperty coachProperty() {
        return coach;
    }

    public StringProperty courseProperty() {
        return course;
    }

    public double getTotal() {
        return total.get();
    }

    public SimpleDoubleProperty totalProperty() {
        return total;
    }
}

