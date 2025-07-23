package com.github.tavinescada.gui;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.tavinescada.gui.ApresentaPanel.Dificuldade;

public class JogoPanel extends JPanel{

    //private final FramePrincipal frameP;

    public JogoPanel(Dificuldade dificuldade, FramePrincipal pai){
        //this.frameP = pai;

        //facil: 20 movimentacoes a partir da matriz ordenada
        //medio: 40 movimentacoes a partir da matriz
        //dificil: 80 movimentacoes
        JLabel dificuldadeLabel = new JLabel(dificuldade.getNome());

        this.add(dificuldadeLabel);

        JButton rBtn = new JButton("Reiniciar");
        JButton voltarBtn = new JButton("Voltar");
        


        voltarBtn.addActionListener((ActionEvent e)->{
            pai.trocaPainel(new ApresentaPanel(pai));
        });

        this.add(rBtn);
        this.add(voltarBtn);
    }
}
