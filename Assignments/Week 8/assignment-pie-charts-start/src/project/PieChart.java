import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class PieChart extends Application {
    GridPane r = new GridPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primStage) {
        r.setAlignment(Pos.CENTER);
        r.setHgap(20);
        r.setVgap(10);

        Scene scene = new Scene(r, 500, 300);
        primStage.setTitle("Pie chart");
        primStage.setScene(scene);
        primStage.show();

        SimpleIntegerProperty i1 = new SimpleIntegerProperty(1);
        SimpleIntegerProperty i2 = new SimpleIntegerProperty(1);
        SimpleIntegerProperty i3 = new SimpleIntegerProperty(1);
        SimpleIntegerProperty i4 = new SimpleIntegerProperty(1);

        TextField tf1 = textField(i1);
        TextField tf2 = textField(i2);
        TextField tf3 = textField(i3);
        TextField tf4 = textField(i4);

        Label l1 = new Label();
        Label l2 = new Label();
        Label l3 = new Label();
        Label l4 = new Label();
        Label totalLabel = new Label();

        SimpleDoubleProperty total = new SimpleDoubleProperty(1);
        total.bind(i1.add(i2.add(i3.add(i4))));
        totalLabel.textProperty().bind(total.asString());

        r.add(tf1, 0, 1);
        r.add(tf2, 0, 2);
        r.add(tf3, 0, 3);
        r.add(tf4, 0, 4);

        r.add(l1, 1, 1);
        r.add(l2, 1, 2);
        r.add(l3, 1, 3);
        r.add(l4, 1, 4);

        l1.textProperty().bind(i1.divide(total).asString("%.4f"));
        l2.textProperty().bind(i2.divide(total).asString("%.4f"));
        l3.textProperty().bind(i3.divide(total).asString("%.4f"));
        l4.textProperty().bind(i4.divide(total).asString("%.4f"));
    }

    private TextField textField(SimpleIntegerProperty i) {
        TextField tf = new TextField();
        tf.textProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(
                            ObservableValue<? extends String> observable,
                            String oldValue, String newValue) {
                        if (!newValue.matches("[1-9]\\d{0,3}")) {
                            tf.setText(oldValue);
                        }
                    }
                });
        tf.textProperty().bindBidirectional(i, new NumberStringConverter());
        return tf;
    }
}