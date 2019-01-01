/*
 */
package WeatherSQL;

/**
 *
 * @author Nicholas.Eber
 */
import java.sql.*;

public class WeatherSQL {

    public static void DBinsert(String city, String state,
            String code, String date, String day,
            String high, String low, String text) {
        Connection connection = null;

        try {
            // load the sqlite-JDBC driver using the current class loader
            String url = "jdbc:sqlite:sample.sqlite";
            String driver = "org.sqlite.JDBC";
            Class.forName(driver);

            // Connect to DataBase
            connection = DriverManager.getConnection(url);
            System.out.println("\nWeatherSQL.DBinsert.connection established");

            // Creat a Statement
            Statement stmt = connection.createStatement();
            System.out.println("WeatherSQL.DBinsert.statement created");

            // Create Add new Weather location and data
            // (can duplicate for testing)
            String insertSQL = "INSERT INTO  Weather (CITY, STATE, CODE, DATE, DAY, HIGH, LOW, TEXT)"
                    + "VALUES ('"
                    + city + "', '"
                    + state + "', '"
                    + code + "', '"
                    + date + "', '"
                    + day + "', '"
                    + high + "', '"
                    + low + "', '"
                    + text + "')";

            int rows = stmt.executeUpdate(insertSQL);
            if (rows == 1) {
                System.out.println("WeatherSQL.DBinsert.location added");
            }

        } catch (ClassNotFoundException cnfe) {
            System.out.println("WeatherSQL.DBinsert.Driver error: " + cnfe.getMessage());
        } catch (SQLException sqle) {
            System.out.println("WeatherSQL.DBinsert.SQL error: " + sqle.getMessage());
        } finally {
            try {
                connection.close();
                System.out.println("WeatherSQL.DBinsert.connection closed\n");
            } catch (SQLException sqle) {
                System.out.println("WeatherSQL.DBinsert.connection closed error: " + sqle.getMessage());
            }
        }
    }

    public static void DBread() {

        Connection connection = null;

        try {

            // load the sqlite-JDBC driver using the current class loader
            String url = "jdbc:sqlite:sample.sqlite";
            String driver = "org.sqlite.JDBC";
            Class.forName(driver);

            //Connect to DataBase
            connection = DriverManager.getConnection(url);
            System.out.println("\nWeatherSQL.DBread.connection established");

            //Creat a Statement
            Statement stmt = connection.createStatement();
            System.out.println("WeatherSQL.DBread.statement created");

            //create Query and extract info from DataBase
            String sql = "SELECT * FROM Weather";
            ResultSet rs = stmt.executeQuery(sql);
            int i = 1;
            while (rs.next()) {
                System.out.print("(ID: " + rs.getInt(1));
                System.out.print(") (CITY: " + rs.getString(2));
                System.out.print(") (STATE: " + rs.getString(3));
                System.out.print(") (CODE: " + rs.getString(4));
                System.out.print(") (DATE: " + rs.getString(5));
                System.out.print(") (DAY: " + rs.getString(6));
                System.out.print(") (HIGH: " + rs.getInt(7));
                System.out.print(") (LOW: " + rs.getInt(8));
                System.out.println(") (TEXT: " + rs.getString(9) + ")");
                i++;
            }

        } catch (ClassNotFoundException cnfe) {
            System.out.println("WeatherSQL.DBread.Driver error: " + cnfe.getMessage());
        } catch (SQLException sqle) {
            System.out.println("WeatherSQL.DBread.SQL error: " + sqle.getMessage());
        } finally {
            try {
                connection.close();
                System.out.println("WeatherSQL.DBread.connection closed\n");
            } catch (SQLException sqle) {
                System.out.println("WeatherSQL.DBread.connection closed error: " + sqle.getMessage());
            }
        }
    }

    public static void DBdelete(String city, String state){
       Connection connection = null;

        try {
            // load the sqlite-JDBC driver using the current class loader
            String url = "jdbc:sqlite:sample.sqlite";
            String driver = "org.sqlite.JDBC";
            Class.forName(driver);

            // Connect to DataBase
            connection = DriverManager.getConnection(url);
            System.out.println("\nWeatherSQL.DBdelete.connection established");

            // Creat a Statement
            Statement stmt = connection.createStatement();
            System.out.println("WeatherSQL.DBdelete.statement created");

            // delete Weather location and data
            // (can duplicate for testing)
            String deleteSQL = "DELETE FROM Weather " 
                    +"WHERE CITY = '"+city+"' " 
                    +"AND STATE = '"+state+"'";

            int rows = stmt.executeUpdate(deleteSQL);
            if (rows == 1) {
                System.out.println("WeatherSQL.DBdelete.location deleted");
            }

        } catch (ClassNotFoundException cnfe) {
            System.out.println("WeatherSQL.DBdelete.Driver error: " + cnfe.getMessage());
        } catch (SQLException sqle) {
            System.out.println("WeatherSQL.DBdelete.SQL error: " + sqle.getMessage());
        } finally {
            try {
                connection.close();
                System.out.println("WeatherSQL.DBdelete.connection closed\n");
            } catch (SQLException sqle) {
                System.out.println("WeatherSQL.DBdelete.connection closed error: " + sqle.getMessage());
            }
        } 
    }
    
    public static void DBdeleteAll(){
        Connection connection = null;

        try {
            // load the sqlite-JDBC driver using the current class loader
            String url = "jdbc:sqlite:sample.sqlite";
            String driver = "org.sqlite.JDBC";
            Class.forName(driver);

            // Connect to DataBase
            connection = DriverManager.getConnection(url);
            System.out.println("\nWeatherSQL.DBdeleteAll.connection established");

            // Creat a Statement
            Statement stmt = connection.createStatement();
            System.out.println("WeatherSQL.DBdeleteAll.statement created");

            // delete Weather location and data
            // (can duplicate for testing)
            String deleteSQL = "DELETE FROM Weather";

            int rows = stmt.executeUpdate(deleteSQL);
            if (rows == 1) {
                System.out.println("WeatherSQL.DBdeleteAll.location All Deleted");
            }

        } catch (ClassNotFoundException cnfe) {
            System.out.println("WeatherSQL.DBdeleteAll.Driver error: " + cnfe.getMessage());
        } catch (SQLException sqle) {
            System.out.println("WeatherSQL.DBdeleteAll.SQL error: " + sqle.getMessage());
        } finally {
            try {
                connection.close();
                System.out.println("WeatherSQL.DBdeleteAll.connection closed\n");
            } catch (SQLException sqle) {
                System.out.println("WeatherSQL.DBdeleteAll.connection closed error: " + sqle.getMessage());
            }
        } 
    }
    
    public static WeatherRSS.Forcast DBdaliyRead(String city, String state,
            String date) {
        WeatherRSS.Forcast forcast = new WeatherRSS.Forcast();

        Connection connection = null;

        try {

            // load the sqlite-JDBC driver using the current class loader
            String url = "jdbc:sqlite:sample.sqlite";
            String driver = "org.sqlite.JDBC";
            Class.forName(driver);

            //Connect to DataBase
            connection = DriverManager.getConnection(url);
            System.out.println("\nWeatherSQL.DBdaliyRead.connection established");

            //Creat a Statement
            Statement stmt = connection.createStatement();
            System.out.println("WeatherSQL.DBdaliyRead.Statement created");

            //create Query and extract info from DataBase
            String sql = "SELECT * FROM Weather \n"
                    + "WHERE CITY = \"" + city + "\" \n"
                    + "AND STATE = \"" + state + "\"\n"
                    + "AND DATE =\"" + date + "\"";
            ResultSet rs = stmt.executeQuery(sql);
            int i = 1;
            while (rs.next()) {
                System.out.print("(ID: " + rs.getInt(1));

                System.out.print(") (CITY: " + rs.getString(2));
                forcast.setCity(rs.getString(2));

                System.out.print(") (STATE: " + rs.getString(3));
                forcast.setState(rs.getString(3));

                System.out.print(") (CODE: " + rs.getString(4));
                forcast.setCode(rs.getString(4));

                System.out.print(") (DATE: " + rs.getString(5));
                forcast.setDate(rs.getString(5));

                System.out.print(") (DAY: " + rs.getString(6));
                forcast.setDay(rs.getString(6));

                System.out.print(") (HIGH: " + rs.getInt(7));
                forcast.setHigh(rs.getString(7));

                System.out.print(") (LOW: " + rs.getInt(8));
                forcast.setLow(rs.getString(8));

                System.out.println(") (TEXT: " + rs.getString(9) + ")");
                forcast.setText(rs.getString(9));
                break;
            }

        } catch (ClassNotFoundException cnfe) {
            System.out.println("WeatherSQL.DBdaliyRead.Driver error: " + cnfe.getMessage());
        } catch (SQLException sqle) {
            System.out.println("WeatherSQL.DBdaliyRead.SQL error: " + sqle.getMessage());
        } finally {
            try {
                connection.close();
                System.out.println("WeatherSQL.DBdaliyRead.connection closed\n");
            } catch (SQLException sqle) {
                System.out.println("WeatherSQL.DBdaliyRead.connection close error: " + sqle.getMessage());
            }
        }

        return forcast;
    }

    public static void main(String[] args) {

        //test DBinsert
        DBinsert("woodbine", "MD", "21", "3-14-16", "thu", "200", "-200", "hell");

        DBread();
        
        //test DBdelete
        //DBdelete("woodbine", "MD");
        
        DBread(); 
        
        //test DBdelete ALL
        DBdeleteAll();
        
        DBread();

    }
}
