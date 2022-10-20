package assignment3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

import static assignment3.Main.rootStage;

public class Controller {


    public void navigateStudents(ActionEvent actionEvent) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("students/list/list.fxml"));
        rootStage.setTitle("Students");
        rootStage.setScene(new Scene(p, 600, 400));
    }

    public void navigateBooks(ActionEvent actionEvent) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("books/list/list.fxml"));
        rootStage.setTitle("Books");
        rootStage.setScene(new Scene(p, 600, 400));
    }

    public void navigateRecords(ActionEvent actionEvent) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("records/list/list.fxml"));
        rootStage.setTitle("Records");
        rootStage.setScene(new Scene(p, 600, 400));
    }
}
