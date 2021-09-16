package helpers;

import java.sql.*;

public class DB {
    public Connection connection;
    public Statement statement;
    private ResultSet res;
    public String url = "jdbc:postgresql://localhost:5432/portal";
    public String user = "anchor";
    public String password = "gr8L@kes";


    public void connectDB(){
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            res = statement.executeQuery("");
            while (res.next()){
                System.out.println(res.getString(2));
            }

        }catch(SQLException e){
            System.out.println(e.getErrorCode());
        }
    }
}
