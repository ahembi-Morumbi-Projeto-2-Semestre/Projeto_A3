package application.service;

import adapter.outbound.JogadorMemoriaAdapter;
import domain.jogador.Jogador;

import java.util.ArrayList;
import java.util.List;

public class JogadorService {

    private JogadorMemoriaAdapter jogadorMemoriaAdapter;

    public JogadorService(JogadorMemoriaAdapter jogadorMemoriaAdapter) {
        this.jogadorMemoriaAdapter = jogadorMemoriaAdapter;
    }

    public void adicionarJogador(Jogador jogador){
        jogadorMemoriaAdapter.adicionaJogador(jogador);
    }

}
