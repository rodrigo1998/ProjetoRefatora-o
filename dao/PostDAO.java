package dao;
import java.sql.*;
import java.util.ArrayList;

import model.PostTO;

public class PostDAO extends PostTO{
	public PostTO incluir(Connection conn) {
	      String sqlInsert = "INSERT INTO POST(Titulo, Conteudo, Resposta, Area_Post, ID_Criador, ID_Avaliador, Aceite) VALUES (?, ?, null, ?, ?, null, 0)";
	   
	      try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
	         stm.setString(1, getTitulo());
	         stm.setString(2, getConteudo());
	         stm.setInt(3, getArea());
	         stm.setInt(4, getCriador());
	         stm.execute();
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	         try {
	            conn.rollback();
	         } 
	         catch (SQLException e1) {
	            System.out.print(e1.getStackTrace());
	         }
	      }
		return null;
	   }
	   
	   public void AceitePost(Connection conn) {
	      String sqlUpdate = "UPDATE POST SET Resposta=?, Aceite = ?, ID_Avaliador = ? WHERE ID = ?";
	   
	      try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
	         stm.setString(1, getResposta());
	         stm.setInt(2, getAceite());
	         stm.setInt(3, getAvaliador());
	         stm.setInt(4, getId());
	         
	      
	         stm.execute();
	      } 
	      catch (Exception e) {
	         e.printStackTrace();
	         try {
	            conn.rollback();
	         } 
	         catch (SQLException e1) {
	            System.out.print(e1.getStackTrace());
	         }
	      }
	   }
	   
	   public ArrayList<PostTO> Mural(Connection conn) {
	   
	      ArrayList<PostTO> lista = new ArrayList<PostTO>();
	      
	      String sqlSelect = "SELECT * FROM POST WHERE Aceite = true";
	   
	      try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
	         AvaliadorDAO avaliador = new AvaliadorDAO();
	         ResultSet rs = stm.executeQuery();
	            
	         while (rs.next()) {
	            PostTO p = new PostTO();
	            p.setTitulo(rs.getString("Titulo"));
	            p.setConteudo(rs.getString("Conteudo"));
	            p.setArea(rs.getInt("Area_Post"));
	            p.setCriador(rs.getInt("ID_Criador"));
	            p.setResposta(rs.getString("Resposta"));
	            p.setAvaliador(rs.getInt("ID_Avaliador"));
	            lista.add(p);
	         }
	      } 
	      catch (SQLException e1) {
	         System.out.print(e1.getStackTrace());
	      }
	      
	      return lista;
	   }
	   
	   public ArrayList<PostTO> MeusPosts(Connection conn, int ID) {
	   
	   
	      
	      ArrayList<PostTO> lista = new ArrayList<PostTO>();
	      
	      String sqlSelect = "SELECT * FROM POST WHERE ID_Criador = ?";
	      try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
	          
	        
	         stm.setInt(1, ID);
	         try (ResultSet rs = stm.executeQuery();) {
	                     
	         
	         
	         
	         
	           
	            while (rs.next()) {
	               PostTO p = new PostTO();
	            
	               p.setTitulo(rs.getString("Titulo"));
	               p.setConteudo(rs.getString("Conteudo"));
	               p.setArea(rs.getInt("Area_Post"));
	               p.setCriador(rs.getInt("ID_Criador"));
	               p.setResposta(rs.getString("Resposta"));
	               p.setAvaliador(rs.getInt("ID_Avaliador"));
	               lista.add(p);
	            }
	         }   
	         catch (Exception e) {
	            e.printStackTrace();
	         }
	      }
	      catch (SQLException e1) {
	         System.out.print(e1.getStackTrace());
	      }
	      
	      return lista;
	   }
	   
	   public String total(Connection conn) {
	      String x = "";
	      String sqlSelect = "select count(ID) from POST;";
	   
	      try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
	         try (ResultSet rs = stm.executeQuery();) {
	            if (rs.next()) {
	               x = rs.getString("count(ID)");
	               
	               
	            } 
	            else {
	               x = "Erro";
	            }
	         
	         } 
	         catch (Exception e) {
	            e.printStackTrace();
	         }
	      } 
	      catch (SQLException e1) {
	         System.out.print(e1.getStackTrace());
	      }
	      return x;
	   }
	   
	   public String parcial(Connection conn, int n) {
	      String x = "";
	      String sqlSelect = "select count(Aceite) from POST where Aceite=?;";
	   
	      try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
	         stm.setInt(1, n);
	         try (ResultSet rs = stm.executeQuery();) {
	            if (rs.next()) {
	               x = rs.getString("count(Aceite)");
	               
	               
	            } 
	            else {
	               x = "Erro";
	            }
	         
	         } 
	         catch (Exception e) {
	            e.printStackTrace();
	         }
	      } 
	      catch (SQLException e1) {
	         System.out.print(e1.getStackTrace());
	      }
	      return x;
	   }
	   
	   public String totalArea(Connection conn, int n) {
	      String x = "";
	      String sqlSelect = "select count(ID) from POST where Area_Post = ?;";
	   
	      try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
	         stm.setInt(1, n);
	         try (ResultSet rs = stm.executeQuery();) {
	            if (rs.next()) {
	               x = rs.getString("count(ID)");
	               
	               
	            } 
	            else {
	               x = "Erro";
	            }
	         
	         } 
	         catch (Exception e) {
	            e.printStackTrace();
	         }
	      } 
	      catch (SQLException e1) {
	         System.out.print(e1.getStackTrace());
	      }
	      return x;
	   }
	   
	   public String parcialArea(Connection conn, int n, int n2) {
	      String x = "";
	      String sqlSelect = "select count(ID) from POST where Area_Post = ? and Aceite = ?;";
	   
	      try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
	         stm.setInt(1, n);
	         stm.setInt(2, n2);
	         try (ResultSet rs = stm.executeQuery();) {
	            if (rs.next()) {
	               x = rs.getString("count(ID)");
	               
	               
	            } 
	            else {
	               x = "Erro";
	            }
	         
	         } 
	         catch (Exception e) {
	            e.printStackTrace();
	         }
	      } 
	      catch (SQLException e1) {
	         System.out.print(e1.getStackTrace());
	      }
	      return x;
	   }


}
