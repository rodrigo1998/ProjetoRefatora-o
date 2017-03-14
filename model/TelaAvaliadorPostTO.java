package model;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JComponent.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TelaAvaliadorPostTO extends JFrame implements ActionListener
{
   private JLabel lblTitulo, lblConteudo,lblTituloPost;
   private JButton btnAceitar, btnRecusar, btnVoltar;
   private Connection conn;
   private JTextArea lblConteudoPost;
   PreparedStatement pst = null;
   ResultSet rs = null;
   private String var;
   private String area;
   private int id;
   
   public void recebendo1 (String recebe, int id){
      this.id = id;
      var = recebe;
      String sql = "select * from POST where ID="+String.valueOf(var);
      try{
         pst = conn.prepareStatement(sql);
         rs = pst.executeQuery();
      
         while(rs.next()){
            lblConteudoPost.setText(rs.getString("Conteudo"));
         }
      
      }
      catch(SQLException ex){
      
      }
   }
   
   public TelaAvaliadorPostTO(Connection conn, String Area){
      super("Titulo");
      this.area = Area;
      lblConteudoPost = new JTextArea();
      lblConteudoPost.setEditable(false);
      lblConteudoPost.setLineWrap(true);
      lblConteudoPost.setWrapStyleWord(true);
      lblConteudoPost.setEditable(false);
      JScrollPane scroll = new JScrollPane(lblConteudoPost); 
      btnRecusar = new JButton("Recusar");
      btnAceitar = new JButton("Aceitar");
      btnVoltar = new JButton("Voltar");
      
      this.conn = conn;
      
      Container caixa = getContentPane();
      caixa.setLayout(new BorderLayout());
      
      Container telaAvaliar = getContentPane();
      telaAvaliar.setLayout(new GridLayout(2,4));
      
      telaAvaliar.add(scroll);
     // telaAvaliar.add(btnRecusar);
      //telaAvaliar.add(btnAceitar);
      //telaAvaliar.add(btnVoltar);
      
   
      
      JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
     // JPanel painelCentro = new JPanel(new GridLayout(10,10));
    
    // painelCentro.add(lblConteudoPost);
      painelBotoes.add(btnAceitar);
      painelBotoes.add(btnRecusar);
      painelBotoes.add(btnVoltar);
      
      //caixa.add(painelCentro);
      caixa.add(painelBotoes, BorderLayout.SOUTH);
      
      btnRecusar.addActionListener(this);
      btnAceitar.addActionListener(this);
      btnVoltar.addActionListener(this);
      
      setSize(400,160);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
        this.recebendo1(var,id);

   }
      
   public void actionPerformed(ActionEvent e){
   
      if(e.getSource() == btnRecusar)
      {
        String resp ="";
        JOptionPane.showMessageDialog(null,"Post Recusado");
        PostTO post = new PostTO(Integer.parseInt(var), resp, 3, id);
        post.getAceite();
        setVisible(false);
        TelaAvaliadorTO tela = new TelaAvaliadorTO(conn);
        tela.recebendo(String.valueOf(area),id);
      }
      else if(e.getSource() == btnAceitar)
      {
        String resp = JOptionPane.showInputDialog("Resposta:");
        PostTO post = new PostTO(Integer.parseInt(var), resp, 1, id);
        post.getAceite();
        setVisible(false);
        TelaAvaliadorTO tela = new TelaAvaliadorTO(conn);
        tela.recebendo(String.valueOf(area),id);
      } 
      else if(e.getSource() == btnVoltar)
      {
        setVisible(false);
        TelaAvaliadorTO tela = new TelaAvaliadorTO(conn);
     // JOptionPane.showMessageDialog(null,var);
        tela.recebendo(String.valueOf(area),id);
     
      }
   }

}