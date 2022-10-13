package assignment1.students;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

import static assignment1.Main.rootStage;

public class Controller {
    public void navigateHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../home.fxml"));
        rootStage.setTitle("Library");
        rootStage.setScene(new Scene(root, 600, 400));
    }
}
