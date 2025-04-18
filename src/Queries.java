import java.sql.*;

public class Queries {
   
        public static ResultSet getAllStudents(Connection connection){
            ResultSet set;
            try {
                
                Statement statement = connection.createStatement();
                set = statement.executeQuery("SELECT id, name1, name2, rocnik, obor FROM students");
            } 
            catch (SQLException e) {
                return null;
            }
            return set;
        }
}
