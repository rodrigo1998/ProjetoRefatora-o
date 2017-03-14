package model;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComponent.*;
import java.awt.*;
import java.awt.event.*;

public class TelaAvaliadorTO extends JFrame implements ActionListener {

  
   
   private JLabel lblAvaliar;
   private ArrayList<PostTO> lista;
   private JComboBox cmbPost, cmbRecebe;
   private PostTO post;
   private JButton btnAvaliar;
   private JButton btnDeslogar;
   private JButton btnMural;
   private String var;
   private String varr;
   private Connection conn;
   private int id;
   //TelaAvaliarPostTO telaAvaliar;
   PreparedStatement pst = null;
   ResultSet rs = null;

   public void recebendo (String recebe, int id){
      
      this.id = id;
      var = recebe;
      String sql = "select * from POST where Aceite = 0 and Area_Post="+String.valueOf(var);
      
      try{
         pst = conn.prepareStatement(sql);
         rs = pst.executeQuery();
         
      
         while(rs.next()){
            cmbPost.addItem(rs.getString("ID") + " - " + rs.getString("Titulo"));
                    }
      
      }
      catch(SQLException ex){
      
      }
   }




   public TelaAvaliadorTO(Connection conn) {
   
   
      super("Bem - vindo");
      
      
      lblAvaliar = new JLabel("Avaliar:");
      
      cmbPost = new JComboBox();

    
      
      btnAvaliar = new JButton("Avaliar");
      btnDeslogar = new JButton("Sair");        
      btnMural = new JButton("Mural");
       	        
     
      this.conn = conn;
   
      Container telaCadastro = getContentPane();
      telaCadastro.setLayout(new GridLayout(4,4));
      
           
    
         
      telaCadastro.add(lblAvaliar);
      telaCadastro.add(cmbPost);
      telaCadastro.add(btnAvaliar);
      telaCadastro.add(btnDeslogar);
      telaCadastro.add(btnMural);

      
      
      btnAvaliar.addActionListener(this);
      btnDeslogar.addActionListener(this);
      btnMural.addActionListener(this);
      
    
      setSize(380,140);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
      this.recebendo(var, id);
   }
   


   public void actionPerformed(ActionEvent ee) {
   
   
      if (ee.getSource() == btnAvaliar)
      {
        
         setVisible(false);
         //telaAvaliar = new TelaAvaliarPost(conn, var);
         //telaAvaliar.recebendo1(String.valueOf(cmbPost.getSelectedItem()).substring(0,4),id);
      
      }
      if (ee.getSource() == btnDeslogar)
      {
         //new telaLogin();
         setVisible(false);
         
      }
      if (ee.getSource() == btnMural)
      { 
      
         //telaMural TelaMural = new telaMural();
      }
   } 
              
     
   
}