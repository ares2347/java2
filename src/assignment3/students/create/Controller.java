package assignment3.students.create;

import assignment3.Main;
import assignment3.helper.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.util.ArrayList;


public class Controller {
    public TextField txtName;
    public TextField txtId;

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String id = txtId.getText();
            String sql_txt = "insert into students(id, name) values(?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(id);
            arr.add(name);
            if(conn.execute(sql_txt,arr)){
                backToList();
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void backToList() throws Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Students");
        Main.rootStage.setScene(new Scene(listStudent,600,400));
    }

}
