## Estrutura de pacotes

### `domain/`
- `personagem/`
  - `Personagem.java` *(abstract)*
  - `Feiticeiro.java` *(e demais tipos: Guerreiro, ...)*
  - `TipoPersonagem.java` *(enum: Feiticeiro, ...)*
  - `habilidades/`
    - `Habilidade.java` *(interface)*
    - `HabilidadeDeDano.java` *(implementa Habilidade)*
    - `HabilidadeDeCura.java` *(implementa Habilidade)*
- `jogador/`
  - `Jogador.java` *(tem uma Equipe)*
  - `Equipe.java` *(tem a lista de Personagens)*
- `batalha/`
  - `Batalha.java` *(turnos, vez de quem joga e vencedor)*
  - `ResultadoTurno.java` *(devolve o que aconteceu na ação)*

### `application/`
- `port/out/`
  - `JogadorRepository.java` *(interface: contrato para obter jogadores e suas equipes)*
- `service/`
  - `JogadorService.java` *(casos de uso: montar jogadores e equipes)*

### `adapter/`
- `in/`
  - `Main.java` *(menu, leitura do teclado e prints)*
- `out/`
  - `JogadorMemoriaAdapter.java` *(implementa o repository: fabrica jogadores, equipes e personagens em memória)*