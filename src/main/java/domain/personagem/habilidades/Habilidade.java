package domain.personagem.habilidades;

import domain.personagem.Personagem;

import java.util.List;

public interface Habilidade  {
    void habilidade(int pontos, List<Personagem> pAlvos, Personagem pOrigem);
}