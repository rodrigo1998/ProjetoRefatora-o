package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import model.UsuarioTO;

public class UsuarioDAO extends UsuarioTO{

	
	  public void incluir(Connection conn) {
			String sqlInsert = "INSERT INTO USUARIO(Nome, Senha, Login, Nivel) VALUES (?, ?, ?, 1)";

			try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
	   		stm.setString(1, getNome());
				stm.setString(2, getSenha());
				stm.setString(3, getLogin());
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
	   
	   public void excluir(Connection conn) {
			String sqlDelete = "DELETE FROM USUARIO WHERE Login = ?";
			try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setString(1, getLogin());
				stm.execute();
				setNome(null);
				setSenha(null);
	         setLogin(null);
	         setId(0);
			} catch (Exception e) {
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	  
	 
	   public void atualizarUsuario(Connection conn) {
			String sqlUpdate = "UPDATE USUARIO SET Nome=?, Senha=? WHERE Login = ?";

			try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, getNome());
				stm.setString(3, getLogin());
	         stm.setString(2, getSenha());

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
	   
	   public UsuarioTO carregar(int id) {
			String sqlSelect = "SELECT * FROM USUARIO WHERE Login = ? and Nivel = 1";

			try (PreparedStatement stm = prepareStatement(sqlSelect);) {
				stm.setString(1, getLogin());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						setNome(rs.getString("Nome"));
						setSenha(rs.getString("Senha"));
	               setLogin(rs.getString("Login"));
	               setId(rs.getInt("ID"));
	               
	               
					} else {
						JOptionPane.showMessageDialog(null,"Usuario não encontrado");
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

	public int login(Connection conn, String login, String senha){
	   int n = 0;
	   try {
	            boolean loginn = false;
	            String query = "select * from USUARIO where Login='"+login+"' and Senha = '"+senha+"'";
	            java.sql.Statement statement = conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_SENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
	            ResultSet rs = statement.executeQuery(query);
	            if(rs.next()) {
	               loginn = true;
	            } 
	            else {
	               n = 0;
	            }
	            
	            if(loginn)
	            {
	               query = "select nivel from usuario where Login='"+login+"' and Senha = '"+senha+"'";
	               statement = conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_SENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
	               rs = statement.executeQuery(query);
	               //rs.beforeFirst();
	               if(rs.next()) {
	                  if(rs.getInt("nivel") == 1)
	                     n = 1; 
	                  else
	                     n = 2;
	                  
	               } 
	               
	            }
	         } 
	         catch (SQLException ex){
	            n = 0;    
	         }
	         return n;
	      }
	   
}
