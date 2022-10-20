package assignment3.records.list;

import assignment3.Main;
import assignment3.helper.Connector;
import assignment3.records.Record;
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
    public TableView<Record> tbRecords;
    public TableColumn<Record, String> tdStudentId;
    public TableColumn<Record, Integer> tdBookId;
    public TableColumn<Record, Integer> tdQty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdStudentId.setCellValueFactory(new PropertyValueFactory<Record, String>("studentId"));
        tdBookId.setCellValueFactory(new PropertyValueFactory<Record, Integer>("bookId"));
        tdQty.setCellValueFactory(new PropertyValueFactory<Record, Integer>("qty"));


        ObservableList<Record> ls = FXCollections.observableArrayList();

        // lay data from database
        try {
            String sql_txt = "Select * from records";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String studentId = rs.getString("studentId");
                Integer bookId = rs.getInt("bookId");
                Integer qty = rs.getInt("qty");
                System.out.println(rs.getInt("qty"));
                Record b = new Record(id, qty, bookId , studentId);
                ls.add(b);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            tbRecords.setItems(ls);
        }

    }
    public void navigateHome(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        rootStage.setTitle("Library");
        rootStage.setScene(new Scene(root, 600, 400));
    }

    public void addNewRecord() throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../create/create.fxml"));
        Main.rootStage.setTitle("Add New Records");
        Main.rootStage.setScene(new Scene(listBook, 600, 400));
    }
}
