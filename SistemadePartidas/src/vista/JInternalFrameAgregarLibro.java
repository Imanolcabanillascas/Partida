/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import controlador.Ctrl_Libro;
import javax.swing.JOptionPane;
import modelo.Libro;
import vista.NewJInternalFrame_GestLibro;

/**
 *
 * @author LENOVO
 */
public class JInternalFrameAgregarLibro extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalFrameAgregarLibro
     */
    public JInternalFrameAgregarLibro() {
        initComponents();
        this.setSize(400, 200);
        this.setTitle("Agregar Libro");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_anioLibro = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 51));
        jLabel1.setText("NUEVO LIBRO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("AÑO/LIBRO:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        txt_anioLibro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_anioLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_anioLibroActionPerformed(evt);
            }
        });
        txt_anioLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_anioLibroKeyPressed(evt);
            }
        });
        getContentPane().add(txt_anioLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 200, 30));

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("GUARDAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 150, 30));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/wall_Nuevo_Libro.png"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_anioLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_anioLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_anioLibroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String anioLibro = txt_anioLibro.getText().trim();

        if (anioLibro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Completar los campos");
            return;
        }

        Libro libro = new Libro();
        Ctrl_Libro controlLibro = new Ctrl_Libro();

        if (controlLibro.existeLibroConAnio(anioLibro)) {
            JOptionPane.showMessageDialog(null, "Dato ingresado anteriormente");
        } else {
            libro.setAnio(anioLibro);

            if (controlLibro.guardar(libro)) {
                JOptionPane.showMessageDialog(null, "Libro guardado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }
        }
        
        txt_anioLibro.setText("");
         NewJInternalFrame_GestLibro frameGestLibro = new NewJInternalFrame_GestLibro();
        frameGestLibro.recargarTablaLibros();
        
     
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_anioLibroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anioLibroKeyPressed
       
    }//GEN-LAST:event_txt_anioLibroKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JTextField txt_anioLibro;
    // End of variables declaration//GEN-END:variables
}
