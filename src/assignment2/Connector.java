package assignment2;

import java.sql.*;
import java.util.ArrayList;

public class Connector {
    public final static String connectionString = "jdbc:mysql://localhost:3306/java2";
    public final static String user = "root";
    public final static String pwd = "";// neu la xampp: "" , mamp: "root"

    private static Connector newConn;
    Connection conn;

    public Connector() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(connectionString,user,pwd);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Connector getInstance(){
        return (newConn == null)? new Connector(): newConn;
    }

    public Statement getStatement() throws Exception{
        return conn.createStatement();
    }

    public ResultSet query(String sql){
        try {
            return getStatement().executeQuery(sql);
        }catch (Exception e){
            return null;
        }
    }

    public boolean executeQuery(String sql){
        try {
            getStatement().execute(sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public PreparedStatement getPreparedStatement(String sql) throws Exception{
        return conn.prepareStatement(sql);
    }

    public boolean execute(String sql, ArrayList params) throws Exception{
        try {
            PreparedStatement pStm = getPreparedStatement(sql);
            for(int i=0; i<params.size();i++){
                if(params.get(i) instanceof Integer){
                    pStm.setInt(i+1, (Integer) params.get(i));
                } else if (params.get(i) instanceof Double) {
                    pStm.setDouble(i+1, (Double) params.get(i));
                } else {
                    pStm.setString(i+1, (String) params.get(i));
                }
            }
            pStm.execute();
            return true;
        }catch ( Exception e){
            return false;
        }
    }
}