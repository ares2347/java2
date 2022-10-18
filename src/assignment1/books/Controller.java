package assignment1.books;

import assignment1.students.Student;
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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static assignment1.Main.rootStage;

public class Controller implements Initializable {
    //config db connection
    public final static String connectionString = "jdbc:mysql://localhost:3306/java2";
    public final static String user ="root";
    public final static String password = "";

    public TableView<Book> booksTable;
    public TableColumn<Book, Integer> id;
    public TableColumn<Student,String> titleId;
    public TableColumn<Book, Integer> amount;

    ObservableList<Book> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        id.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        amount.setCellValueFactory(new PropertyValueFactory<Book, Integer>("amount"));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString, user, password);
            Statement statement = conn.createStatement();
            String sqlTxt = "Select * from books";
            ResultSet res = statement.executeQuery(sqlTxt);
            while (res.next()){
                int id = res.getInt("id");
                String title = res.getString("title");
                int amount = res.getInt("amount");
                list.add(new Book(title, id, amount));
            }
            booksTable.setItems(list);
        }catch(Exception err){
            System.out.println(err);
        }finally {

        }
    }

    public void navigateHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../home.fxml"));
        rootStage.setTitle("Library");
        rootStage.setScene(new Scene(root, 600, 400));
    }



}
