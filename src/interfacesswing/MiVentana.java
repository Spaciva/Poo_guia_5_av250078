package interfacesswing;
import javax.swing.*;
public class MiVentana extends JFrame {



    public MiVentana() {
        JLabel lblHola = new JLabel("Hola, soy una Etiqueta JLabel");
//metodo add, heredado de clase JFrame para insertar objeto a su coleccion
//de controles disponibles para presentar en la ventana
        this.add(lblHola);


        //dimensiones de ventana
        this.setSize(500, 200);
        //titulo de ventana
        this.setTitle("Mi primer ventana");
        //cuando cierre ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); //centra ventana en monitor
        this.setVisible(true);
    }

}
