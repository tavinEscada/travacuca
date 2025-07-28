package com.github.tavinescada.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.github.tavinescada.gui.ApresentaPanel.Dificuldade;

public class JogoPanel extends JPanel{

    //JLabel jogadasLabel;

    public JogoPanel(Dificuldade dificuldade, FramePrincipal pai){

        this.setLayout(new BorderLayout());

        JPanel topoPanel = new JPanel();
        JLabel dificuldadeLabel = new JLabel(dificuldade.getNome());
        dificuldadeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        dificuldadeLabel.setHorizontalAlignment(JLabel.CENTER);
        topoPanel.add(dificuldadeLabel);

        this.add(topoPanel, BorderLayout.NORTH);

        //Dimension dBotoes = new Dimension(10, 10);

        JPanel centroPanel = new JPanel(new GridLayout(3, 3, 0, 0));
        JButton btn1 = new JButton("1");
        //btn1.setPreferredSize(dBotoes);
        JButton btn2 = new JButton("2");
        //btn2.setPreferredSize(dBotoes);
        JButton btn3 = new JButton("3");
        //btn3.setPreferredSize(dBotoes);
        JButton btn4 = new JButton("4");
        //btn4.setPreferredSize(dBotoes);
        JButton btn5 = new JButton("5");
        //btn5.setPreferredSize(dBotoes);
        JButton btn6 = new JButton("6");
        //btn6.setPreferredSize(dBotoes);
        JButton btn7 = new JButton("7");
        //btn7.setPreferredSize(dBotoes);
        JButton btn8 = new JButton("8");
        //btn8.setPreferredSize(dBotoes);
        JButton btn0 = new JButton("");
        //btn0.setPreferredSize(dBotoes);
        
        centroPanel.add(btn1);
        centroPanel.add(btn2);
        centroPanel.add(btn3);
        centroPanel.add(btn4);
        centroPanel.add(btn5);
        centroPanel.add(btn6);
        centroPanel.add(btn7);
        centroPanel.add(btn8);
        centroPanel.add(btn0);

        btn0.setVisible(false);

        JButton[] botoes = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn0};

        int[][] matizDoCrime = {{1, 2, 3}, 
                                {4, 5, 6}, 
                                {7, 8, 0}};

        btn1.addActionListener((ActionEvent e)->{
            
            jogada(btn1, matizDoCrime, botaoVazio(botoes));

            if(venceu(matizDoCrime)){
                JOptionPane.showMessageDialog(this, "Você venceu!!!");
            }

        });

        btn2.addActionListener((ActionEvent e)->{
            
            jogada(btn2, matizDoCrime, botaoVazio(botoes));

            if(venceu(matizDoCrime)){
                JOptionPane.showMessageDialog(this, "Você venceu!!!");
            }
        });

        btn3.addActionListener((ActionEvent e)->{
            
            jogada(btn3, matizDoCrime, botaoVazio(botoes));

            if(venceu(matizDoCrime)){
                JOptionPane.showMessageDialog(this, "Você venceu!!!");
            }
        });

        btn4.addActionListener((ActionEvent e)->{
            
            jogada(btn4, matizDoCrime, botaoVazio(botoes));

            if(venceu(matizDoCrime)){
                JOptionPane.showMessageDialog(this, "Você venceu!!!");
            }
        });

        btn5.addActionListener((ActionEvent e)->{
            
            jogada(btn5, matizDoCrime, botaoVazio(botoes));

            if(venceu(matizDoCrime)){
                JOptionPane.showMessageDialog(this, "Você venceu!!!");
            }
        });

        btn6.addActionListener((ActionEvent e)->{
            
            jogada(btn6, matizDoCrime, botaoVazio(botoes));

            if(venceu(matizDoCrime)){
                JOptionPane.showMessageDialog(this, "Você venceu!!!");
            }
        });

        btn7.addActionListener((ActionEvent e)->{
            
            jogada(btn7, matizDoCrime, botaoVazio(botoes));

            if(venceu(matizDoCrime)){
                JOptionPane.showMessageDialog(this, "Você venceu!!!");
            }
        });

        btn8.addActionListener((ActionEvent e)->{
            
            jogada(btn8, matizDoCrime, botaoVazio(botoes));

            if(venceu(matizDoCrime)){
                JOptionPane.showMessageDialog(this, "Você venceu!!!");
            }
        });

        btn0.addActionListener((ActionEvent e)->{
            
            jogada(btn0, matizDoCrime, botaoVazio(botoes));

            if(venceu(matizDoCrime)){
                JOptionPane.showMessageDialog(this, "Você venceu!!!");
            }
        });

        JPanel baixoPanel = new JPanel();
        JButton reiniciaBtn = new JButton("Reiniciar");
        JButton voltarBtn = new JButton("Voltar");

        reiniciaBtn.addActionListener((ActionEvent e)->{
            switch(dificuldade.getNivel()){
            case 1 -> {
                embaralha(40, matizDoCrime, botoes);
            }
            case 2 -> {
                embaralha(70, matizDoCrime, botoes);
            }
            case 3 -> {
                embaralha(100, matizDoCrime, botoes);
            }
        }
            
        });
        
        voltarBtn.addActionListener((ActionEvent e)->{
            pai.trocaPainel(new ApresentaPanel(pai));
        });

        baixoPanel.add(reiniciaBtn);
        baixoPanel.add(voltarBtn);

        centroPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        this.add(baixoPanel, BorderLayout.SOUTH);
        this.add(centroPanel, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        //facil: 40 movimentacoes a partir da matriz ordenada
        //medio: 80 movimentacoes a partir da matriz
        //dificil: 120 movimentacoes
        switch(dificuldade.getNivel()){
            case 1 -> {
                embaralha(40, matizDoCrime, botoes);
            }
            case 2 -> {
                embaralha(80, matizDoCrime, botoes);
            }
            case 3 -> {
                embaralha(100, matizDoCrime, botoes);
            }
        }
    }

    private boolean jogada(JButton btn, int[][] mat, JButton btn0){
        int n = Integer.parseInt(btn.getText());

        int[] posNum = posNumero(mat, n);
        int[] pos0 = espacoVazio(mat);

        if(podeSerMovido(btn, mat)){
            mudanca(pos0, posNum, btn, btn0, mat);
            
            return true;
        }
        return false;

    }

    private void mudanca(int[] pos0, int[] posNum, JButton btn, JButton btn0, int[][] mat){
        int temp = mat[pos0[0]][pos0[1]];
        mat[pos0[0]][pos0[1]] = mat[posNum[0]][posNum[1]];
        mat[posNum[0]][posNum[1]] = temp;

        btn0.setText(btn.getText());
        btn0.setVisible(true);

        btn.setText("");
        btn.setVisible(false);

    }

    private int[] espacoVazio(int mat[][]){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(mat[i][j] == 0){
                    int[] esp = {i, j};
                    return esp;
                }
            }
        }
        return null;
    }

    private int[] posNumero(int mat[][], int n){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(mat[i][j] == n){
                    int[] posNum = {i, j};
                    return posNum;
                }
            }
        }
        return null;
    }

    private JButton botaoVazio(JButton[] botoes){
        for(JButton btn : botoes){
            if(!btn.isVisible()){
                return btn;
            }
        }
        return null;
    }

    private boolean venceu(int[][] mat){
        int[][] matrizOrdenada = {{1, 2, 3}, 
                                  {4, 5, 6}, 
                                  {7, 8, 0}};

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(mat[i][j] != matrizOrdenada[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean podeSerMovido(JButton btn, int[][] mat){
        int n = Integer.parseInt(btn.getText());
        
        int[] posNum = posNumero(mat, n);
        int[] pos0 = espacoVazio(mat);
                    
        if(posNum[0] == pos0[0]){
            if(posNum[1] == pos0[1] + 1 || posNum[1] == pos0[1] - 1){
                return true;
            }
        }else{
            if(posNum[1] == pos0[1]){
                if(posNum[0] == pos0[0] + 1 || posNum[0] == pos0[0] - 1){
                    return true;
                }
            }
        }
        return false;
    }

    private ArrayList<JButton> vetBotoesParaMover(int[][] mat, JButton[] botoes){
        ArrayList<JButton> botoesA = new ArrayList<>();
        for(JButton btn : botoes){
            if(btn.isVisible() && podeSerMovido(btn, mat)){
                botoesA.add(btn);
            }
        }
        return botoesA;
    }

    private void embaralha(int nMov, int[][] mat, JButton[] botoesTotais){
        int n = 0;
        int nUltimoBotao = -1;
        while(n < nMov){
            ArrayList<JButton> botoespossiveis = vetBotoesParaMover(mat, botoesTotais);

            JButton btn = botoespossiveis.get((int)(Math.random() * botoespossiveis.size()));

            if(Integer.parseInt(btn.getText()) != nUltimoBotao){
                nUltimoBotao = Integer.parseInt(btn.getText());
                boolean jogadaFuncionou = jogada(btn, mat, botaoVazio(botoesTotais));
                if(jogadaFuncionou){
                    n++;

                    //teste das movimentações aleatórias
                    /*for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 3; j++){
                            System.out.print(mat[i][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    */

                }
            }
            
        }

    }

}
