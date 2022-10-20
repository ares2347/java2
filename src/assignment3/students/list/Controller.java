package assignment3.students.list;

import assignment3.Main;
import assignment3.books.Book;
import assignment3.helper.Connector;
import assignment3.students.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import static assignment3.Main.rootStage;

public class Controller implements Initializable {
    public TableView<Student> tbStudents;
    public TableColumn<Student, String> tdId;
    public TableColumn<Student, String> tdName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));

        ObservableList<Student> ls = FXCollections.observableArrayList();

        // lay data from database
        try {
            String sql_txt = "Select * from students";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                Student b = new Student(id, name);
                ls.add(b);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            tbStudents.setItems(ls);
        }

    }
    public void navigateHome(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        rootStage.setTitle("Library");
        rootStage.setScene(new Scene(root, 600, 400));
    }

    public void addNewStudent() throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../create/create.fxml"));
        Main.rootStage.setTitle("Add New Students");
        Main.rootStage.setScene(new Scene(listBook, 600, 400));
    }
}
