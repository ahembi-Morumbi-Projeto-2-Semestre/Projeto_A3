package domain.jogador;

import domain.personagem.Personagem;
import domain.personagem.habilidades.Habilidade;

import java.util.List;

public class Jogador {

    private String nome;
    private Equipe equipe;

    public void realizarAcao(Personagem pOrgigem, List<Personagem> pAlvos, Habilidade habilidade){
        habilidade.habilidade(pAlvos, pOrgigem);
    };

    public void realizarAcao(Personagem pOrgigem, Personagem pAlvo, Habilidade habilidade){
        habilidade.habilidade(List.of(pAlvo), pOrgigem);
    };


    public boolean estaDerrotado(){
        if (equipe.equipeEstaDerrotada()){
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
