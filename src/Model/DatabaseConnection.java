package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private String dsn = "jdbc:mysql://localhost:3306/northwind";
    private String user = "root";
    private String pwd = "";

    public DatabaseConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dsn,user,pwd);

        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }catch (SQLException e){
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
        }

    }
    public Connection getConnection(){
        return connection;
    }

    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
