package domain.batalha;

import domain.jogador.Jogador;
import domain.personagem.Personagem;
import domain.personagem.habilidades.Habilidade;

import java.util.List;

public class Batalha {

    private Jogador jogador1;
    private Jogador jogador2;
    private int turnoAtual;
    private boolean batalhaFinalizada;

    // regra do par ou ímpar (fica no domínio, sem ler teclado)
    public void inicar(int Jogador1, int Jogador2) {
        if (!batalhaFinalizada) {
            System.out.print("Partinda iniciada");
        }
    }

    public void finalizarBatalha(){
        if (jogador1.estaDerrotado() || jogador2.estaDerrotado()){
            batalhaFinalizada = true;
        }
    }

    public void executarPartida(Personagem pOrgigem, List<Personagem> pAlvos, Habilidade habilidade, Jogador jOrigem) {
        jOrigem.realizarAcao(pOrgigem, pAlvos, habilidade);
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public int getTurnoAtual() {
        return turnoAtual;
    }

    public void setTurnoAtual(int turnoAtual) {
        this.turnoAtual = turnoAtual;
    }

    public boolean isBatalhaFinalizada() {
        return batalhaFinalizada;
    }

    public void setBatalhaFinalizada(boolean batalhaFinalizada) {
        this.batalhaFinalizada = batalhaFinalizada;
    }
}
