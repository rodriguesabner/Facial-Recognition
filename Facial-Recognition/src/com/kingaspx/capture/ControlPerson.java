package com.kingaspx.capture;

import com.kingaspx.util.ConectaBanco;
import com.kingaspx.util.ModeloTabela;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

public class ControlPerson {

    ConectaBanco conecta = new ConectaBanco();

    public void inserir(ModelPerson mod) {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
        String currentTime = sdf.format(dt);
        System.out.println(currentTime);
        try {
            conecta.conexao();
            PreparedStatement pst = conecta.conn.prepareStatement("INSERT INTO person (id, first_name, last_name, phone_number, office, profile_facebook, profile_instagram, profile_linkedin, profile_github, register_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setInt(1, mod.getId());
            pst.setString(2, mod.getFirst_name());
            pst.setString(3, mod.getLast_name());
            pst.setString(4, mod.getDob());
            pst.setString(5, mod.getOffice());
            pst.setString(6, mod.getFacebook());
            pst.setString(7, mod.getInstagram());
            pst.setString(8, mod.getLinkedin());
            pst.setString(9, mod.getGithub());
            pst.setString(10, currentTime);
            pst.executeUpdate();
            System.out.println("Dados do(a): " + mod.getFirst_name() + " cadastrados");
            conecta.desconecta();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void deletar(int id) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("DELETE FROM person WHERE id= '" + id + "'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com Sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir apartamento. Tente Novamente!");
        } finally {
            conecta.desconecta();
        }
    }

    public void preencherTabela(String SQL, JTable tabela) {
        conecta.conexao();
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"ID", "Name", "Phone", "Function", "Facebook", "Instagram", "Linkedin", "Github"};
        conecta.executaSQL(SQL);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{
                    conecta.rs.getString("id"),
                    conecta.rs.getString("first_name") + " " + conecta.rs.getString("last_name"),
                    conecta.rs.getString("phone_number"),
                    conecta.rs.getString("office"),
                    conecta.rs.getString("profile_facebook"),
                    conecta.rs.getString("profile_instagram"),
                    conecta.rs.getString("profile_linkedin"),
                    conecta.rs.getString("profile_github")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane, "Lista de Cadastro Vazia!");
        } finally {
            conecta.desconecta();
        }

        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        tabela.setModel((TableModel) modelo);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void editar(ModelPerson mod, int id) {
        conecta.conexao();
        try {
            PreparedStatement pst = conecta.conn.prepareStatement("UPDATE apto SET apto= ? WHERE id=? ");
            pst.setString(1, mod.getFirst_name());
            pst.setInt(2, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Alterado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar apartamento. Tente Novamente!");
        } finally {
            conecta.desconecta();
        }
    }

}
