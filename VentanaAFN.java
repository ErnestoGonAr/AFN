import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VentanaAFN extends Application{

  public void start(Stage stage) {

    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(5));
    gridPane.setHgap(5);
    gridPane.setVgap(5);

    Group root = new Group(gridPane);
    Scene scene = new Scene(root, 800, 600);

    stage.setTitle("Validador de cadenas de AFN");
    stage.setScene(scene);
    stage.show();
}

}
