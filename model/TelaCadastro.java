package model;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.sql.*;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame implements ActionListener {

   private JLabel lblLogin;
   private JLabel lblSenha;
   private JLabel lblConfirmacaSenha;
   private JLabel lblNome;
   private JTextField txtLogin;
   private JTextField txtNome;
   private JPasswordField txtSenha;
   private JPasswordField txtConfirmaSenha;
   private JButton btnCadastra;
   private JButton btnCancelar;
   private Connection conn;
    
   private JFrame frame;
   private JLabel lbllogo;    



   public TelaCadastro(Connection conn) {
       //super("Cadastro de Usuário");
       
      frame = new JFrame("Cadastro de Usuário");
   
      lblLogin = new JLabel("Login:");
      lblSenha = new JLabel("Senha:");
      lblConfirmacaSenha = new JLabel("Confirme sua senha:");
      lblNome = new JLabel("Nome:");
      txtNome = new JTextField(15);
      txtLogin = new JTextField(15);
      txtConfirmaSenha = new JPasswordField(15);
      txtSenha = new JPasswordField(15);
      btnCadastra = new JButton("Cadastrar");
      btnCancelar = new JButton("Voltar");
        
      this.conn = conn;
   
      Container telaCadastro = frame.getContentPane();
       // telaCadastro.setLayout(new GridLayout(6, 2));
        //JPanel pnlCentro = new JPanel(new GridLayout(4, 2));
        //JPanel pnlSul = new JPanel(new FlowLayout());
        
      ImageIcon img = new ImageIcon("add_user.png");
      lbllogo = new JLabel(img);
      JPanel panel = new JPanel();  
   
   
      panel.add(lbllogo);
      panel.add(lblNome);
      panel.add(txtNome);
      panel.add(lblLogin);
      panel.add(txtLogin);
      panel.add(lblSenha);
      panel.add(txtSenha);
      panel.add(lblConfirmacaSenha);
      panel.add(txtConfirmaSenha);
      panel.add(btnCadastra);
      panel.add(btnCancelar);
      telaCadastro.add(panel);
         
        //pnlSul.add(btnCadastra, BorderLayout.CENTER);
   
        //telaCadastro.add(pnlCentro, BorderLayout.CENTER);
        //telaCadastro.add(pnlSul, BorderLayout.WEST);
   
      btnCadastra.addActionListener(this);
      btnCancelar.addActionListener(this);
        
      frame.pack();
      frame.setSize(new Dimension(530, 150));   
      frame.setResizable(false);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      frame.setLocationRelativeTo(null);
   
       //  setSize(400, 200);
   //         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   //         setLocationRelativeTo(null);
   //         setVisible(true);
   }

   public void actionPerformed(ActionEvent ee) {
      if (ee.getSource() == btnCadastra) {
        
         if(txtSenha.getText().length()>0 && txtConfirmaSenha.getText().length()>0 && txtLogin.getText().length()>0 && txtNome.getText().length()>0)
         {
            if(txtSenha.getText().equals(txtConfirmaSenha.getText()))
            {
               try
               {
                  UsuarioTO usuario = new UsuarioTO(txtNome.getText(),txtSenha.getText(),txtLogin.getText());
           //       usuario.incluir(conn);
                  JOptionPane.showMessageDialog(null, "Cadastro realizado com êxito.");
               }
               catch(Exception e)
               {
                  JOptionPane.showMessageDialog(null, "Impossivel criar conta");
               }
            }
            else
            {
               JOptionPane.showMessageDialog(null, "Senhas diferentes");
            }
         }
         else
         {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
         }
      }
      if (ee.getSource() == btnCancelar){
         frame.setVisible(false);
        // telaLogin login = new telaLogin();
      }
   }
}