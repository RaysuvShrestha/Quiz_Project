package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabaseConnection {

    String url="jdbc:mysql://localhost:3306/devquiz";

    String username="root";
    String password="root";

    public static Connection connection = null;

    public DatabaseConnection(){
        try{
            try {

                Class.forName("com.mysql.jdbc.Driver");
                connection= DriverManager.getConnection(url,username,password);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
    public PreparedStatement getPreparedStatement(String query){
        PreparedStatement pstm=null;

        try {
            pstm=connection.prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstm;
    }
}
