package domain.personagem;

import domain.personagem.habilidades.Habilidade;

import java.util.ArrayList;
import java.util.List;

public abstract class  Personagem  {
    //atributos
    private String nome;
    private int pontosDeVida;

    private int pontosAtaque;
    private int pontosDefesa;
    private int defesaAtual;
    private String desc;
    private String tipoPersonagem;
    private List<Habilidade> habilidades = new ArrayList<>();

    public boolean estaVivo(){
        return this.pontosDeVida > 0;
    }

    public void receberDano(int dano){
        int danoTotal = dano - this.defesaAtual;

        if(danoTotal <= 0) { danoTotal = 0; }

        this.pontosDeVida -= danoTotal;
    }

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void adicionarHabilidade(List<Habilidade> habilidadeList) {
        habilidades.addAll(habilidadeList);
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void receberProtecao(int protecao){
        this.defesaAtual += protecao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public int getPontosAtaque() {
        return pontosAtaque;
    }

    public void setPontosAtaque(int pontosAtaque) {
        this.pontosAtaque = pontosAtaque;
    }

    public int getPontosDefesa() {
        return pontosDefesa;
    }

    public void setPontosDefesa(int pontosDefesa) {
        this.pontosDefesa = pontosDefesa;
    }

    public int getDefesaAtual() {
        return defesaAtual;
    }

    public void setDefesaAtual(int defesaAtual) {
        this.defesaAtual = defesaAtual;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTipoPersonagem() {
        return tipoPersonagem;
    }

    public void setTipoPersonagem(String tipoPersonagem) {
        this.tipoPersonagem = tipoPersonagem;
    }
}
