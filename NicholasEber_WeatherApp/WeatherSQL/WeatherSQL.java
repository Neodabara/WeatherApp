/*
 */
package WeatherSQL;

/**
 *
 * @author Nicholas.Eber
 */
import java.sql.*;

public class WeatherSQL {

    /*
    private Connection connection;
    private Statement stmt;

    public WeatherSQL() {
        try {
            // load the sqlite-JDBC driver using the current class loader
            String url = "jdbc:sqlite:sample.sqlite";
            //String uName= "app";
            //String pass= "app";
            String driver = "org.sqlite.JDBC";
            Class.forName(driver);

            connection = DriverManager.getConnection(url);
            //Connection connection = DriverManager.getConnection( url );
            System.out.println("connection established");

            Statement stmt = connection.createStatement();
            System.out.println("Statement created");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Driver error: " + cnfe.getMessage());
        } catch (SQLException sqle) {
            System.out.println("SQL error: " + sqle.getMessage());
        }
    }

    public void DBinsert(String city, String state, String temphigh, String templow) {

        try {
            String insertSQL = "INSERT INTO  Weather (CITY, STATE, TEMPHIGH, TEMPLOW)"
                    + "VALUES ('" + city + "', '" + state + "', " + temphigh + ", " + templow + ")";
            int rows = stmt.executeUpdate(insertSQL);

            if (rows == 1) {System.out.println("Location added");}

        } catch (SQLException sqle) {
            System.out.println("SQL error: " + sqle.getMessage());
        }
    }*/

public static void main(String[] args){
        
        System.out.println("HI");

        Connection connection = null;

        String city= "Baltimore";
        String state = "MD";
        
        try {

            // load the sqlite-JDBC driver using the current class loader
            String url = "jdbc:sqlite:sample.sqlite";
            //String uName= "app";
            //String pass= "app";
            String driver = "org.sqlite.JDBC";
            Class.forName(driver);

            connection = DriverManager.getConnection(url);
            //Connection connection = DriverManager.getConnection( url );
            System.out.println("connection established");

            Statement stmt = connection.createStatement();
            System.out.println("Statement created");
            // String sql = "insert into users values( 2, 'Mike', 24 )";
            // String sql = "update users set age = age + 10";

            String sql = "SELECT * FROM Weather";
            ResultSet rs = stmt.executeQuery(sql);
            int i = 1;
            while (rs.next()) {
                System.out.print("row " + i + ": ");
                System.out.print("ID: " + rs.getInt(1));
                System.out.print(" CITY: " + rs.getString(2));
                System.out.print(" STATE: " + rs.getString(3));
                System.out.print(" TEMPHIGH: " + rs.getInt(4));
                System.out.println(" TEMPLOW: " + rs.getInt(5));
                i++;
            }

            // Create Mr. Rogers Employee 
            // (can only add once due to primary key on EmployeeId)
            String insertSQL = "INSERT INTO  Weather (CITY, STATE, TEMPHIGH, TEMPLOW)"
                    + "VALUES ('"+city+"', '"+state+"', 100, 30)";

            int rows = stmt.executeUpdate(insertSQL);
            if (rows == 1) {
                System.out.println("Location added");
            }

        } catch (ClassNotFoundException cnfe) {
            System.out.println("Driver error: " + cnfe.getMessage());
        } catch (SQLException sqle) {
            System.out.println("SQL error: " + sqle.getMessage());
        }
    }
}
