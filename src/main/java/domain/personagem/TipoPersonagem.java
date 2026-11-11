package domain.personagem;

public enum TipoPersonagem {
    BARBARO("BARBARO"),
    ARQUEIRO("ARQUEIRO"),
    MAGO("MAGO"),
    SAMURAI("SAMURAI"),
    GUERREIRO("GUERREIRO");

    private String nome;

    TipoPersonagem(String nome) {
        this.nome = nome;
    }
}
