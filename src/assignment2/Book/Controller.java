package assignment2.Book;

import assignment1.books.Book;
import assignment2.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    public TableView<Book> booksTable;
    public TableColumn<Book, Integer> id;
    public TableColumn<Book, String> title;
    public TableColumn<Book, String> author;

    ObservableList<Book> list = FXCollections.observableArrayList();
    Connector conn = new Connector();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        author.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        title.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        try{
            String sqlTxt = "select * from books";
            ResultSet res = conn.query(sqlTxt);
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
    public void add (assignment2.Book.Book book) {
        try {
            String sqlTxt = "insert into books(id, author, title ) values(?,?,?)";
            PreparedStatement pStm = conn.getPreparedStatement(sqlTxt);
            pStm.setInt(1, book.getId());
            pStm.setString(2, book.getAuthor());
            pStm.setString(3, book.getTitle());
        } catch (Exception err) {
            System.out.println(err);
        }
    }

    public void addBook(ActionEvent actionEvent) {
    }
}
