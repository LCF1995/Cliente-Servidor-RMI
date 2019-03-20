/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import server.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author layse
 */
public class Ordena_DAO {
    
    Banco cc = new Banco();
    Connection cn = cc.conexion();

    public void add(String sequencia){
        
        try {
            PreparedStatement pst = cn.prepareStatement("insert into ordena (numeros_ordenados) value (?)");
            pst.setString(1, sequencia);
            
            pst.executeUpdate();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar numeros: " + e);
        }

    }
    
    
}
