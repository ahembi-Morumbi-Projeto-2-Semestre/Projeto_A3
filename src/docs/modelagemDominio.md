# 🗺️ Modelagem de Domínio

Documento gerado a partir das classes. Descreve as entidades, seus atributos, comportamentos e relacionamentos dentro da arquitetura hexagonal do projeto.

---

## Diagrama de Relacionamentos

```
Batalha
 ├── Jogador (jogador1)
 │    └── Equipe
 │         └── List<Personagem>  ←── abstract
 │                └── List<Habilidade>  ←── interface
 │                         └── Porrada (implementação concreta)
 └── Jogador (jogador2)
      └── Equipe
           └── List<Personagem>
```

---

## Entidades do Domínio

### `Personagem` *(abstract — domain/personagem)*

Representa um combatente dentro de uma equipe. É abstrata porque tipos específicos de personagem (ex: Guerreiro, Feiticeiro) devem estendê-la.

| Atributo | Tipo | Descrição |
|---|---|---|
| `nome` | `String` | Nome identificador do personagem |
| `pontosDeVida` | `int` | HP atual; chegar a 0 elimina o personagem |
| `pontosAtaque` | `int` | Multiplicador de dano nas habilidades |
| `pontosDefesa` | `int` | Base de defesa passiva do personagem |
| `defesaAtual` | `int` | Defesa temporária acumulada por ações de proteção no turno |
| `tipoPersonagem` | `String` | Rótulo do tipo (ex: "Guerreiro", "Feiticeiro") |
| `desc` | `String` | Descrição narrativa do personagem |
| `habilidades` | `List<Habilidade>` | Conjunto de habilidades disponíveis para uso em combate |

**Comportamentos:**

- `estaVivo()` — retorna `true` se `pontosDeVida > 0`.
- `receberDano(int dano)` — subtrai `dano - defesaAtual` dos pontos de vida; o resultado nunca fica negativo (RF14).
- `receberProtecao(int protecao)` — incrementa `defesaAtual`, acumulando proteções recebidas no turno (RF07/RF08).
- `adicionarHabilidade(List<Habilidade>)` — carrega a lista de habilidades do personagem.

---

### `Habilidade` *(interface — domain/personagem/habilidades)*

Contrato que toda habilidade de combate deve implementar.

| Método | Retorno | Descrição |
|---|---|---|
| `getPontos()` | `int` | Valor base da habilidade (multiplicado pelo ataque de origem) |
| `habilidade(List<Personagem> alvos, Personagem origem)` | `void` | Executa o efeito da habilidade sobre os alvos |

A assinatura com `List<Personagem>` suporta tanto ataques individuais (lista de 1 elemento) quanto ataques em área (lista com múltiplos alvos), cobrindo RF05 e RF06.

---

### `Porrada` *(implements Habilidade — domain/personagem/habilidades)*

Habilidade de dano físico. Implementação concreta atual de `Habilidade`.

| Constante | Valor | Descrição |
|---|---|---|
| `PONTOS` | `10` | Valor base fixo de dano |

**Comportamento:**  
Calcula `dano = PONTOS × pontosAtaque(origem)` e chama `receberDano(dano)` em cada alvo da lista (RF05, RF06, RF09).

---

### `Equipe` *(domain/jogador)*

Agrupa os personagens de um jogador.

| Atributo | Tipo | Descrição |
|---|---|---|
| `nome` | `String` | Nome da equipe |
| `personagems` | `List<Personagem>` | Personagens que compõem a equipe (máx. 2 — RF02) |

**Comportamentos:**

- `adcionarPersonagemNaEquipe(Personagem)` — adiciona personagem respeitando o limite de 2 (RF02).
- `equipeEstaDerrotada()` — retorna `true` se nenhum personagem estiver vivo, disparando RF15/RF21.

---

### `Jogador` *(domain/jogador)*

Representa um dos dois participantes da batalha (RF01).

| Atributo | Tipo | Descrição |
|---|---|---|
| `nome` | `String` | Nome do jogador |
| `equipe` | `Equipe` | Equipe sob controle do jogador |

**Comportamentos:**

- `realizarAcao(pOrigem, List<pAlvos>, habilidade)` — executa habilidade em múltiplos alvos (ataque em área — RF06).
- `realizarAcao(pOrigem, pAlvo, habilidade)` — executa habilidade em um único alvo (ataque individual — RF05). Internamente converte para `List.of(pAlvo)`.
- `estaDerrotado()` — delega para `equipe.equipeEstaDerrotada()` (RF15).

---

### `Batalha` *(domain/batalha)*

Orquestra o estado geral do combate: turno atual, jogadores e condição de fim de jogo.

| Atributo | Tipo | Descrição |
|---|---|---|
| `jogador1` | `Jogador` | Primeiro participante |
| `jogador2` | `Jogador` | Segundo participante |
| `turnoAtual` | `int` | Número do turno em curso |
| `batalhaFinalizada` | `boolean` | Indica se a partida chegou ao fim |

**Comportamentos:**

- `inicar(int, int)` — inicializa a partida (a lógica de par/ímpar para definir quem começa fica aqui, no domínio — RF11).
- `executarPartida(pOrigem, pAlvos, habilidade, jOrigem)` — delega a ação ao jogador correto no turno (RF11).
- `finalizarBatalha()` — verifica se algum jogador foi derrotado e encerra a partida (RF16, RF21).

---

## Camadas de Suporte (Application e Adapter)

Não fazem parte do domínio, mas se relacionam diretamente com ele.

### `JogadorRepository` *(application/port/outbound)*
Interface de saída (porta hexagonal). Define o contrato para persistência de jogadores sem acoplar o domínio à infraestrutura.

| Método | Descrição |
|---|---|
| `adicionaJogador(Jogador)` | Registra um jogador no repositório |

### `JogadorService` *(application/service)*
Caso de uso: orquestra a criação e registro de jogadores, usando o `JogadorMemoriaAdapter` via injeção de dependência.

### `JogadorMemoriaAdapter` *(adapter/outbound)*
Implementa `JogadorRepository`. Mantém a lista de jogadores em memória (`ArrayList`). Substitui persistência real enquanto o projeto está em fase inicial.

### `main` *(adapter/inbound)*
Ponto de entrada da aplicação. Será responsável pelo menu, leitura do teclado e prints no terminal (RF17–RF20).

---
