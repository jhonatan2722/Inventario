package org.amigurumiv2;
import controller.*;

//¿Como Funciona?...Sabra Diosito.

public class Main {
    public static void main(String[] args) {
      try{
          Controller c = new Controller();
          c.controlador();
      }catch (RuntimeException e){
          System.out.println(e.getMessage());
      }
    }
}