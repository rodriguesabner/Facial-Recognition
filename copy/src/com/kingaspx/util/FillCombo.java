package com.kingaspx.util;

import java.sql.SQLException;
import javax.swing.JComboBox;

public class FillCombo {

    ConectaBanco conecta = new ConectaBanco();

    public void preencherCombo(String SQL, JComboBox combo, String coluna) {
        conecta.conexao();
        conecta.executaSQL(SQL);
        try {
            combo.removeAllItems();
            conecta.rs.first();
            do {
                new CustomCombo(combo).customCombo(combo, conecta.rs.getString(coluna));
//                combo.addItem(conecta.rs.getString(coluna));
                combo.setSelectedItem(null);
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Erro ao receber dados");
            System.out.println(ex);
        }
        conecta.desconecta();
    }

}
