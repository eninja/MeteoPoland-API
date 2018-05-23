package pl.eninja;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.assertFalse;

public class MySQL {
    @Test
    public void testMySQLConnection() throws SQLException {

        Connection conn = null;
        try {
            String username = "mieszadl_2018021";
            String password = "5zRBnxuJdZ";
            String dbUrl = "jdbc:mysql://s10.zenbox.pl/mieszadl_20180212";
            conn = DriverManager.getConnection(dbUrl, username, password);
            //TODO replace hardcoded password with value from application.properties
            assertFalse(conn.isClosed());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            assert conn != null;
            conn.close();
        }
    }
}

