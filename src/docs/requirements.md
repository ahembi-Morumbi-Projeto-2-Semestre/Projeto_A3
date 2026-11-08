
# 📋 Requisitos Funcionais

Abaixo estão listados os requisitos funcionais do sistema, divididos por categorias para facilitar a leitura e o acompanhamento do projeto:

## 👥 Configuração e Personagens
- **`RF01`** O sistema deverá permitir a participação de dois jogadores em uma batalha.
- **`RF02`** O sistema deverá permitir que cada jogador possua uma equipe composta por exatamente dois personagens.
- **`RF03`** O sistema deverá permitir a criação e identificação dos personagens por meio de seus nomes.
- **`RF04`** O sistema deverá atribuir a cada personagem valores de pontos de vida, ataque e defesa.

## ⚔️ Mecânicas de Combate
- **`RF05`** O sistema deverá permitir que os jogadores realizem ataques individuais contra um personagem adversário.
- **`RF06`** O sistema deverá permitir que os jogadores realizem ataques em grupo contra os dois personagens adversários simultaneamente. *(Obs: um personagem pode ter ataque único ou ataque em área)*.
- **`RF07`** O sistema deverá permitir que os jogadores utilizem defesa individual para proteger um personagem.
- **`RF08`** O sistema deverá permitir que os jogadores utilizem defesa em grupo para proteger os dois personagens da equipe.
- **`RF09`** O sistema deverá calcular o dano causado pelos ataques considerando os atributos de ataque e defesa dos personagens envolvidos.
- **`RF10`** O sistema deverá reduzir o dano recebido pelo personagem protegido por uma ação defensiva.

## ⏳ Turnos e Status de Vida
- **`RF11`** O sistema deverá alternar os turnos entre os dois jogadores, permitindo apenas uma ação por turno. *(Parametrizável)*.
- **`RF12`** O sistema deverá impedir que personagens eliminados realizem ações de ataque ou defesa.
- **`RF13`** O sistema deverá atualizar os pontos de vida dos personagens após cada ataque recebido.
- **`RF14`** O sistema deverá impedir que os pontos de vida dos personagens assumam valores negativos.

## 🏆 Condições de Vitória e Fim de Jogo
- **`RF15`** O sistema deverá identificar quando os dois personagens de uma equipe forem eliminados.
- **`RF16`** O sistema deverá declarar como vencedor o jogador que eliminar os dois personagens da equipe adversária.
- **`RF21`** O sistema deverá encerrar a partida quando uma das equipes não possuir mais personagens vivos.

## 🖥️ Interface e Feedback (Terminal)
- **`RF17`** O sistema deverá apresentar no terminal as equipes e os personagens participantes da batalha.
- **`RF18`** O sistema deverá exibir os pontos de vida atualizados dos personagens durante a partida.
- **`RF19`** O sistema deverá apresentar as ações disponíveis para o jogador durante seu turno.
- **`RF20`** O sistema deverá informar os resultados de cada ação realizada, incluindo danos causados e personagens eliminados.