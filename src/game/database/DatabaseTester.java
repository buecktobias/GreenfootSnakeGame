package game.database;

import game.helper.Vector2D;

import java.sql.SQLException;

public class DatabaseTester {
    public static void main(String[] args) {
        Connection con = new Connection();
        try {
            con.getRabbitPosition();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            con.setRabbitPosition(new Vector2D(100, 250));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
