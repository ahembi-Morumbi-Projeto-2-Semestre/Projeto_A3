package domain.jogador;

import domain.personagem.Personagem;

import java.util.List;

public class Equipe {
    private String nome;
    private List<Personagem> personagems;


    public void adcionarPersonagemNaEquipe(Personagem personagem){
        if (personagems.size()  < 1)  {
            personagems.add(personagem);
        }
    }

    public boolean equipeEstaDerrotada(){

        boolean algumVivo = personagems
                .stream()
                .anyMatch(Personagem::estaVivo);

        if (!algumVivo){
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

    public List<Personagem> getPersonagems() {
        return personagems;
    }

}
