package game.database;

import game.helper.Vector2D;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    java.sql.Connection conn;
    public Connection(){
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            this.conn = DriverManager.getConnection("jdbc:sqlite:/home/tobias/Documents/Informatik/Grundbegriffe_2_OOP_IntelliJ_v1/src/game.sqlite");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public Vector2D getRabbitPosition() throws SQLException{
        this.conn.setSchema("main");
        Statement stmt= this.conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from rabbit");
        int x= rs.getInt(2);
        int y = rs.getInt(3);
        return new Vector2D(x,y);
    }

    public void setRabbitPosition(Vector2D rabbitPosition) throws SQLException{
        this.conn.setSchema("main");
        Statement stmt= this.conn.createStatement();
        stmt.executeUpdate(String.format("UPDATE rabbit SET x = %s, y = %s WHERE id=1;", rabbitPosition.getIntX(), rabbitPosition.getIntY()));
    }
}
