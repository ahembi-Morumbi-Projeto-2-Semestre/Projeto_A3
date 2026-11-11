package domain.personagem.habilidades;

import domain.personagem.Personagem;

import java.util.List;


public interface Habilidade  {

    int getPontos();   // toda habilidade TEM que informar seus pontos
    void habilidade(List<Personagem> pAlvos, Personagem pOrigem);
}