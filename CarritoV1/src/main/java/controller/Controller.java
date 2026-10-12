package controller;

import dao.*;
import models.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Controller {

    private ProductoDao pd = new ProductoDao();
    private ClienteDao cd = new ClienteDao();
    private ArrayList<Cliente> clientes = cd.mostrarClientes();
    Scanner entry = new Scanner(System.in);
    private ArrayList<Productos> productos =  new ArrayList<>();
    private Cliente usuarioActual = null;
    private ArrayList<Categoria> categoria = pd.verCategorias();

    public void controlador(){

        System.out.println("Ingresa Tu Identificacion: ");
        String identificacion = entry.nextLine();
        System.out.println("Ingresa Tu Contraseña: ");
        String contrasena = entry.nextLine();
        usuarioActual = cd.iniciarSesion(identificacion,contrasena);

        if( usuarioActual == null){
            System.out.println("No se encontro Usuario");
            return;
        }

        System.out.println("Bienvenido "+ usuarioActual.getNombre());

        boolean salir = false;
        while(!salir){

            System.out.println("-----Bienvenido Al Test #1-----\n1.Comprar\n2.Ver Productos");
            String opcion = entry.nextLine();

            switch(opcion){
                case "1"-> {
                    comprar();
                }
                case "2" -> {
                    viewproduct();
                }
                case "3" ->{
                    salir = true;
                    System.out.println("See You Soon !!");
                    entry.close();
                }
                default -> System.out.println("Opcion Invalida");
            }
        }
    }

   /*public void registro(){
        Cliente cl = new Cliente("Andres","1063619029",
                "348499393","carrillosanchezjhonatan335","4994323");
        cd.addClient(cl)
    };*/

    public void viewclients(){

        this.clientes = cd.mostrarClientes();
        for(int i = 0; i<clientes.size(); i++){
            System.out.println(clientes.get(i).getNombre());
        }
    }

//Ni idea que pasa aqui , solo Spaguetti.

     private void comprar() {
        for(int i = 0; i <categoria.size(); i++){
            System.out.println(i + "." + categoria.get(i).getNombre());
        }
        System.out.println("Selecciona Categoria: ");
        int categoriaSeleccionada = entry.nextInt();
        this.productos = pd.mostrarProductos(categoria.get(categoriaSeleccionada).getNombre());
        if(productos.isEmpty()){ System.out.println("Lista Vacia");return;}

       for(int i = 0; i < productos.size(); i++){
           System.out.println(i+"."+ productos.get(i).getDescripcion());
       }

       System.out.println("Ingresa Producto: ");
       int productoSelccionado = entry.nextInt();
       System.out.println("Ingresa Cantidad: ");
       int cantidad = entry.nextInt();
       Productos prdcts = productos.get(productoSelccionado);
       LocalDate fechaVenta = LocalDate.now();
       Venta vn = new Venta(usuarioActual.getId(), prdcts.getId_p(),cantidad,fechaVenta  );
       VentaDao vd = new VentaDao();
       vd.aggVenta(vn);
       System.out.println("Valor de la compra: " + prdcts.getPrecio().multiply(BigDecimal.valueOf(vn.getCantidad())));

     }

     public void viewproduct(){

       if(productos.isEmpty()){

           System.out.println("Productos Vacios");
           return;
       }
       for( int i= 0; i<productos.size(); i++){
           System.out.println(i+".Hola "+productos.get(i).getDescripcion());
       }
     }

     public void addProduct(){

        Productos p = new Productos("HOLA",
                "nose",new BigDecimal("30300"),5);
          pd.addProduct(p);
    }





}
