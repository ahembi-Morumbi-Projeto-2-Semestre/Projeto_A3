package adapter.outbound;

import application.port.outbound.JogadorRepository;
import domain.jogador.Jogador;

import java.util.ArrayList;
import java.util.List;

public class JogadorMemoriaAdapter implements JogadorRepository {

    List<Jogador> jogadores = new ArrayList<>();

    @Override
    public void adicionaJogador(Jogador jogador) {
        jogadores.add(jogador);
    }
}
