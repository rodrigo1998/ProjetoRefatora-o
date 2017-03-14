package model;

import java.awt.*;
import javax.swing.*;

import dao.areaDAO;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.sql.*;

public class TelaCadastroAvaliadorTO extends JFrame implements ActionListener {

    private JLabel lblLogin;
    private JLabel lblSenha;
    private JLabel lblConfirmacaSenha;
    private JLabel lblNome;
    private JLabel lblArea;
    
    private areaTO lista;
    private JComboBox cmbArea;
    private areaTO area;
    
    private JTextField txtLogin;
    private JTextField txtNome;
    private JPasswordField txtSenha;
    private JPasswordField txtConfirmaSenha;
    private JButton btnCadastra;
    private JButton btnExcluir;
    private JButton btnAlterar;
    private JButton btnBuscar;
    private JButton btnCancelar;
    private Connection conn;

    public TelaCadastroAvaliadorTO(int conn) {
        super("Cadastro de Avaliador");
        lblLogin = new JLabel("Login:");
        lblSenha = new JLabel("Senha:");
        lblConfirmacaSenha = new JLabel("Confirme sua senha:");
        lblNome = new JLabel("Nome:");
        lblArea = new JLabel("Area:");
        
        cmbArea = new JComboBox();
        area = new areaTO();
        lista = areaDAO.carregar(conn);
//        for (int i=0; i<lista.size(); i++)
//        {
//           cmbArea.addItem(lista.get(i).getNome());
//        }
        
        txtNome = new JTextField(15);
        txtLogin = new JTextField(15);
        txtSenha = new JPasswordField(15);
        txtConfirmaSenha = new JPasswordField(15);
        btnCadastra = new JButton("Cadastrar");
        btnCancelar = new JButton("Cancelar");
        btnExcluir = new JButton("Excluir");
        btnBuscar = new JButton("Buscar");
        btnAlterar = new JButton("Alterar");
        
//        this.conn = conn;

        Container telaCadastro = getContentPane();
        telaCadastro.setLayout(new GridLayout(9, 2));
        //JPanel pnlCentro = new JPanel(new GridLayout(4, 2));
        //JPanel pnlSul = new JPanel(new FlowLayout());

        telaCadastro.add(lblNome);
        telaCadastro.add(txtNome);
        telaCadastro.add(lblLogin);
        telaCadastro.add(txtLogin);
        telaCadastro.add(lblArea);
        telaCadastro.add(cmbArea);
        telaCadastro.add(lblSenha);
        telaCadastro.add(txtSenha);
        telaCadastro.add(lblConfirmacaSenha);
        telaCadastro.add(txtConfirmaSenha);
        telaCadastro.add(btnCadastra);
        telaCadastro.add(btnExcluir);
        telaCadastro.add(btnBuscar);
        telaCadastro.add(btnAlterar);
        telaCadastro.add(btnCancelar);
        //pnlSul.add(btnCadastra, BorderLayout.CENTER);

        //telaCadastro.add(pnlCentro, BorderLayout.CENTER);
        //telaCadastro.add(pnlSul, BorderLayout.WEST);

        btnCadastra.addActionListener(this);
        btnCancelar.addActionListener(this);
        btnAlterar.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnExcluir.addActionListener(this);

        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ee) {

    //Cadastrar
        if (ee.getSource() == btnCadastra) {
            try{
               if(txtSenha.getText().length()>0 && txtConfirmaSenha.getText().length()>0 && txtLogin.getText().length()>0 && txtNome.getText().length()>0)
               {
                   
                   if(txtSenha.getText().equals(txtConfirmaSenha.getText()))
                   {
                 //     Avaliador avaliador = new Avaliador(txtNome.getText(), txtSenha.getText(), txtLogin.getText(), cmbArea.getSelectedIndex()+1);
                   //   avaliador.incluir(conn);
                      JOptionPane.showMessageDialog(null, "Cadastro realizado com êxito.");
                   }else
                   {
                      JOptionPane.showMessageDialog(null, "Senhas diferentes");
                   }
               }else
                {
                  JOptionPane.showMessageDialog(null, "Preencha todos os campos");   
                }
            }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null, "Impossivel criar conta");
            }
        }
        if (ee.getSource() == btnCancelar){
        //    telaSuperior superior = new telaSuperior();
            setVisible(false);
         //   superior.setVisible(true);
        }
        //Fim Cadastrar
        
        
        //Excluir
        if (ee.getSource() == btnExcluir)
        {
//            Usuario usuario = new Usuario(txtLogin.getText());
//            usuario.excluir(conn);
            JOptionPane.showMessageDialog(null, "Conta: "+txtLogin.getText()+" deletada do sistema com sucesso.");
        }
        
        
        //Alterar
          if (ee.getSource() == btnAlterar)

        {
            try{
       //         Avaliador avaliador = new Avaliador(txtNome.getText(), txtSenha.getText(), cmbArea.getSelectedIndex()+1, txtLogin.getText());
         //       avaliador.atualizarAvaliador(conn);
                JOptionPane.showMessageDialog(null, "Conta: "+txtLogin.getText()+" Alterada do sistema com sucesso.");
            }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null, "Conta não existe.");

            }
        }
        
        // Buscar
        if(ee.getSource() == btnBuscar){
//         try{
//            //Usuario usuario = new Usuario(txtLogin.getText());
//           // Avaliador avaliador = new Avaliador(txtLogin.getText());
//            avaliador.carregar(conn);
//            txtNome.setText(avaliador.getNome());
//            txtSenha.setText(avaliador.getSenha());
//            txtConfirmaSenha.setText(avaliador.getSenha());
//            cmbArea.setSelectedIndex(avaliador.getArea()-1);
//            }
//         catch(Exception e)
//         {
             JOptionPane.showMessageDialog(null, "Conta não existe.");
         }
         }
         
    }
//}
