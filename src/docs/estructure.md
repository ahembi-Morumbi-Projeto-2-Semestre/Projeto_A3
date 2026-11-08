## Estrutura de pacotes

### `domain/`
- `personagem/`
    - `Personagem.java` *(abstract)*
    - `Feiticeiro.java` *(e demais tipos: Guerreiro, ...)*
    - `TipoPersonagem.java` *(enum: Feiticeiro, ...)*
    - `Acao.java` *(enum: ACAO_UNICA, ACAO_AREA)*
- `batalha/`
    - `Batalha.java` *(era a Partida)*
    - `ResultadoTurno.java` *(sugestão: devolve o que aconteceu no turno)*
    - `Equipe.java`
    - `Jogador.java`

### `application/`
- `port/out/`
    - `PersonagemRepository.java` *(interface: contrato de acesso aos personagens)*
- `service/`
    - `ListarPersonagensService.java`
    - `IniciarBatalhaService.java` 

### `adapter/`
- `in/`
    - `Main.java` *(menu e prints)*
- `out/`
    - `PersonagemMemoriaAdapter.java` *(implementa o repository: fabrica os personagens e devolve a lista)*