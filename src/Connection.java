import exceptions.PersistenceException;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {

    int position;

    public Connection(int position) {
        this.position = position;
    }

    public java.sql.Connection getConnection(String url, String user, String password) {
        java.sql.Connection con = null;
        try {
            // MySql : com.mysql.jdbc.Driver
            // Oracle : oracle.jdbc.OracleDriver
            // PostgreSQL : org.postgersql.Driver
            // hsql : org.hsqldb.jdbcDriver
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public java.sql.Connection getConnection() {
        // MySql :"jdbc:mysql://localhost:3306/NomBase"
        // Oracle :"jdbc:oracle:thin:@localhost:1521:NomInstance"
        // hsql : jdbc:hsqldb:file:testdb
        // jdbc:hsqldb:mem:mymemdb
        return getConnection("jdbc:mysql://localhost:3306/prog4_2018", "root", "root");
    }





    public void closeAll(java.sql.Connection con, Statement stmt, ResultSet rs) {
        try {
            if (stmt != null) stmt.close();
            if (rs != null) rs.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            throw new PersistenceException("Failed to close JDBC resources", e);
        }
    }
}
