/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import java.sql.Connection;
import static gestcolis.colismain.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Statement;






/**
 * 
 * @author kamke
 */
public class colis {
    public static void enregistrerColis(String nomcolis, String type, String poids, 
            String nomexpediteur, String prenomexpediteur, String telephoneexpediteur,
            String Villeexpediteur,
            String fraisenvoi, String codeenvoi,String nomdestinataire, String prenomdestinataire, 
            String telephonedestinataire, String villedestinataire, String quartierdestinataire,String DateEnvoi){
         try {
            con=connectionbd.seconnecter(); st=con.createStatement();
            String sqlCheck = "SELECT COUNT(*) FROM colis WHERE id_colis = ?";
try (PreparedStatement pstCheck = con.prepareStatement(sqlCheck)) {
    pstCheck.setString(1, codeenvoi);
    ResultSet rs = pstCheck.executeQuery();
    if (rs.next() && rs.getInt(1) > 0) {
        JOptionPane.showMessageDialog(null, "L'ID colis '" + codeenvoi + "' existe déjà. Veuillez en générer un nouveau.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return; // Arrêter l'exécution si l'ID existe déjà
    }
}
            st.executeUpdate("INSERT INTO `colis`(`id_colis`, `type_colis`, `poids_colis`, `frais_envoi`,"
                    + "`nomexp`, `prenomexp`, `villeexp`, `telexp`,"
                    + " `nomdest`, `prenomdest`, `villedest`, `teledest`, `quartierdest`, `date`) "
                    + "VALUES ('"+codeenvoi+"','"+type+"','"+poids+"','"+fraisenvoi+"','"+nomexpediteur+"','"+prenomexpediteur+"',"
                            + "'"+Villeexpediteur+"','"+telephoneexpediteur+"','"+nomdestinataire+"','"+prenomdestinataire+"',"
                            + "'"+villedestinataire+"','"+telephonedestinataire+"','"+quartierdestinataire+"','"+DateEnvoi+"')");
            
            JOptionPane.showMessageDialog(null, "Colis enregistré avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
            
            con.close();
            st.close();
        } 
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(colis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
 public static void enregistrerRecepteur(String nomRecepteur, String prenomRecepteur, String typePiece,
                                        String numeroPiece, String numeroTel, String codeEnvoi, String dateReception) {
    try {
        Connection con = connectionbd.seconnecter(); 
        
        // Vérifier si le code d'envoi existe déjà
        String sqlCheck = "SELECT COUNT(*) FROM recepteur WHERE code_envoi = ?";
        try (PreparedStatement pstCheck = con.prepareStatement(sqlCheck)) {
            pstCheck.setString(1, codeEnvoi);
            ResultSet rs = pstCheck.executeQuery();
            
            if (rs.next() && rs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "Le code d'envoi '" + codeEnvoi + "' existe déjà dans la table des récepteurs.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return; // Arrêter l'exécution si le code existe déjà
            }
        }
        
        // Requête d'insertion avec des paramètres
        String sql = "INSERT INTO recepteur (code_envoi, nom_recepteur, prenom_recepteur, type_piece, numero_piece, date_reception, numero_telephone) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, codeEnvoi);
            pst.setString(2, nomRecepteur);
            pst.setString(3, prenomRecepteur);
            pst.setString(4, typePiece);
            pst.setString(5, numeroPiece);
            pst.setString(6, dateReception);
            pst.setString(7, numeroTel);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Récepteur enregistré avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
        }
        
        con.close();  // Fermer la connexion après utilisation
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(colis.class.getName()).log(Level.SEVERE, "Erreur lors de l'enregistrement du récepteur", ex);
    }
}
 
  public static void enregistreruser(String id,
            String gp,
            String pwd,String user
            )
    {
        try {
            con=connectionbd.seconnecter(); st=con.createStatement();
            st.executeUpdate("Insert into utilisateur(identifiant,password,utilisateur,groupe)"
                    + "values('"+id+"','"+pwd+"','"+user+"''"+gp+"')");
            con.close();
            st.close();
        } 
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(profil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Méthode pour calculer le chiffre d'affaires mensuel
private double calculerCA_Mensuel() {
    double caMensuel = 0;
    String sql = "SELECT SUM(frais_envoi) FROM colis WHERE MONTH(date_envoi) = MONTH(CURRENT_DATE()) AND YEAR(date_envoi) = YEAR(CURRENT_DATE())";
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdcolis", "root", "");
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        if (rs.next()) {
            caMensuel = rs.getDouble(1);
        }
    } catch (SQLException ex) {
        Logger.getLogger(colis.class.getName()).log(Level.SEVERE, "Erreur lors du calcul du CA mensuel", ex);
    }
    return caMensuel;
}
// Méthode pour calculer le chiffre d'affaires annuel
private double calculerCA_Annuel() {
    double caAnnuel = 0;
    String sql = "SELECT SUM(frais_envoi) FROM colis WHERE YEAR(date_envoi) = YEAR(CURRENT_DATE())";
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdcolis", "root", "");
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        if (rs.next()) {
            caAnnuel = rs.getDouble(1);
        }
    } catch (SQLException ex) {
        Logger.getLogger(colis.class.getName()).log(Level.SEVERE, "Erreur lors du calcul du CA annuel", ex);
    }
    return caAnnuel;
}

 




 
}































//    public static void enregistrerDesti( String nomdestinataire, String prenomdestinataire, 
//            String telephonedestinataire, String villedestinataire, String quartierdestinataire,String DateEnvoi,String CodeEnvoi)
//    {
//        try {
//            con=connectionbd.seconnecter(); st=con.createStatement();
//            st.executeUpdate("INSERT INTO `destinataire`(`nom_destinataire`, `prenom_destinataire`, `ville_destinataire`, `telephone_destinataire`, `quartier_destinataire`, `date_envoi`,`codeEnvoi`) "
//                    + "VALUES(('"+nomdestinataire+"','"+prenomdestinataire+"','"+telephonedestinataire+"','"+villedestinataire+"','"+quartierdestinataire+"','"+DateEnvoi+"','"+CodeEnvoi+"'))");
//            con.close();
//            st.close();
//        } 
//        catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(colis.class.getName()).log(Level.SEVERE, null, ex);
//        }
////    public static void enregistrer(String codeenvoi, String nomcolis, String type, String poids, String nomexpediteur, String prenomexpediteur, String telephoneexpediteur, String villeexpediteur, String nomdestinataire, String prenomdestinataire, String telephonedestinataire, String villedestinataire, String quartierdestinataire, String fraisenvoi, String dateEnvoi) {
////        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
////    }
//}