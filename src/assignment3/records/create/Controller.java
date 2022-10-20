package assignment3.records.create;

import assignment3.Main;
import assignment3.books.Book;
import assignment3.helper.Connector;
import assignment3.records.Record;
import assignment3.students.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static assignment1.Main.rootStage;

public class Controller implements Initializable {
   public ComboBox<Student> cbStudents;
   public ComboBox<Book> cbBooks;
   public TextField txtQty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Student> lsStudents = FXCollections.observableArrayList();
        ObservableList<Book> lsBooks = FXCollections.observableArrayList();
        try {
            String students_sql_txt = "Select * from students";
            String books_sql_txt = "Select * from books";
            Connector conn = Connector.getInstance();
            ResultSet studentsRs = conn.query(students_sql_txt);
            ResultSet bookstRs = conn.query(books_sql_txt);
            while (studentsRs.next()) {
                String id = studentsRs.getString("id");
                String name = studentsRs.getString("name");
                Student s = new Student(id, name);
                lsStudents.add(s);
            }
            while (bookstRs.next()) {
                int id = bookstRs.getInt("id");
                String name = bookstRs.getString("name");
                String author = bookstRs.getString("author");
                int qty = bookstRs.getInt("qty");
                Book b = new Book(id, name, author, qty);
                lsBooks.add(b);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            cbStudents.setItems(lsStudents);
            cbBooks.setItems(lsBooks);
        }

    }

    public void navigateHome(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../home.fxml"));
        rootStage.setTitle("Library");
        rootStage.setScene(new Scene(root, 600, 400));
    }

    public void submit(ActionEvent actionEvent) {
        try {
            Student student = cbStudents.getValue();
            Book book = cbBooks.getValue();
            Integer qty = Integer.parseInt(txtQty.getText());
            String sql_txt = "insert into records(bookId,studentId,qty) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(student.getId());
            arr.add(book.getId());
            arr.add(qty);

            if(conn.execute(sql_txt,arr)){
                backToList();
            }else {
                System.out.println("Error");
            }

//            String sql_txt2 = "select * from books where id = ?";
//            ArrayList pr = new ArrayList();
//            pr.add(1);
//            ResultSet bookwithid1 = conn.executeQuery(sql_txt2,pr);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private void backToList() throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Records");
        Main.rootStage.setScene(new Scene(listBook,600,400));
    }
}
