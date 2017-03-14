package dao;
import java.sql.*;
import javax.swing.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.AvaliadorTO;

public class AvaliadorDAO extends AvaliadorTO {

	
	 public AvaliadorTO incluir(Connection conn) {
			String sqlInsert = "INSERT INTO USUARIO(Nome, Senha, Login, Nivel, Avaliador_Area) VALUES (?, ?, ?, 2,?)";

			try (PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlInsert);) {
	   		stm.setString(1, getNome());
				stm.setString(2, getSenha());
				stm.setString(3, getLogin());
	         stm.setInt(4,getArea()); 
	         stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
			return null;
		}
	   
	     public void atualizarAvaliador(Connection conn) {
			String sqlUpdate = "UPDATE USUARIO SET Nome=?, Senha=?, Avaliador_Area=?  WHERE Login = ?";

			try (PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, getNome());
	         stm.setString(2, getSenha());
	         stm.setInt(3, getArea());
	         stm.setString(4, getLogin());

				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	    
	   public AvaliadorTO carregar(int id) {
			String sqlSelect = "SELECT * FROM USUARIO WHERE Login = ? and Nivel = 2";

			try (PreparedStatement stm = prepareStatement(sqlSelect);) {
				stm.setString(1, getLogin());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						setNome(rs.getString("Nome"));
						setSenha(rs.getString("Senha"));
	               setLogin(rs.getString("Login"));
	               setId(rs.getInt("ID"));
	               setArea(rs.getInt("Avaliador_Area"));
	               
	               
					} else {
						JOptionPane.showMessageDialog(null,"Conta não encontrada");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return null;
		}

	private PreparedStatement prepareStatement(String sqlSelect) {
		// TODO Auto-generated method stub
		return null;
	}

}
