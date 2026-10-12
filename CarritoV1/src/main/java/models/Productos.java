package models;

import java.math.BigDecimal;

public class Productos {

    private int id_p ;
    private String descripcion;
    private String categoria;
    private BigDecimal precio;
    private  int stock;

    public Productos(String descripcion, String categoria, BigDecimal precio, int stock){

        if(descripcion.trim().isEmpty()){
            throw new IllegalArgumentException("La descripcion Del producto no puede estar vacia");
        }
        if(categoria.trim().isEmpty()){
            throw new IllegalArgumentException("La Categoria Del producto no puede estar vacia");
        }
        if(precio.compareTo(BigDecimal.ZERO)<0){
            throw new IllegalArgumentException("El precio  Del producto no puede ser Menor a 0");
        }
        if(stock <0){
            throw new IllegalArgumentException("El Stock del producto no puede ser menor a 0");
        }
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public Productos(int id_p, String descripcion, String categoria, BigDecimal precio, int stock){

        this.id_p = id_p;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId_p() {
        return id_p;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

}
