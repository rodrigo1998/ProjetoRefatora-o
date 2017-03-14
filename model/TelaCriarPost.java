package model;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.sql.*;
import model.*;

public class TelaCriarPost extends JFrame implements ActionListener {

    private JLabel lblTitulo;
    private JLabel lblConteudo;
    private JTextField txtTitulo;
    private JTextArea txtConteudo;
    private JComboBox cmbArea;
    private String ID;
    
    public void setID(String ID)
    {
      this.ID = ID;
    }
    
//    private ArrayList<AreaTO> lista;
//    private Area area;
    
    private JButton btnEnviar;
    private JButton btnVoltar;
    
    private Connection conn;

    public TelaCriarPost(Connection conn, String ID) {
        super("Cadastro de Avaliador");
        
        setID(ID);
        
        lblTitulo = new JLabel("Título");
        lblConteudo = new JLabel("Conteúdo");
        txtConteudo = new JTextArea("");
        txtTitulo = new JTextField("Insira seu título");
        
        btnEnviar = new JButton("Enviar");
        btnVoltar = new JButton("Voltar");
        
//        cmbArea = new JComboBox();
//        area = new Area();
//        lista = area.carregar(conn);
//        for (int i=0; i<lista.size(); i++)
//        {
//           cmbArea.addItem(lista.get(i).getNome());
//        }
        
        this.conn = conn;

        //Container telaCadastro = getContentPane();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        //JPanel pnlCentro = new JPanel(new GridLayout(4, 2));
        //JPanel pnlSul = new JPanel(new FlowLayout());

        getContentPane().add(lblTitulo);
        getContentPane().add(txtTitulo);
        getContentPane().add(cmbArea);
        getContentPane().add(lblConteudo);
        getContentPane().add(txtConteudo);
        
        getContentPane().add(btnEnviar);
        getContentPane().add(btnVoltar);
        //pnlSul.add(btnCadastra, BorderLayout.CENTER);

        //telaCadastro.add(pnlCentro, BorderLayout.CENTER);
        //telaCadastro.add(pnlSul, BorderLayout.WEST);

        btnEnviar.addActionListener(this);
        btnVoltar.addActionListener(this);

        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ee) {

    //Enviar
        if (ee.getSource() == btnEnviar) {
      //   Post post = new Post(Integer.parseInt(ID), txtTitulo.getText(),txtConteudo.getText(), cmbArea.getSelectedIndex()+1);
      //   post.incluir(conn);
         JOptionPane.showMessageDialog(null,"Post enviado");
         }
        
    //Voltar
        if (ee.getSource() == btnVoltar) {
      //      telaMural mural = new telaMural();
       //     mural.setId(ID);
            setVisible(false);
        
        }            
    }    
}

