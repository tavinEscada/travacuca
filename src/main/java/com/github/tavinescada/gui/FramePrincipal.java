package com.github.tavinescada.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FramePrincipal extends JFrame{

    private Container container;

    public FramePrincipal(){
        this.setLayout(new BorderLayout());
        
        setTitle("Racha cu(ca)");

        setSize(500, 600);

        container = this.getContentPane();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //trocar para a tela inicial?
    }

    public void trocaPainel(JPanel novoPainel){
        container.removeAll();
        container.add(novoPainel);

        validate();

        setVisible(true);

        repaint();
    }
}
