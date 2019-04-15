package Kamra;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javax.swing.JOptionPane;

/**
 *
 * @author Hoffmann József
 */
public class KamraFoablak extends javax.swing.JFrame {

    public static Connection conn;
    public static String kapcsolatTxt = "";
    private String kivEtel;
    private DefaultListModel<Alapanyag> alapanyagListModel = new DefaultListModel<>();
    private Comparator<Alapanyag> comp;
    private Optional<Alapanyag> SelOptAlapanyag;
    private int selIndex = 0;
    private boolean kivalasztva = false;
    private DefaultListModel<CsakEtel> csakEtelListModel = new DefaultListModel<>();
    private DefaultListModel<EtelHozzavalok> etelHozzavalokListModel = new DefaultListModel<>();
    private Optional<CsakEtel> selOptCsakEtel;
    private Optional<EtelHozzavalok> selOptEtelHozzavalok;
    private DefaultListModel<Beszerzes> beszerzesListModel = new DefaultListModel<>();
    private Beszerzes beszerzesKivalasztott;
    private DefaultComboBoxModel<EtelIdNev> etelComboBoxModel = new DefaultComboBoxModel<>();

    /**
     * Creates new form NewJFrame
     */
    public KamraFoablak() throws KamraDAOException {
        this.setResizable(false);
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Kamra 1.0 - " + kapcsolatTxt);

        jListAlapanyag.setModel(alapanyagListModel);
        jListEtelek.setModel(csakEtelListModel);
        jListEtelHozzavalok.setModel(etelHozzavalokListModel);
        jListBeszerzes.setModel(beszerzesListModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxEtelElad = new javax.swing.JComboBox<>();
        lbKijeloltEtel = new javax.swing.JLabel();
        tfEtelAdag = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbEtelInformacio = new javax.swing.JLabel();
        btEtelRogzit = new javax.swing.JButton();
        lbKapcsolat = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListBeszerzes = new javax.swing.JList<>();
        jButtonBeszerzesHozzaad = new javax.swing.JButton();
        jButtonBeszerzesRogzites = new javax.swing.JButton();
        jLabelDatum = new javax.swing.JLabel();
        jButtonBszerzesTetelTorles = new javax.swing.JButton();
        jButtonTorles = new javax.swing.JButton();
        jLabeAtvezetendo = new javax.swing.JLabel();
        jButtonAtvezetes = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbHozzaadas = new javax.swing.JButton();
        jbModositas = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListAlapanyag = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListEtelHozzavalok = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListEtelek = new javax.swing.JList<>();
        jbEtelHozzaadas = new javax.swing.JButton();
        jbEtelModositas = new javax.swing.JButton();
        jBHozzavaloModosit = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        eladasMenuItem = new javax.swing.JMenuItem();
        beszerzesMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        kilepesMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        alapanyagMenuItem = new javax.swing.JMenuItem();
        receptMenuItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(getTitle());
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(800, 400));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("E l a d á s");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jLabel2FocusGained(evt);
            }
        });

        comboBoxEtelElad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboBoxEtelElad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboBoxEtelEladFocusGained(evt);
            }
        });
        comboBoxEtelElad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEtelEladActionPerformed(evt);
            }
        });

        lbKijeloltEtel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbKijeloltEtel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbKijeloltEtel.setText("Nincs kiválasztva étel");

        tfEtelAdag.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("adag");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbEtelInformacio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbEtelInformacio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEtelInformacio.setText("Információ megjelenítése");
        lbEtelInformacio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btEtelRogzit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btEtelRogzit.setText("Tétel rögzítése");

        lbKapcsolat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEtelInformacio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(comboBoxEtelElad, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbKijeloltEtel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfEtelAdag, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btEtelRogzit, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(247, 247, 247))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbKapcsolat, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(296, 296, 296))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfEtelAdag, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbKijeloltEtel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboBoxEtelElad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addComponent(lbEtelInformacio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btEtelRogzit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(lbKapcsolat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, "eladasCard");

        jPanel4.setName(""); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Alapanyag beszerzés");

        jListBeszerzes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jListBeszerzes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListBeszerzesValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(jListBeszerzes);

        jButtonBeszerzesHozzaad.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonBeszerzesHozzaad.setText("Tételek hozzáadása");
        jButtonBeszerzesHozzaad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBeszerzesHozzaadActionPerformed(evt);
            }
        });

        jButtonBeszerzesRogzites.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButtonBeszerzesRogzites.setText("Beszerzés rögzítése");
        jButtonBeszerzesRogzites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBeszerzesRogzitesActionPerformed(evt);
            }
        });

        jLabelDatum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelDatum.setText("Beszerzés dátuma");

        jButtonBszerzesTetelTorles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonBszerzesTetelTorles.setText("Kiválasztott tétel törlése");
        jButtonBszerzesTetelTorles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBszerzesTetelTorlesActionPerformed(evt);
            }
        });

        jButtonTorles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonTorles.setText("Az összes tétel törlése");
        jButtonTorles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTorlesActionPerformed(evt);
            }
        });

        jLabeAtvezetendo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabeAtvezetendo.setForeground(new java.awt.Color(255, 0, 0));

        jButtonAtvezetes.setBackground(new java.awt.Color(153, 102, 0));
        jButtonAtvezetes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonAtvezetes.setText("Átvezetés a készletbe");
        jButtonAtvezetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtvezetesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelDatum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
                .addGap(130, 130, 130)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonBeszerzesHozzaad, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(jButtonBszerzesTetelTorles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonTorles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBeszerzesRogzites, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(jLabeAtvezetendo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAtvezetes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonBeszerzesHozzaad, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBszerzesTetelTorles, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonTorles, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBeszerzesRogzites, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabeAtvezetendo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAtvezetes, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, "beszerzesCard");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alapanyagok hozzáadása");

        jbHozzaadas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbHozzaadas.setText("Hozzáadás");
        jbHozzaadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbHozzaadasActionPerformed(evt);
            }
        });

        jbModositas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbModositas.setText("Módosítás");
        jbModositas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModositasActionPerformed(evt);
            }
        });

        jListAlapanyag.setBackground(new java.awt.Color(204, 255, 255));
        jListAlapanyag.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jListAlapanyag.setForeground(new java.awt.Color(0, 51, 255));
        jListAlapanyag.setToolTipText("");
        jListAlapanyag.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jListAlapanyag.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jListAlapanyagComponentShown(evt);
            }
        });
        jListAlapanyag.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListAlapanyagValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jListAlapanyag);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbHozzaadas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbModositas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(160, 160, 160))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jbHozzaadas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jbModositas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, "alapanyagCard");

        jListEtelHozzavalok.setBackground(new java.awt.Color(0, 204, 204));
        jListEtelHozzavalok.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jListEtelHozzavalok.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListEtelHozzavalokValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListEtelHozzavalok);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Étel hozzáadása");

        jListEtelek.setBackground(new java.awt.Color(0, 204, 204));
        jListEtelek.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jListEtelek.setForeground(new java.awt.Color(153, 0, 0));
        jListEtelek.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListEtelekValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jListEtelek);

        jbEtelHozzaadas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbEtelHozzaadas.setText("Étel hozzáadása");
        jbEtelHozzaadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEtelHozzaadasActionPerformed(evt);
            }
        });

        jbEtelModositas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbEtelModositas.setText("Étel módosítása");
        jbEtelModositas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEtelModositasActionPerformed(evt);
            }
        });

        jBHozzavaloModosit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBHozzavaloModosit.setText("Hozzávaló módosítása");
        jBHozzavaloModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBHozzavaloModositActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbEtelModositas, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbEtelHozzaadas, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jBHozzavaloModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbEtelHozzaadas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEtelModositas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBHozzavaloModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        getContentPane().add(jPanel3, "receptCard");

        jMenu2.setText("Rögzítés");

        eladasMenuItem.setText("Eladás");
        eladasMenuItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                eladasMenuItemFocusGained(evt);
            }
        });
        eladasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eladasMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(eladasMenuItem);

        beszerzesMenuItem.setText("Beszerzés");
        beszerzesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beszerzesMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(beszerzesMenuItem);
        jMenu2.add(jSeparator2);

        kilepesMenuItem.setText("Kilépés");
        kilepesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kilepesMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(kilepesMenuItem);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Adminisztráció");

        alapanyagMenuItem.setText("Alapanyag");
        alapanyagMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alapanyagMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(alapanyagMenuItem);

        receptMenuItem.setText("Recept");
        receptMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receptMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(receptMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Lekérdezések");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Rendezvény kalkulátor");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eladasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eladasMenuItemActionPerformed
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "eladasCard");
        try {
            KamraRepositoryJDBCimpl kr = new KamraRepositoryJDBCimpl(conn);
            List<EtelIdNev> csakEtelLista = new ArrayList<>(kr.listSQLEtelIdNev());
            etelComboBoxModel.removeAllElements();
            for (EtelIdNev cse : csakEtelLista) {
                etelComboBoxModel.addElement((EtelIdNev) cse);
            }
            comboBoxEtelElad.setModel(etelComboBoxModel);
        } catch (KamraDAOException | SQLException ex) {
            Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_eladasMenuItemActionPerformed

    private void alapanyagMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alapanyagMenuItemActionPerformed
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "alapanyagCard");
        lbKapcsolat.setText(kapcsolatTxt);
        try {
            KamraRepositoryJDBCimpl kr = new KamraRepositoryJDBCimpl(conn);
            List<Alapanyag> aaLista = new ArrayList<>(kr.listAllAlapanyag());
            comp = new RendezComparator();
            Collections.sort(aaLista, comp);
            alapanyagListModel.removeAllElements();
            for (Alapanyag a : aaLista) {
                alapanyagListModel.addElement(a);
            }

        } catch (KamraDAOException ex) {
            Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_alapanyagMenuItemActionPerformed

    private void kilepesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kilepesMenuItemActionPerformed
        if (conn != null) {
            Kapcsolodas.zar();
        }
        System.exit(0);
    }//GEN-LAST:event_kilepesMenuItemActionPerformed

    private void comboBoxEtelEladFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboBoxEtelEladFocusGained

    }//GEN-LAST:event_comboBoxEtelEladFocusGained

    private void comboBoxEtelEladActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEtelEladActionPerformed
        kivEtel = comboBoxEtelElad.getSelectedItem().toString();
        lbKijeloltEtel.setText(kivEtel);
    }//GEN-LAST:event_comboBoxEtelEladActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        lbEtelInformacio.setText(kivEtel + " " + tfEtelAdag.getText() + " adag");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbHozzaadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbHozzaadasActionPerformed
        AlapanyagFelvitelDialog dialog = new AlapanyagFelvitelDialog(this, true);
        dialog.setTitle("Új alapanyag felvitele");
        dialog.setVisible(true);
        if (dialog.isOk()) {
            try {
                KamraRepositoryJDBCimpl alapanyagfelvitel = new KamraRepositoryJDBCimpl(conn);
                alapanyagfelvitel.addSQLAlapanyag(dialog.getOptAlapanyag());
                List<Alapanyag> aaLista = new ArrayList<>(alapanyagfelvitel.listAllAlapanyag());
                comp = new RendezComparator();
                Collections.sort(aaLista, comp);
                alapanyagListModel.removeAllElements();
                for (Alapanyag a : aaLista) {
                    alapanyagListModel.addElement(a);
                }
            } catch (SQLException | KamraDAOException ex) {
                Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //jLabel1.setText(selIndex + "");

    }//GEN-LAST:event_jbHozzaadasActionPerformed

    private void jbModositasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModositasActionPerformed
        if (kivalasztva) {
            AlapanyagFelvitelDialog dialog = new AlapanyagFelvitelDialog(this, true, SelOptAlapanyag);
            dialog.setTitle("Létező alapanyag módosítása");
            dialog.setVisible(true);

            if (dialog.isOk()) {
                try {
                    KamraRepositoryJDBCimpl alapanyagfelvitel = new KamraRepositoryJDBCimpl(conn);
                    alapanyagfelvitel.updSQLAlapanyag(dialog.getOptAlapanyag());
                    List<Alapanyag> aaLista = new ArrayList<>(alapanyagfelvitel.listAllAlapanyag());
                    comp = new RendezComparator();
                    Collections.sort(aaLista, comp);
                    alapanyagListModel.removeAllElements();
                    for (Alapanyag a : aaLista) {
                        alapanyagListModel.addElement(a);
                    }
                } catch (SQLException | KamraDAOException ex) {
                    Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Válassz egy alapanyagot!", "Nincs kiválasztott alapanyag!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbModositasActionPerformed

    private void jListAlapanyagValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListAlapanyagValueChanged
        if (!evt.getValueIsAdjusting()) {
            kivalasztva = true;
            Alapanyag kivalasztottAlapanyag = jListAlapanyag.getSelectedValue();
            if (kivalasztottAlapanyag != null) {
                //selIndex = jListAlapanyag.getSelectedIndex();            
                SelOptAlapanyag = Optional.of(kivalasztottAlapanyag);
            } else {
                kivalasztva = false;
                SelOptAlapanyag = null;
            }
        }
    }//GEN-LAST:event_jListAlapanyagValueChanged

    private void jListAlapanyagComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jListAlapanyagComponentShown
        try {
            KamraRepositoryJDBCimpl kr = new KamraRepositoryJDBCimpl(conn);
            List<Alapanyag> aaLista = new ArrayList<>(kr.listAllAlapanyag());
            comp = new RendezComparator();
            Collections.sort(aaLista, comp);
            alapanyagListModel.removeAllElements();
            for (Alapanyag a : aaLista) {
                alapanyagListModel.addElement(a);
            }

        } catch (KamraDAOException | SQLException ex) {
            Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListAlapanyagComponentShown

    private void receptMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receptMenuItemActionPerformed
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "receptCard");
        try {
            KamraRepositoryJDBCimpl kr = new KamraRepositoryJDBCimpl(conn);
            List<CsakEtel> csakEtelLista = new ArrayList<>(kr.listSQLCsakEtel());
            csakEtelListModel.removeAllElements();
            for (CsakEtel cse : csakEtelLista) {
                csakEtelListModel.addElement(cse);
            }
        } catch (KamraDAOException | SQLException ex) {
            Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_receptMenuItemActionPerformed

    private void jbEtelHozzaadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEtelHozzaadasActionPerformed
        ReceptFelvitelDialog receptDialog = new ReceptFelvitelDialog(this, true);
        receptDialog.setTitle("Új étel felvitele");
        receptDialog.setVisible(true);
        if (receptDialog.isOk()) {
            try {
                KamraRepositoryJDBCimpl receptfelvitel = new KamraRepositoryJDBCimpl(conn);
                receptfelvitel.addSQLRecept(receptDialog.getUjRecept());

                List<CsakEtel> csakEtelLista = new ArrayList<>(receptfelvitel.listSQLCsakEtel());
                csakEtelListModel.removeAllElements();
                for (CsakEtel cse : csakEtelLista) {
                    csakEtelListModel.addElement(cse);
                }

            } catch (KamraDAOException ex) {
                Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jbEtelHozzaadasActionPerformed

    private void jListEtelekValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListEtelekValueChanged
        if (!evt.getValueIsAdjusting()) {
            kivalasztva = true;
            jListEtelHozzavalok.removeAll();
            etelHozzavalokListModel.removeAllElements();
            CsakEtel kivalasztottEtel = jListEtelek.getSelectedValue();
            if (kivalasztottEtel != null) {
                selOptCsakEtel = Optional.of(jListEtelek.getSelectedValue());
            } else {
                kivalasztva = false;
                selOptCsakEtel = Optional.empty();
            }

            if (kivalasztva) {
                try {
                    int etel_id = jListEtelek.getSelectedValue().getId();
                    KamraRepositoryJDBCimpl kr = new KamraRepositoryJDBCimpl(conn);
                    List<EtelHozzavalok> etelHozzavalokLista = new ArrayList<>(kr.listSQLEtelHozzavalok(etel_id));
                    for (EtelHozzavalok eh : etelHozzavalokLista) {
                        etelHozzavalokListModel.addElement(eh);
                    }
                } catch (KamraDAOException | SQLException ex) {
                    System.out.println("Itt valami gáz  van! " + ex.getMessage());
                    Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            kivalasztva = false;
            selOptCsakEtel = Optional.empty();
        }
    }//GEN-LAST:event_jListEtelekValueChanged

    private void jbEtelModositasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEtelModositasActionPerformed
        if (kivalasztva) {
            EtelModositDialog dialog = new EtelModositDialog(this, true, selOptCsakEtel);
            dialog.setTitle("Étel módosítása");
            dialog.setVisible(true);
            if (dialog.isOk()) {
                try {
                    KamraRepositoryJDBCimpl rp = new KamraRepositoryJDBCimpl(conn);
                    rp.updSQLEtel(dialog.getModOptCsakEtel());

                    List<CsakEtel> csakEtelLista = new ArrayList<>(rp.listSQLCsakEtel());
                    csakEtelListModel.removeAllElements();
                    for (CsakEtel cse : csakEtelLista) {
                        csakEtelListModel.addElement(cse);
                    }
                    kivalasztva = false;
                } catch (KamraDAOException | SQLException ex) {
                    Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Válassz egy ételt!", "Nincs kiválasztott étel!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbEtelModositasActionPerformed

    private void jListEtelHozzavalokValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListEtelHozzavalokValueChanged
        if (!evt.getValueIsAdjusting()) {
            kivalasztva = true;
            EtelHozzavalok kivalasztottEtelHozzavalok = jListEtelHozzavalok.getSelectedValue();
            if (kivalasztottEtelHozzavalok != null) {
                //selIndex = jListAlapanyag.getSelectedIndex();            
                selOptEtelHozzavalok = Optional.of(kivalasztottEtelHozzavalok);
            } else {
                kivalasztva = false;
                selOptEtelHozzavalok = Optional.empty();
            }
        }
    }//GEN-LAST:event_jListEtelHozzavalokValueChanged

    private void jBHozzavaloModositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBHozzavaloModositActionPerformed
        HozzavalokModositDialog hvMmodDialog = new HozzavalokModositDialog(this, true);
        hvMmodDialog.setTitle("Hozzávaló módosítása / törlése");
        hvMmodDialog.setVisible(true);
    }//GEN-LAST:event_jBHozzavaloModositActionPerformed

    private void beszerzesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beszerzesMenuItemActionPerformed
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "beszerzesCard");
        try {
            KamraRepositoryJDBCimpl rp = new KamraRepositoryJDBCimpl(conn);
            int atvezetendo = rp.countSQLBeszerzesAtvezetendo();
            if (atvezetendo > 0) {
                jLabeAtvezetendo.setText("Átvezetésre váró tételek: " + atvezetendo + " db");
            } else {
                jLabeAtvezetendo.setText("");
            }
        } catch (KamraDAOException | SQLException ex) {
            Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_beszerzesMenuItemActionPerformed

    private void jButtonBeszerzesHozzaadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBeszerzesHozzaadActionPerformed
        BeszerzesDialog dialog = new BeszerzesDialog(this, true);
        dialog.setTitle("Beszerzett alapanyagok rögzítése");
        dialog.setVisible(true);

        if (dialog.isOk()) {
            beszerzesListModel.addElement(dialog.getOptBeszerzes().get());
            jLabelDatum.setText("Beszerzés dátuma: " + dialog.getOptBeszerzes().get().getDatumString());
        }
    }//GEN-LAST:event_jButtonBeszerzesHozzaadActionPerformed

    private void jButtonTorlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTorlesActionPerformed
        beszerzesListModel.removeAllElements();
    }//GEN-LAST:event_jButtonTorlesActionPerformed

    private void jListBeszerzesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListBeszerzesValueChanged
        if (!evt.getValueIsAdjusting()) {
            beszerzesKivalasztott = jListBeszerzes.getSelectedValue();
        }
    }//GEN-LAST:event_jListBeszerzesValueChanged

    private void jButtonBszerzesTetelTorlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBszerzesTetelTorlesActionPerformed
        beszerzesListModel.removeElement(beszerzesKivalasztott);
    }//GEN-LAST:event_jButtonBszerzesTetelTorlesActionPerformed

    private void jButtonBeszerzesRogzitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBeszerzesRogzitesActionPerformed
        if (!beszerzesListModel.isEmpty()) {
            MegerositDialog dialog = new MegerositDialog(this, true, "Rögzíthetem a beszerzést az adatbázisban?");
            dialog.setTitle("A rögzített beszerzés mentése");
            dialog.setVisible(true);
            if (dialog.isOk()) {
                try {
                    KamraRepositoryJDBCimpl rp = new KamraRepositoryJDBCimpl(conn);
                    //Optional ob = Optional.of(beszerzesListModel);
                    for (int i = 0; i < beszerzesListModel.size(); i++) {
                        Optional ob = Optional.of(beszerzesListModel.get(i));
                        rp.addSQLBeszerzes(ob);
                    }
                    JOptionPane.showMessageDialog(rootPane, "A beszerzett anyagok listája tárolva lett!", "Minden rendben!", JOptionPane.INFORMATION_MESSAGE);
                    beszerzesListModel.removeAllElements();
                    jLabelDatum.setText("Beszerzés dátuma");
                    try {
                        KamraRepositoryJDBCimpl atvez = new KamraRepositoryJDBCimpl(conn);
                        int atvezetendo = atvez.countSQLBeszerzesAtvezetendo();
                        if (atvezetendo > 0) {
                            jLabeAtvezetendo.setText("Átvezetésre váró tételek: " + atvezetendo + " db");
                        } else {
                            jLabeAtvezetendo.setText("");
                        }
                    } catch (KamraDAOException | SQLException ex) {
                        Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (KamraDAOException | SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Nem sikerült a mentés!", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Előbb rögzítsd a beszerzett alapanyagokat!", "Nincs mit menteni!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBeszerzesRogzitesActionPerformed

    private void jButtonAtvezetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtvezetesActionPerformed
        try {
            KamraRepositoryJDBCimpl rp = new KamraRepositoryJDBCimpl(conn);
            int atvezetendo = rp.countSQLBeszerzesAtvezetendo();
            if (atvezetendo == 0) {
                JOptionPane.showMessageDialog(rootPane, "Nincs mit átvezetni", "Nem történt átvezetés!", JOptionPane.ERROR_MESSAGE);
            } else {
                MegerositDialog dialog = new MegerositDialog(this, true, "Átvezethetem a beszerzést készletbe?");
                dialog.setTitle("Készlet növelés");
                dialog.setVisible(true);
                if (dialog.isOk()) {
                   Optional atvezetni = rp.listSQLBszerzesNincsAtvezetve();
                   rp.addSQLKeszlet(atvezetni);
                   rp.updSQLBszerzesAtvezetesKeszletOK(atvezetni);
                }
                JOptionPane.showMessageDialog(rootPane, "A beszerések készletbe írása megtörtént!", "Minden rendben!", JOptionPane.INFORMATION_MESSAGE);
                jLabeAtvezetendo.setText("");
            }
        } catch (KamraDAOException | SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Nem sikerült az átvezetés!", JOptionPane.ERROR_MESSAGE);                    
            Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAtvezetesActionPerformed

    private void eladasMenuItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_eladasMenuItemFocusGained
       
    }//GEN-LAST:event_eladasMenuItemFocusGained

    private void jLabel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jLabel2FocusGained
 
    }//GEN-LAST:event_jLabel2FocusGained

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
       CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "eladasCard");
        try {
            KamraRepositoryJDBCimpl kr = new KamraRepositoryJDBCimpl(conn);
            List<EtelIdNev> csakEtelLista = new ArrayList<>(kr.listSQLEtelIdNev());
            etelComboBoxModel.removeAllElements();
            for (EtelIdNev cse : csakEtelLista) {
                etelComboBoxModel.addElement((EtelIdNev) cse);
            }
            comboBoxEtelElad.setModel(etelComboBoxModel);
        } catch (KamraDAOException | SQLException ex) {
            Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jPanel1ComponentShown

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws KamraDAOException {
        new Kapcsolodas();
        
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
            java.util.logging.Logger.getLogger(KamraFoablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KamraFoablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KamraFoablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KamraFoablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new KamraFoablak().setVisible(true);
                } catch (KamraDAOException ex) {
                    Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        
    }
    
    public void etelToComboBox() {
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "alapanyagCard");
        lbKapcsolat.setText(kapcsolatTxt);
        try {
            KamraRepositoryJDBCimpl kr = new KamraRepositoryJDBCimpl(conn);
            List<Alapanyag> aaLista = new ArrayList<>(kr.listAllAlapanyag());
            comp = new RendezComparator();
            Collections.sort(aaLista, comp);
            alapanyagListModel.removeAllElements();
            for (Alapanyag a : aaLista) {
                alapanyagListModel.addElement(a);
            }

        } catch (KamraDAOException ex) {
            Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KamraFoablak.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem alapanyagMenuItem;
    private javax.swing.JMenuItem beszerzesMenuItem;
    private javax.swing.JButton btEtelRogzit;
    private javax.swing.JComboBox<EtelIdNev> comboBoxEtelElad;
    private javax.swing.JMenuItem eladasMenuItem;
    private javax.swing.JButton jBHozzavaloModosit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAtvezetes;
    private javax.swing.JButton jButtonBeszerzesHozzaad;
    private javax.swing.JButton jButtonBeszerzesRogzites;
    private javax.swing.JButton jButtonBszerzesTetelTorles;
    private javax.swing.JButton jButtonTorles;
    private javax.swing.JLabel jLabeAtvezetendo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelDatum;
    private javax.swing.JList<Alapanyag> jListAlapanyag;
    private javax.swing.JList<Beszerzes> jListBeszerzes;
    private javax.swing.JList<EtelHozzavalok> jListEtelHozzavalok;
    private javax.swing.JList<CsakEtel> jListEtelek;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JButton jbEtelHozzaadas;
    private javax.swing.JButton jbEtelModositas;
    private javax.swing.JButton jbHozzaadas;
    private javax.swing.JButton jbModositas;
    private javax.swing.JMenuItem kilepesMenuItem;
    private javax.swing.JLabel lbEtelInformacio;
    private javax.swing.JLabel lbKapcsolat;
    private javax.swing.JLabel lbKijeloltEtel;
    private javax.swing.JMenuItem receptMenuItem;
    private javax.swing.JTextField tfEtelAdag;
    // End of variables declaration//GEN-END:variables
}
