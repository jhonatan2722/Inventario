package org.amigurumiv2;
import controller.*;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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