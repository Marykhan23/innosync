import org.junit.jupiter.api.Test;

import java.sql.*;
import java.sql.*;

public class testDB {
        public Connection connection;
        public Statement statement;
        private ResultSet res;
        public String url = "jdbc:postgresql://localhost:5432/portal";
//        public String url = "jdbc:postgresql://localhost:5432/portal?user=postgres&password=gr8L@kes&ssl=false";
        public String user = "postgres";
        public String password = "gr8L@kes";

        @Test
        public void testDB() {
            try {
                connection = DriverManager.getConnection(url, user, password);
//                connection = DriverManager.getConnection(url);
                statement = connection.createStatement();
                res = statement.executeQuery("SELECT * from person where id=3");
                while (res.next()){
                    System.out.println(res.getString(2));
                }
            }catch(SQLException e){
                System.out.println(e.getErrorCode());
            }
//            finally{
//                try {
//                    res.close();
//                    statement.close();
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
        }
}
