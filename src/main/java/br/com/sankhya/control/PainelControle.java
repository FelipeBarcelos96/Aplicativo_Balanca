/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sankhya.control;

import br.com.sankhya.view.BotaoView;

/**
 *
 * @author felip
 */
public class PainelControle {
    private BotaoView botao;
    private String balanca;
    
    public PainelControle(BotaoView botao) {
        this.botao = botao;
        this.balanca = botao.getBalancaComboBox().getSelectedItem().toString();
    }

    public String getBalanca() {
        return balanca;
    }    

    public void setBalanca(String balanca) {
        this.balanca = balanca;
    }    
    
}
