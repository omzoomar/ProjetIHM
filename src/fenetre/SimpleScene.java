package fenetre;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class SimpleScene extends Application {
	public void start(Stage stage) {
		VBox root = new VBox();
		Label msg = new Label("");
		root.getChildren().add(msg);
		Scene scene = new Scene(root, 300, 50);
		stage.setScene(scene);
		stage.setTitle("");
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
