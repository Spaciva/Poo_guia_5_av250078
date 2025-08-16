package interfacesswing.recursos;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class frmPersona extends JFrame{
    private DefaultTableModel modelo;
    //VARIABLES PARA LEER EL CSV
    private BufferedReader lector;
   /* private String linea;
    private String parte[]=null;*///almacena cada linea leida








    private JPanel pnlPersona;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtTelefono;
    private JComboBox cmbSexo;
    private JLabel lbl1;
    private JButton btnObtenerDatos;
    private JButton btnLimpiar;
    private JPanel pnlBotones;
    private JTable tblDatos;

    public frmPersona(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlPersona);
        this.setMinimumSize(new Dimension(600, 500));
        this.setLocationRelativeTo(getParent());
                          //Arreglo de objeto, para inicializar con vacio la tabla
        Object [][] data=null;
                          //Arreglo de String para crear los nombres de las columnas
        String[] colums= {
                "Id", "Nombres", "Edad","Telefono", "Sexo"
        };




//Instancia del modelo
        modelo= new DefaultTableModel(data, colums);



// Cargar datos desde CSV




//Seteo del modelo, el cual tendra la estructura que permitira
// a la tabla representar los datos
        tblDatos.setModel(modelo);
        leercsv();

        btnObtenerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnObtenerDatos();
                btnLimpiar();
            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLimpiar();
            }
        });
        tblDatos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tblObtenerFila(e);
            }
        });
    }
    private void btnObtenerDatos() {
        String id;
        String nombre;
        String edad;
        String telefono;
        String sexo;
        id = txtId.getText();
        nombre = txtNombre.getText();
        edad = txtEdad.getText();
        telefono = txtTelefono.getText();
        sexo = cmbSexo.getSelectedItem().toString();
        JOptionPane.showMessageDialog(null,"Datos obtenidos: \n ID"+ id+
                "\n nombres: "+ nombre +"\n Edad: "+edad+
                "\n Telefono: "+telefono+ "\n Sexo: "+ sexo);
        Object[] newRow = {id,nombre,edad,telefono,sexo};
        //agrega contenido del vector como una fila de tabla modelo
        modelo.addRow(newRow);


    }
     private void leercsv(){

             File archivo = new File("src/datos/persona.csv");


             try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                 String linea;
                 boolean primera = true;
              //leer linea por linea hasta que no se encuentren mas
                 while ((linea = br.readLine()) != null) {
                     //la primera no se leera
                     if (primera) {
                         primera = false; // Saltar encabezado
                         continue;
                     }
                  // Dividimos la línea en partes usando la coma como separador
                     String[] datos = linea.split(",");
                     if (datos.length == 5) {
                         Object[] fila = {datos[0], datos[1], datos[2], datos[3], datos[4]};
                         modelo.addRow(fila);
                     }
                 }
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Error al leer el archivo CSV:\n" + e.getMessage());
             }








     }

    private void btnLimpiar() {
        //borra contenido actual de los controles del form
        txtId.setText("");
        txtNombre.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        //pone el combobox en su valor de índice 0
        cmbSexo.setSelectedIndex(0);
        txtId.requestFocus(); //recibe el foco
    }
    private void tblObtenerFila(MouseEvent e) {
        //obtiene num. fila y columna celda de tabla en donde usuario hace click
        int fila = tblDatos.rowAtPoint(e.getPoint());
        int columna = tblDatos.columnAtPoint(e.getPoint());
        //traslada datos de fila hacia controles del form,
        //solo si la tabla ya tiene datos
        if((fila>-1)&&(columna>-1)){
            txtId.setText(modelo.getValueAt(fila, 0).toString());
            txtNombre. setText(modelo.getValueAt(fila, 1).toString());
            txtEdad. setText(modelo.getValueAt(fila, 2).toString());
            txtTelefono. setText(modelo.getValueAt(fila, 3).toString());
            cmbSexo.setSelectedItem(modelo.getValueAt(fila, 4).toString());

        }

    }
}
