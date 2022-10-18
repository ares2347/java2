package assignment1.records;

import assignment1.books.Book;
import assignment1.students.Student;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static assignment1.Main.rootStage;

public class Controller implements Initializable {
    public TableView<Book> tbBooks;
    public TableColumn<Book, Integer> bookId;
    public TableColumn<Student,Integer> studentId;
    public TableColumn<Book, Integer> amount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookId.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        studentId.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
    }

    public void navigateHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../home.fxml"));
        rootStage.setTitle("Library");
        rootStage.setScene(new Scene(root, 600, 400));
    }

}
