package game.database;

import java.sql.SQLException;

public class DatabaseTester {
    public static void main(String[] args) {
        Connection con = new Connection();
        try {
            con.getRabbitPosition();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
