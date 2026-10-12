package dao;
import java.sql.*;
import java.util.ArrayList;
import config.*;
import models.*;

public class ProductoDao {


    public static void addProduct(Productos producto){

        try(Connection con = Connect.connection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO productos(descripcion," +
                    "categoria,precio,stock) VALUES(?,?,?,?)"))
        {
            pstm.setString(1, producto.getDescripcion());
            pstm.setString(2, producto.getCategoria());
            pstm.setBigDecimal(3, producto.getPrecio());
            pstm.setInt(4,producto.getStock());
            pstm.executeUpdate();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void  updateProduct(Productos producto ,int cantidad){
        String sql = "UPDATE productos SET stock = stock - ? WHERE id = ? ";
        try(Connection con = Connect.connection();
            PreparedStatement pstm = con.prepareStatement(sql)
            ){

            pstm.setInt(1, cantidad);
            pstm.setInt(2,producto.getId_p());
            pstm.executeUpdate();

        }catch(SQLException e){

        }

    }

    public ArrayList<Productos> mostrarProductos(String categoria){

        ArrayList<Productos> productos = new ArrayList<>();
        String sql = "SELECT id, descripcion, categoria, precio, stock  FROM productos WHERE categoria = ?";
        try(Connection con = Connect.connection();
            PreparedStatement pstm = con.prepareStatement(sql)
        ){  pstm.setString(1,categoria);

            try(ResultSet rs = pstm.executeQuery();) {

                while(rs.next()){

                    Productos pr = new Productos(rs.getInt("id"),rs.getString("descripcion"),
                            rs.getString("categoria"),rs.getBigDecimal("precio"),
                            rs.getInt("stock"));
                    productos.add(pr);
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return productos ;
    }

//Para que crear otra clase dao solo para este metodo???
    public ArrayList<Categoria> verCategorias(){

        ArrayList<Categoria> categoria = new ArrayList<>();
        String sql = "SELECT DISTINCT categoria  FROM productos";
        try(Connection con = Connect.connection();
            PreparedStatement pstm = con.prepareStatement(sql)
        ){
            try(ResultSet rs = pstm.executeQuery();) {
                while(rs.next()){
                    Categoria ct = new Categoria(rs.getString("categoria"));
                    categoria.add(ct);
                }
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return categoria ;
    }
}
