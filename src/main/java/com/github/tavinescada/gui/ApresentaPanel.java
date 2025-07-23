package com.github.tavinescada.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ApresentaPanel extends JPanel{

    //private final FramePrincipal frameP;

    public enum Dificuldade{
        
        FACIL(1, "Facil"), MEDIO(2, "Medio"), DIFICL(3, "Dificil");

        private final int nivel;
        private final String nome;

        Dificuldade(int nivel, String nome) {
            this.nivel = nivel;
            this.nome = nome;
        }

        // Getters
        public int getNivel() { 
            return nivel; 
        }
        
        public String getNome() { 
            return nome; 
        }
        
        // Para exibir o nome no ComboBox
        @Override
        public String toString() {
            return nome;
        }
        
    }

    public ApresentaPanel(FramePrincipal pai){

        //this.frameP = pai;

        this.setLayout(new BorderLayout(0, 130));

        JPanel topPanel = new JPanel();
        JLabel tituloLabel = new JLabel("Racha-Cuca do caralho");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 25));
        tituloLabel.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(tituloLabel);

        JPanel difsPanel = new JPanel(new BorderLayout(0, 5));
        JLabel dificuldadeLabel = new JLabel("Dificuldade:");
        dificuldadeLabel.setFont(new Font("Arial", Font.BOLD, 15));
        dificuldadeLabel.setHorizontalAlignment(JLabel.CENTER);
        
        difsPanel.add(dificuldadeLabel, BorderLayout.NORTH);
        //String[] dificuldades = {"Facil", "Medio", "Dificil"};
        JComboBox<Dificuldade> difComboBox = new JComboBox<>(Dificuldade.values());
        difComboBox.setSelectedIndex(1);
        difComboBox.setPreferredSize(new Dimension(150, 35));

        JPanel comboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        comboPanel.add(difComboBox);

        difsPanel.add(dificuldadeLabel, BorderLayout.NORTH);
        difsPanel.add(comboPanel, BorderLayout.CENTER);

        JButton comecarBtn = new JButton("Começar");
        comecarBtn.setPreferredSize(new Dimension(200, 40));

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(comecarBtn);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(difsPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        // Adicionando margens ao redor do painel principal
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        comecarBtn.addActionListener((ActionEvent e) -> {
            
            Dificuldade dif = (Dificuldade)difComboBox.getSelectedItem();
            JogoPanel nJogo = new JogoPanel(dif, pai);
            pai.trocaPainel(nJogo);

        });

    }
}
