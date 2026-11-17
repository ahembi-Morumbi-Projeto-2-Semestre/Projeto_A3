package domain.personagem.habilidades;

import domain.personagem.Personagem;

import java.util.List;

public class Porrada implements Habilidade {

    private static final int PONTOS = 10;

    @Override
    public int getPontos() {
        return PONTOS;
    }

    @Override
    public void habilidade(List<Personagem> pAlvos, Personagem pOrigem) {

            int danoAtaque =  getPontos() * pOrigem.getPontosAtaque();

            for(Personagem p : pAlvos){
                p.receberDano(danoAtaque);
            }
        }

    }


