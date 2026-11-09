package domain.personagem.habilidades;

import domain.personagem.Personagem;

import java.util.List;

public class Porrada implements Habilidade {

    @Override
    public void habilidade(int pontos, List<Personagem> pAlvos, Personagem pOrigem) {

            pontos = 10;

            int danoAtaque =  pontos * pOrigem.getPontosAtaque();

            for(Personagem p : pAlvos){
                p.receberDano(danoAtaque);
            }
        }

    }


