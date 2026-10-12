package config;
import credentials.*;

import java.sql.*;

public class Connect{

    public static Connection connection(){
        Credentials cr = new Credentials();
        Connection con = null;
        try{
            con = DriverManager.getConnection(cr.getUrl(),cr.getUser(),cr.getPassword());
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException("No se puede conectar a la base de datos");

        }
        return con;
    }
}
