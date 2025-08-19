/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import static gestcolis.colismain.con;
import static gestcolis.colismain.st;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kamke
 */
class profil {

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
        }
    

