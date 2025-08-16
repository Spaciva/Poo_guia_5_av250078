package aplicacion;
import interfacesswing.MiVentana;
import interfacesswing.frmBotonesRadio;
import interfacesswing.recursos.*;

//Francisco Andres Alas Vasquez av250078

public class Principal {
    public static void main(String[] args) {

    new MiVentana();
   frmPersona formpersona = new frmPersona("Ingreso de datos de una persona");
    formpersona.setVisible(true);
 /*frmBotonesRadio frame = new frmBotonesRadio("Seleccion de imagenes con radioButton");

         frame.setVisible(true);*/
    }
}
