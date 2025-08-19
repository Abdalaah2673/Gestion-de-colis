/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gestcolis;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import classe.connectionbd;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import classe.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import gestcolis.*;
import gestcolis.formutilisateur.Utilitaire;
import static java.awt.SystemColor.menu;
import java.sql.DriverManager;
import gestcolis.colismain;
import static gestcolis.colismain.con;
import static gestcolis.colismain.panebureau;
import static gestcolis.colismain.rs;
import static gestcolis.colismain.rse;
import static gestcolis.colismain.st;
import static gestcolis.colismain.ste;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;





/**
 *
 * @author kamke
 */
public class formconnexion extends javax.swing.JPanel {

    public static PreparedStatement ps, pse;
    public static ResultSet rs, rse;                   //permettent d'utiliser les crud
    public static  String ve="",vi="",vp="",vu="",vpw="";
     

    
    
    /**
     * Creates new form formconnexion
     */
    public formconnexion() {
        initComponents();
    }

    
    
          

// Méthode pour hacher un mot de passe avec SHA-256
private String hashPassword(String password) {
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Ajouter des zéros si nécessaire pour obtenir une longueur fixe
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException("Erreur de hachage du mot de passe", e);
    }
}


    

    private void verifierConnexion() throws ClassNotFoundException {
    String identifiant = txtidentifiant.getText().trim();
    String password = new String(txtpassword.getPassword());

    // Vérifier que les champs ne sont pas vides
    if (identifiant.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Veuillez entrer votre identifiant et votre mot de passe.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Requête SQL pour récupérer le profil et les permissions
    String sql = "SELECT p.groupe, p.chiffre_affaire, p.profil, p.expédition, p.réception, p.personnel, p.statistique " +
                 "FROM utilisateur u " +
                 "JOIN profil p ON u.groupe = p.groupe " +
                 "WHERE u.identifiant = ? AND u.password = ?";

    try (Connection con = classe.connectionbd.seconnecter();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, identifiant);
        ps.setString(2, hashPassword(password)); // Assurer que le mot de passe est haché

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
    // Récupération des permissions sous forme de 0 ou 1
    boolean chiffreAffaire = rs.getInt("chiffre_affaire") == 1;
    boolean profil = rs.getInt("profil") == 1;
    boolean expedition = rs.getInt("expédition") == 1;
    boolean reception = rs.getInt("réception") == 1;
    boolean personnel = rs.getInt("personnel") == 1;
    boolean statistique = rs.getInt("statistique") == 1;

    // Appliquer les permissions en activant/désactivant les menus
    colismain.chiffreAffaires.setEnabled(chiffreAffaire);
    colismain.expedition.setEnabled(expedition);
    colismain.reception.setEnabled(reception);
    colismain.personnel.setEnabled(personnel);
    colismain.statistiques.setEnabled(statistique);

    JOptionPane.showMessageDialog(this, "Connexion réussie !");
    
    // Supprimer le panel de connexion du panebureau
            panebureau.remove(this);
            panebureau.revalidate();
            panebureau.repaint();
            colismain.seconnecter.setVisible(false);
          
          
  
            
    
} else {
    JOptionPane.showMessageDialog(this, "Identifiant ou mot de passe incorrect.", "Erreur", JOptionPane.ERROR_MESSAGE);
}
        

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Erreur SQL : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
    
       
}

    private void appliquerPermissions(String groupeUtilisateur) throws ClassNotFoundException {
    String sql = "SELECT chiffre_affaire, profil, expédition, réception, personnel, statistique FROM profil WHERE groupe = ?";
    
    try (Connection con = classe.connectionbd.seconnecter();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, groupeUtilisateur); // groupe de l'utilisateur connecté
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            boolean chiffreAffaire = rs.getBoolean("chiffre_affaire");
            boolean profil = rs.getBoolean("profil");
            boolean expedition = rs.getBoolean("expédition");
            boolean reception = rs.getBoolean("réception");
            boolean personnel = rs.getBoolean("personnel");
            boolean statistique = rs.getBoolean("statistique");

            // Appliquer les permissions en activant/désactivant les menus
            activerMenus(chiffreAffaire, profil, expedition, reception, personnel, statistique);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erreur lors du chargement des permissions.", "Erreur", JOptionPane.ERROR_MESSAGE);
    }
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtidentifiant = new javax.swing.JTextField();
        btnvalider = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Identifiant");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");

        btnvalider.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnvalider.setText("Valider");
        btnvalider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvaliderActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Renseignez les champs ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 119, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(109, 109, 109))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtidentifiant, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(txtpassword)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(btnvalider, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtidentifiant, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addComponent(btnvalider)
                .addGap(120, 120, 120))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 363, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnvaliderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvaliderActionPerformed
    
       
       
        try {                                           
            
            
            
            try {
                verifierConnexion();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(formconnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                if (rs.next()) {
                    String gp = rs.getString("profil");
                    
                    ste = con.createStatement();
                    rse = ste.executeQuery("SELECT * FROM profil WHERE groupe='" + gp + "'");
                    
                    if (rse.next()) {
                        ve = rse.getString("chiffreAffaire");
                        vi = rse.getString("profil");
                        vp = rse.getString("expedition");
                        vu = rse.getString("reception");
                        vpw = rse.getString("statistique");
                    }
                    
                    // Fermeture des ressources
                    rse.close();
                    ste.close();
                }       } catch (SQLException ex) {
                    Logger.getLogger(formconnexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            try {
                // Fermeture après l'utilisation de rs et st
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(formconnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            st.close();
            con.close();
            
// Rafraîchir l'affichage du panneau
panebureau.removeAll();
panebureau.repaint();


// Vérification groupée pour activer/désactiver "personnel"




        } catch (SQLException ex) {
            Logger.getLogger(formconnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnvaliderActionPerformed

    
    
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnvalider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtidentifiant;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables

    void moveToFront() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  

    private void activerMenus(boolean chiffreAffaire, boolean profil, boolean expedition, boolean reception, boolean personnel, boolean statistique) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
