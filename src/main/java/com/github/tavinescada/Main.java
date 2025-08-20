package com.github.tavinescada;

import javax.swing.JPanel;

import com.github.tavinescada.gui.ApresentaPanel;
import com.github.tavinescada.gui.FramePrincipal;

public class Main {
    public static void main(String[] args) {
        
        FramePrincipal FrameP = new FramePrincipal();
        JPanel ApPanel = new ApresentaPanel(FrameP);

        FrameP.trocaPainel(ApPanel);

        System.out.println(ApPanel);
        
    }
}