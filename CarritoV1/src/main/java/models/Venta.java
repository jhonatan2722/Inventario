package models;

import java.time.LocalDate;

public class Venta {

     private int id_venta;
     private int id_cliente;
     private int   id_producto ;
     private int cantidad   ;
     private LocalDate fecha_venta;

     public Venta(int id_cliente, int id_producto, int cantidad, LocalDate fecha_venta){

             this.id_cliente = id_cliente;
             this.id_producto = id_producto;
             this.cantidad = cantidad;
             this.fecha_venta = fecha_venta;

     }
//Se supone es para consultar las ventas ._.
    public Venta( int id_venta, int id_cliente, int id_producto, int cantidad, LocalDate fecha_venta) {

        this.id_venta = id_venta;
        this.id_cliente = id_cliente;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.fecha_venta = fecha_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public int getId_producto() {
        return id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getId_venta() {
        return id_venta;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

}
