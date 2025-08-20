package com.github.tavinescada;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

import com.github.tavinescada.gui.ApresentaPanel.Dificuldade;

public class Jogo {
    private static final int[][] matOrdenada = {
        {1, 2, 3}, 
        {4, 5, 6}, 
        {7, 8, 0}
    };
                                        
    private int[][] matAtual = new int[3][3];
    private int[] pos0;


    public Jogo(Dificuldade dificuldade){
        inicializa();
    }

    private void inicializa(){
        for(int i = 0; i < 3; i++){
            System.arraycopy(matOrdenada[i], 0, matAtual[i], 0, 3);
        }

        pos0[0] = 2;
        pos0[1] = 2;

    }

    private ArrayList<Integer> getNumerosPossiveis(int[][] mat){
        ArrayList<Integer> botoesA = new ArrayList<>();
        for(int btn : botoes){
            if(btn.isVisible() && podeSerMovido(btn, mat)){
                botoesA.add(btn);
            }
        }
        return botoesA;
    }

    public void embaralha(int nMov){
        int n = 0;
        int ultimoNumero = -1;
        Random gerador = new Random();
        while(n < nMov){
            ArrayList<Integer> botoesPossiveis = vetBotoesParaMover(mat, botoesTotais);

            JButton btn = botoesPossiveis.get(gerador.nextInt(0, botoesPossiveis.size()));

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
