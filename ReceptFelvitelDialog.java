/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kamra;

import static Kamra.KamraFoablak.conn;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

/**
 *
 * @author Hoffmann József
 */
public class ReceptFelvitelDialog extends javax.swing.JDialog {

    private boolean ok;

    public boolean isOk() {
        return ok;
    }
    private DefaultComboBoxModel<Alapanyag> alapanyagComboBoxModel = new DefaultComboBoxModel<>();
    private DefaultListModel<Hozzavalo> hozzavaloListModel = new DefaultListModel<>();
    private Comparator<Alapanyag> comp;
    List<Alapanyag> aaLista;
    List<Hozzavalo> hozzavaloLista = new ArrayList<>();
    Etel ujRecept;
    private Optional<Etel> optUjEtel;
    private int kijelolt;

    public Optional<Etel> getOptUjEtel() {
        return optUjEtel;
    }

    public Etel getUjRecept() {
        return ujRecept;
    }

    /**
     * Creates new form receptFelvitelDialog
     */
    public ReceptFelvitelDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            KamraRepositoryJDBCimpl kr = new KamraRepositoryJDBCimpl(conn);
            aaLista = new ArrayList<>(kr.listAllAlapanyag());
            comp = new RendezComparator();
            Collections.sort(aaLista, comp);

        } catch (KamraDAOException ex) {
            Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
        }

        jComboBoxAlapanyagok.setModel(alapanyagComboBoxModel);
        for (Alapanyag a : aaLista) {
            alapanyagComboBoxModel.addElement(a);
        }

        jListRecept.setModel(hozzavaloListModel);

        setLocationRelativeTo(null);
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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListRecept = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        tfEtel = new javax.swing.JTextField();
        tfHozzavaloMennyiseg = new javax.swing.JTextField();
        jbPluszHozzavalo = new javax.swing.JButton();
        jButtonRogzites = new javax.swing.JButton();
        lbReceptEteNeve = new javax.swing.JLabel();
        jBMegse = new javax.swing.JButton();
        jComboBoxAlapanyagok = new javax.swing.JComboBox<>();
        jComboBoxME = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTxAr = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jbHozzavaloTorol = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Étel neve");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Hozzávaló kiválasztása");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Hozzávaló mennyisége");

        jListRecept.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListReceptValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListRecept);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Recept készítés");

        tfEtel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfEtelFocusLost(evt);
            }
        });
        tfEtel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfEtelKeyTyped(evt);
            }
        });

        jbPluszHozzavalo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbPluszHozzavalo.setText("Hozzávaló hozzáadása");
        jbPluszHozzavalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPluszHozzavaloActionPerformed(evt);
            }
        });

        jButtonRogzites.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jButtonRogzites.setText("Recept rögzítése");
        jButtonRogzites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRogzitesActionPerformed(evt);
            }
        });

        lbReceptEteNeve.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbReceptEteNeve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbReceptEteNeve.setText("Étel");

        jBMegse.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jBMegse.setText("Mégse");
        jBMegse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMegseActionPerformed(evt);
            }
        });

        jComboBoxAlapanyagok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAlapanyagokActionPerformed(evt);
            }
        });

        jComboBoxME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxME.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "g", "dkg", "kg", "ml", "cl", "dl", "l", "db" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Eladási ár");

        jbHozzavaloTorol.setText("Kiválasztott hozzávaló törlése");
        jbHozzavaloTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHozzavaloTorolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbReceptEteNeve, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSeparator1)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(29, 29, 29)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(tfHozzavaloMennyiseg, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jComboBoxME, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(tfEtel, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                                .addComponent(jComboBoxAlapanyagok, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTxAr, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                        .addComponent(jButtonRogzites)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBMegse, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)))
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbHozzavaloTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbPluszHozzavalo))
                                .addGap(51, 51, 51)))
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(25, 25, 25)
                .addComponent(lbReceptEteNeve, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfEtel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxAr, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxAlapanyagok, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfHozzavaloMennyiseg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxME, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbPluszHozzavalo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbHozzavaloTorol)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonRogzites, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBMegse, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfEtelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEtelKeyTyped


    }//GEN-LAST:event_tfEtelKeyTyped

    private void tfEtelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEtelFocusLost

    }//GEN-LAST:event_tfEtelFocusLost

    private void jComboBoxAlapanyagokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAlapanyagokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxAlapanyagokActionPerformed

    private void jbPluszHozzavaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPluszHozzavaloActionPerformed

        int select = jComboBoxAlapanyagok.getSelectedIndex();
        int id = jComboBoxAlapanyagok.getItemAt(select).getId();
        String nev = jComboBoxAlapanyagok.getItemAt(select).getNev();
        try {
            double mennyiseg = Double.valueOf(tfHozzavaloMennyiseg.getText());
            int meSelect = jComboBoxME.getSelectedIndex();
            String me = jComboBoxME.getItemAt(meSelect);

            Hozzavalo hozzavalo = new Hozzavalo(id, nev, mennyiseg, me);
            hozzavaloListModel.addElement(hozzavalo);
            // hozzavaloLista.add(hozzavalo);
            lbReceptEteNeve.setText(tfEtel.getText());

            tfEtel.setEditable(false);
            tfEtel.setBackground(Color.LIGHT_GRAY);
            jTxAr.setEditable(false);
            jTxAr.setBackground(Color.LIGHT_GRAY);
            tfHozzavaloMennyiseg.setText("");
        } catch (NumberFormatException ex) {
            tfHozzavaloMennyiseg.setText("Számot kérek!");
        }

    }//GEN-LAST:event_jbPluszHozzavaloActionPerformed

    private void jBMegseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMegseActionPerformed
        ok = false;
        setVisible(false);
    }//GEN-LAST:event_jBMegseActionPerformed

    private void jButtonRogzitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRogzitesActionPerformed
        ok = true;
        for (int i = 0; i < hozzavaloListModel.getSize(); i++) {
            hozzavaloLista.add(hozzavaloListModel.get(i));
        }
        boolean kitoltott = true;
        try {
            int ar = Integer.valueOf(jTxAr.getText());
            ujRecept = new Etel(tfEtel.getText(), ar, hozzavaloLista);
            optUjEtel = Optional.of(ujRecept);
        } catch (NumberFormatException nfe) {
            jTxAr.setText("Számot kérek!");
            kitoltott = false;
        }
        if (kitoltott) {
            setVisible(false);
        }
    }//GEN-LAST:event_jButtonRogzitesActionPerformed

    private void jbHozzavaloTorolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHozzavaloTorolActionPerformed
        System.out.println("kijelölt=" + kijelolt);
        hozzavaloListModel.remove(kijelolt);
    }//GEN-LAST:event_jbHozzavaloTorolActionPerformed

    private void jListReceptValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListReceptValueChanged
        if (!evt.getValueIsAdjusting()) {
            kijelolt = jListRecept.getSelectedIndex();

        }
    }//GEN-LAST:event_jListReceptValueChanged

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
            java.util.logging.Logger.getLogger(ReceptFelvitelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptFelvitelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptFelvitelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptFelvitelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReceptFelvitelDialog dialog = new ReceptFelvitelDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBMegse;
    private javax.swing.JButton jButtonRogzites;
    private javax.swing.JComboBox<Alapanyag> jComboBoxAlapanyagok;
    private javax.swing.JComboBox<String> jComboBoxME;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<Hozzavalo> jListRecept;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTxAr;
    private javax.swing.JButton jbHozzavaloTorol;
    private javax.swing.JButton jbPluszHozzavalo;
    private javax.swing.JLabel lbReceptEteNeve;
    private javax.swing.JTextField tfEtel;
    private javax.swing.JTextField tfHozzavaloMennyiseg;
    // End of variables declaration//GEN-END:variables
}
