
package dao;
import config.*;
import models.Venta;
import java.sql.*;

public class VentaDao {

    public void aggVenta(Venta venta){

         try(Connection con = Connect.connection();
          PreparedStatement pstm = con.prepareStatement("INSERT INTO ventas(id_cliente, id_producto," +
                  "cantidad, fecha_venta) VALUES  (?,?,?,?)")){

             pstm.setInt(1,venta.getId_cliente());
             pstm.setInt(2,venta.getId_producto());
             pstm.setInt(3,venta.getCantidad());
             pstm.setDate(4,Date.valueOf(venta.getFecha_venta()));
             pstm.executeUpdate();

         }catch(SQLException e){

             System.out.println(e.getMessage());
         }
    }

}
