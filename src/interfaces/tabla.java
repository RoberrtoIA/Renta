/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Renta;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author rober
 */
public class tabla extends javax.swing.JFrame {

    /**
     * Creates new form tabla
     */
    
    ArrayList<Renta> lista;
    DefaultTableModel modelo;
    String[] meses;
    ImageIcon icon;
    
    //datos a exportar al pdf, son los totales ya
    double aguinaldo;
    double aguinaldo_renta;
    double total_remuneracion;
    double renta;
    double afp;
    double isss;
    double ingresos;
    double salariototal;
    String nit;
    String nombre;
    //hasta aqui
   
    public tabla(ArrayList<Renta> lista, double aguinaldo, double aguinaldo_renta, String nit, String nombre) {
        initComponents();
        this.setLocationRelativeTo(null);
        icon = new ImageIcon(getClass().getClassLoader().getResource("cuenta.png"));
        this.setIconImage(icon.getImage());
        this.lista = lista;
        this.aguinaldo = aguinaldo;
        this.aguinaldo_renta = aguinaldo_renta;
        this.nit = nit;
        total_remuneracion = 0;
        renta = 0;
        afp = 0;
        isss = 0;
        ingresos = 0;
        salariototal = 0;
        this.nombre = nombre;
        this.setTitle("Registro de retenciones de Enero a Diciembre");
        modelo = (DefaultTableModel) this.jTable1.getModel();
        this.jLabel2.setText(Double. toString(this.aguinaldo_renta));
        this.jLabel3.setText(Double. toString(this.aguinaldo - this.aguinaldo_renta));
        this.meses = new String[12];
        this.meses[0] = "Enero";
        this.meses[1] = "Febrero";
        this.meses[2] = "Marzo";
        this.meses[3] = "Abril";
        this.meses[4] = "Mayo";
        this.meses[5] = "Junio";
        this.meses[6] = "Julio";
        this.meses[7] = "Agosto";
        this.meses[8] = "Septiembre";
        this.meses[9] = "Octubre";
        this.meses[10] = "Noviembre";
        this.meses[11] = "Diciembre";
        
        for (int i = 0; i < meses.length; i++) {
            if (i < 11) {
                this.modelo.addRow(new Object[]{meses[i], "$" + this.lista.get(i).salariomenos + "  ", "$" + this.lista.get(i).renta + "  ",
                    "$" + this.lista.get(i).afp, "$" + this.lista.get(i).isss + "  ", "$" + this.lista.get(i).salario + "  "});
                total_remuneracion = total_remuneracion + round((this.lista.get(i).salariomenos), 2);
                renta = round((renta + this.lista.get(i).renta), 2);
                afp = round((afp + this.lista.get(i).afp), 2);
                isss = round((isss + this.lista.get(i).isss), 2);
                salariototal = round((salariototal + this.lista.get(i).salario), 2);
            } else {
                double mas_aguinaldo = this.lista.get(i).salario + this.aguinaldo;
                this.modelo.addRow(new Object[]{meses[i], "$" + this.lista.get(i).salariomenos + "  ", "$" + this.lista.get(i).renta + "  ",
                    "$" + this.lista.get(i).afp, "$" + this.lista.get(i).isss + "  ", "$" + mas_aguinaldo + "  "});
                total_remuneracion = round((total_remuneracion + this.lista.get(i).salariomenos), 2);
                renta = round((renta + this.lista.get(i).renta), 2);
                afp = round((afp + this.lista.get(i).afp), 2);
                isss = round((isss + this.lista.get(i).isss), 2);
                salariototal = round((salariototal + mas_aguinaldo), 2);
            }

        }
        this.modelo.addRow(new Object[]{"TOTAL", "$" + total_remuneracion + "  ", "$" + renta + "  ", "$" + afp + "  ", "$" + isss + "  ",
            "$" + salariototal + "  "});
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
       centerRender.setHorizontalAlignment(JLabel.CENTER);
       
       ((DefaultTableCellRenderer) this.jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
       
        for (int i = 0; i < this.jTable1.getColumnCount(); i++) {
            this.jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRender);
            
        }
        this.jTable1.setFont(new Font("Serif", Font.PLAIN, 14));
        
        
    }
    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    private tabla() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel1.setText("Renta Anual");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mes", "Remuneraciones Agravadas", "Retención Menusla", "AFP", "Isss", "Ingresos Devengados"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(120);
        }

        jButton1.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButton1.setText("Imprimir Constancia");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel4.setText("  Aguinaldo Gravado  $");

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Aguinaldo (NO) Gravado  $");

        jButton2.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButton2.setText("Nuevo Calculo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jButton2)
                        .addGap(91, 91, 91)
                        .addComponent(jButton1)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3))
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            
            /*InputStream file = getClass().getResourceAsStream("Blank_A4.jasper");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);*/
            //El archivo Blank_A4_2 solo es un hola no tiene parametros
            
            
            String path = "src/report/Blank_A4.jasper";
            //JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/report/Blank_A4.jasper"));
            
            //(getClass().getClassLoader().getResource("Blank_A4.jasper")).toString()
            
            //JasperPrint jprint = JasperFillManager.fillReport(reporte, new HashMap<>(), new JREmptyDataSource());
            //Fin Original solo valido para el Blank_A4_2
            
            
            
            Map parametro = new HashMap();
            parametro.put("pnombre", nombre);
            parametro.put("pnit",nit);
            parametro.put("pfechainicial","01/01/2020");
            parametro.put("pfechafinal","31/12/2020");
            parametro.put("psalariototalaguinaldo",(this.salariototal-this.aguinaldo_renta));
            parametro.put("paguinaldo_renta",this.aguinaldo_renta);
            parametro.put("pafp",this.afp);
            parametro.put("pisss",this.isss);
            parametro.put("ptotal_remuneracion",this.total_remuneracion);
            parametro.put("aguinaldoaguinaldorenta",(this.aguinaldo-this.aguinaldo_renta));
            parametro.put("prenta",this.renta);
            //JasperPrint jprint = JasperFillManager.fillReport(jasperReport, parametro, new JREmptyDataSource());
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, new JREmptyDataSource());
            JasperViewer view = new JasperViewer(jprint, false);
            
            
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            
            /*InputStream in = new FileInputStream(new File("C:\\Users\\rober\\OneDrive\\Documentos\\NetBeansProjects\\Renta\\src\\report\\newReport.jrxml"));
            JasperDesign jd = JRXmlLoader.load(in);
            String hola = "holaaaaaaaaaa";*/
        } catch (JRException ex) {
            Logger.getLogger(tabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        try {
            input input = new input();
            input.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(tabla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
