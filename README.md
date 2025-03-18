# Jogo de Sudoku - Desafio DIO (8x8)

Este projeto é um jogo de Sudoku desenvolvido em Java com um tabuleiro de 8x8. O objetivo é fornecer uma experiência interativa para o usuário, permitindo que ele inicie, modifique e finalize um jogo de Sudoku diretamente pelo console. A implementação também permite ler um tabuleiro a partir de um arquivo e verificar se o jogo contém erros.

## Descrição

O jogo de Sudoku é um jogo de lógica baseado em uma grade 8x8, onde o objetivo é preencher os espaços vazios com números de 1 a 8, respeitando as seguintes regras:
- Cada linha deve conter os números de 1 a 8, sem repetições.
- Cada coluna deve conter os números de 1 a 8, sem repetições.
- Cada uma das oito subgrades 4x4 deve conter os números de 1 a 8, sem repetições.

Este projeto permite interagir com o jogo de forma simples e intuitiva, com as seguintes funcionalidades:

- Iniciar um novo jogo.
- Colocar um número em uma posição específica.
- Remover um número de uma posição.
- Visualizar o jogo atual.
- Verificar o status do jogo.
- Limpar o tabuleiro.
- Finalizar o jogo e verificar se está completo e sem erros.

## Funcionalidades

- **Iniciar Jogo:** Cria um novo tabuleiro 8x8.
- **Colocar um Novo Número:** Permite adicionar um número em uma posição específica do tabuleiro.
- **Remover um Número:** Permite remover um número de uma posição específica.
- **Visualizar Jogo Atual:** Exibe o estado atual do jogo no console.
- **Verificar Status do Jogo:** Informa se o jogo contém erros ou se está concluído.
- **Limpar Jogo:** Reseta o tabuleiro.
- **Finalizar Jogo:** Verifica se o jogo foi concluído corretamente.

## Pré-requisitos

- JDK 11 ou superior.

## Instalação

### Clonando o repositório

```bash
git clone https://github.com/seu-usuario/sudoku-game.git
cd sudoku-game
Compilação e Execução
Compile o código Java:

Caso esteja utilizando um terminal:


javac -d bin src/br/com/dio/Main.java
Execute o código compilado:

Após a compilação, execute o jogo com:


java -cp bin br.com.dio.Main
Ou, caso queira passar um arquivo de configuração como argumento para o jogo, execute:


java -cp bin br.com.dio.Main "posicao1;1,false" "posicao2;1,false" ...
Estrutura do Projeto
src/: Contém o código-fonte do jogo.

br/com/dio/: Pacote principal contendo as classes do jogo.
br/com/dio/model/: Contém as classes Board e Space, que representam o tabuleiro e as células do jogo, respectivamente.
br/com/dio/util/: Contém o template de exibição do tabuleiro.
bin/: Diretório gerado após a compilação, onde os arquivos .class serão armazenados.

Como Jogar
Execute o programa.
Escolha a opção desejada:
Iniciar um novo jogo.
Colocar um número em uma posição.
Remover um número de uma posição.
Visualizar o jogo atual.
Verificar o status do jogo.
Limpar o tabuleiro.
Finalizar o jogo.
Exemplo de Execução
Quando você iniciar o jogo, verá o seguinte menu:


Selecione uma das opções a seguir
1 - Iniciar um novo Jogo
2 - Colocar um novo número
3 - Remover um número
4 - Visualizar jogo atual
5 - Verificar status do jogo
6 - Limpar jogo
7 - Finalizar jogo
8 - Sair
Escolha a opção desejada digitando o número correspondente.

Contribuindo
Contribuições são bem-vindas! Se você deseja melhorar este projeto, fique à vontade para fazer um fork e enviar um pull request.

Licença
Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para mais detalhes.



### Notas:
- **Tabuleiro 8x8:** O jogo foi adaptado para trabalhar com um tabuleiro 8x8, e o número máximo de 8 foi configurado para o Sudoku.
- **Comandos:** Você pode ajustar o funcionamento do jogo conforme o esperado para um tabuleiro 8x8.

Agora, o README está pronto para ser usado em seu repositório!
