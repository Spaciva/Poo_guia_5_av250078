package interfacesswing;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmBotonesRadio extends JFrame {

    private DefaultTableModel modelo;

    private JPanel pnlImagenes;
    private JRadioButton rbtOpcion1;
    private JRadioButton rbtOpcion2;
    private JRadioButton rbtOpcion3;
    private JLabel lblImagen;

   public frmBotonesRadio(String title) {
       super(title);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setContentPane(pnlImagenes);
       this.setMinimumSize(new Dimension(400, 400));
       this.setLocationRelativeTo(getParent());
       rbtOpcion1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfacesswing/recursos/img1.jpeg")));


           }
       });
       rbtOpcion2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               lblImagen.setIcon(new
                       javax.swing.ImageIcon(
                       getClass().getResource("/interfacesswing/recursos/img2.jpeg")));
           }
       });
       rbtOpcion3.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               lblImagen.setIcon(new
                       javax.swing.ImageIcon(
                       getClass().getResource("/interfacesswing/recursos/img3.jpeg")));

           }
       });
   }



}
