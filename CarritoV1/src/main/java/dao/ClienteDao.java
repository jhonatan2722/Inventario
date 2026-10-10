package dao;
import config.*;
import java.sql.*;
import java.util.ArrayList;
import models.*;

public class ClienteDao {

    public void addClient(Cliente cliente){

        String sql = "INSERT INTO clientes(nombre, identificacion, telefono, correo, contrasena)" +
                "VALUES(?,?,?,?,?)";

        try(Connection con = Connect.connection();
         PreparedStatement pstm = con.prepareStatement(sql)){

            pstm.setString(1, cliente.getNombre());
            pstm.setString(2, cliente.getIdentificacion());
            pstm.setString(3, cliente.getTelefono());
            pstm.setString(4, cliente.getCorreo());
            pstm.setString(5, cliente.getContrasena());
            pstm.executeUpdate();

        }catch(SQLException e){

            System.out.println("Error: "+ e.getMessage());
        }
    }

    public ArrayList<Cliente> mostrarClientes (){

        ArrayList<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT id, nombre, identificacion, telefono, correo  FROM clientes";
        try(Connection con = Connect.connection();
            PreparedStatement pstm = con.prepareStatement(sql)
        ){
            try (ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {

                    Cliente cl = new Cliente(rs.getInt("id"), rs.getString("nombre"),
                            rs.getString("identificacion"), rs.getString("telefono"),
                            rs.getString("correo"));

                    clientes.add(cl);
                }

            }



        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return clientes ;
    }


    public Cliente iniciarSesion(String identificacion, String contrasena){

        String sql = "SELECT * FROM clientes WHERE identificacion = ? AND contrasena = ?  ";
        Cliente c = null;
        try(Connection con = Connect.connection();
          PreparedStatement pstm = con.prepareStatement(sql);
         ){

            pstm.setString(1, identificacion);
            pstm.setString(2,contrasena);

           try( ResultSet rs = pstm.executeQuery()){
               if(rs.next()){
                   c = new Cliente(rs.getInt("id"),rs.getString("nombre"),
                           rs.getString("identificacion"),rs.getString("telefono"),
                           rs.getString("correo"));
               }
           }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        return c;

    }


}
