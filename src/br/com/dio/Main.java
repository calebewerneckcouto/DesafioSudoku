package br.com.dio;

import static br.com.dio.util.BoardTemplate.BOARD_TEMPLATE;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import br.com.dio.model.Board;
import br.com.dio.model.Space;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static Board board;
    private static final int BOARD_LIMIT = 9;

    public static void main(String[] args) {
        final var positions = Stream.of(args)
                .collect(toMap(
                        k -> k.split(";")[0],
                        v -> v.split(";")[1]
                ));

        while (true) {
            System.out.println("Selecione uma das opções a seguir");
            System.out.println("1 - Iniciar um novo Jogo");
            System.out.println("2 - Colocar um novo número");
            System.out.println("3 - Remover um número");
            System.out.println("4 - Visualizar jogo atual");
            System.out.println("5 - Verificar status do jogo");
            System.out.println("6 - Limpar jogo");
            System.out.println("7 - Finalizar jogo");
            System.out.println("8 - Sair");

            int option = scanner.nextInt();
            switch (option) {
                case 1 -> startGame(positions);
                case 2 -> inputNumber();
                case 3 -> removeNumber();
                case 4 -> showCurrentGame();
                case 5 -> showGameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                case 8 -> System.exit(0);
                default -> System.out.println("Opção inválida, selecione uma das opções do menu");
            }
        }
    }

    private static void startGame(final Map<String, String> positions) {
        if (nonNull(board)) {
            System.out.println("O jogo já foi iniciado");
            return;
        }

        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {
                String key = "%s,%s".formatted(i, j);
                String positionConfig = positions.getOrDefault(key, "0,false"); // Define valores padrão

                try {
                    String[] configParts = positionConfig.split(",");
                    int expected = Integer.parseInt(configParts[0]);
                    boolean fixed = Boolean.parseBoolean(configParts[1]);
                    spaces.get(i).add(new Space(expected, fixed));
                } catch (Exception e) {
                    System.out.printf("Erro ao processar posição [%d,%d]: %s. Usando valores padrão.%n", i, j, positionConfig);
                    spaces.get(i).add(new Space(0, false)); // Define valores padrão em caso de erro
                }
            }
        }

        board = new Board(spaces);
        System.out.println("O jogo está pronto para começar");
    }


    private static void inputNumber() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        int col = getInput("Informe a coluna (0-8):", 0, 8);
        int row = getInput("Informe a linha (0-8):", 0, 8);
        int value = getInput("Informe o número (1-9):", 1, 9);
        
        if (!board.changeValue(col, row, value)) {
            System.out.printf("A posição [%s,%s] tem um valor fixo\n", col, row);
        }
    }

    private static void removeNumber() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        int col = getInput("Informe a coluna (0-8):", 0, 8);
        int row = getInput("Informe a linha (0-8):", 0, 8);
        
        if (!board.clearValue(col, row)) {
            System.out.printf("A posição [%s,%s] tem um valor fixo\n", col, row);
        }
    }

    private static void showCurrentGame() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        Object[] args = new Object[81];
        int argPos = 0;
        for (int i = 0; i < BOARD_LIMIT; i++) {
            for (var col : board.getSpaces()) {
                args[argPos++] = " " + (isNull(col.get(i).getActual()) ? " " : col.get(i).getActual());
            }
        }
        System.out.println("Seu jogo se encontra da seguinte forma");
        System.out.printf(BOARD_TEMPLATE + "\n", args);
    }

    private static void showGameStatus() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        System.out.printf("Status do jogo: %s\n", board.getStatus().getLabel());
        System.out.println(board.hasErrors() ? "O jogo contém erros" : "O jogo não contém erros");
    }

    private static void clearGame() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        System.out.println("Tem certeza que deseja limpar seu jogo? (sim/não)");
        if (scanner.next().equalsIgnoreCase("sim")) {
            board.reset();
        }
    }

    private static void finishGame() {
        if (isNull(board)) {
            System.out.println("O jogo ainda não foi iniciado");
            return;
        }

        if (board.gameIsFinished()) {
            System.out.println("Parabéns, você concluiu o jogo!");
            showCurrentGame();
            board = null;
        } else {
            System.out.println(board.hasErrors() ? "O jogo contém erros!" : "Você ainda precisa preencher alguns espaços.");
        }
    }

    private static int getInput(String message, int min, int max) {
        System.out.println(message);
        int value;
        do {
            value = scanner.nextInt();
            if (value < min || value > max) {
                System.out.printf("Informe um número entre %d e %d\n", min, max);
            }
        } while (value < min || value > max);
        return value;
    }
}