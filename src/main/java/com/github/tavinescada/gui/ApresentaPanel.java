package com.github.tavinescada.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ApresentaPanel extends JPanel{

    private final FramePrincipal frameP;

    public ApresentaPanel(FramePrincipal pai){

        this.setLayout(new GridLayout(3, 1, 1, 6));

        
        JLabel fodaseLabel = new JLabel("Racha-Cuca do caralho");

        JPanel difs = new JPanel();
        
        difs.setLayout(new GridLayout(2, 1, 2, 0));
        JLabel dificuldadeLabel = new JLabel("Dificuldade:");

        String[] dificuldades = {"Facil", "Medio", "Dificil"};
        JComboBox difComboBox = new JComboBox<>(dificuldades);
        difComboBox.setSelectedIndex(1);

        difs.add(dificuldadeLabel);
        difs.add(difComboBox);

        JButton comecarBtn = new JButton("Começar");
        comecarBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });

        this.add(fodaseLabel, BorderLayout.NORTH);
        this.add(difs, BorderLayout.CENTER);
        this.add(comecarBtn, BorderLayout.SOUTH);

        this.frameP = pai;
    }
}
