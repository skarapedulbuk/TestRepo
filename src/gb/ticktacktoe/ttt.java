package gb.ticktacktoe;

/*
   1.  Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать.
   2.  Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов. Необходимо учесть, что такая проверка должна быть универсальной для любого размера поля, 1х1, 5х5, 100х100 и так далее.
   3.  * Попробовать переписать логику проверки победы, чтобы она работала для поля 3х3 и 5х5. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
   4.  *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
*/

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ttt {
    /*
    Приветствую, Максим! Спасибо за хорошую подачу материала на лекциях!
    Я планирую еще поработать над данным кодом, а именно, что бы AI не только блокировал ходы, но и старался выиграть.
    Поэтому код получился несколько избыточным, в тех местах, где я это заметил, я отметил комментами.
    К сожалению, времени сейчас исправить недочеты нет, но код полностью рабочий, на поле 5х5 AI непобедим (вроде:))
    Прошу сильно за это не ругаться и учитывать при выставлении оценки за домашнее задание. Спасибо!
     */
    public static void main(String[] args) {
        start();
    }
    static void start() {
        Scanner scanner =  new Scanner(System.in);
        int fieldSize;
        do {
            System.out.println("Введите размер поля");
            fieldSize = scanner.nextInt();
        } while (fieldSize <= 0);
        char[][] field = createField(fieldSize);
        int[] lastPlayerMove;
        int[] lastAIMove;
        do {
            lastPlayerMove = doPlayerMove(field);
            drawField(field);
            //         System.out.println("Your last move: " + (lastMove[0]+1) + " " + (lastMove[1]+1));
            if (isWin(field, lastPlayerMove,'X')) {
                System.out.println("Поздравляю, ты победил!");
                break;
            }
            if (isDraw(field)) {
                System.out.println("Ничья после твоего хода");
                break;
            }
            lastAIMove = doAIMove(field, lastPlayerMove);
            drawField(field);
            if (isWin(field, lastAIMove,'O')) {
                System.out.println("Ты проиграл!!! Я победил! Ура!");
                break;
            }
            if (isDraw(field)) {
                System.out.println("Ничья после моего хода");
                break;
            }
        } while (true);
    }

    static char[][] createField(int size) {
        char[][] array = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = '-';
            }

        }
        drawField(array);
        return array;
    }
    static void drawField(char[][] field) {
        for (char[] chars : field) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(chars[j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println();
    }

    static int getCoordinate(int lastIndex, char coordName) {
        Scanner scanner = new Scanner(System.in);
        int coord;
        do {
            System.out.printf("Please enter %s-coordinate ... [1-3]%n", coordName);
            coord = scanner.nextInt() - 1;
        } while (coord < 0 || coord > lastIndex);
        return coord;
    }
    static int[] doPlayerMove(char[][] field) {
        int h, v;
        do {
            h = getCoordinate(field.length - 1, 'h');
            v = getCoordinate(field.length - 1, 'v');
        } while (isNotFreeCell(field, h, v));

        field[h][v] = 'X';
        return new int[] {h, v};
    }
    static int[] doRandomAIMove (char[][] field) {
        int h, v;
        Random random = new Random();
        System.out.println("Здесь мог бы быть осознанный ход туда, где у меня предвыигрышная ситуация, но будет абсолютно случайный ход!");
        do {
            h = random.nextInt(field.length);
            v = random.nextInt(field.length);
        } while (isNotFreeCell(field, h, v));
        return new int[]{h, v};
    }

    // Следующие три метода позднее будут объединены в один.
    static boolean isFreeCell(char[][] field, int h, int v) {
        return field[h][v] == '-';
    }
    static boolean isNotFreeCell(char[][] field, int h, int v) {
        return !isFreeCell(field, h, v);
    }
    static boolean isXOCell(char[][] field, int h, int v,char symbol) {
        return field[h][v] == symbol;
    }

    static boolean isDraw(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (isFreeCell(field, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isWin(char[][]field, int[] turn, char symbol) {
        return countV(field, turn, symbol) == field.length ||
                countH(field, turn, symbol) == field.length ||
                countDiag1(field, turn, symbol) == field.length ||
                countDiag2(field, turn, symbol) == field.length;
    }

    static int countDiag1 (char[][] field, int[] turn, char symbol) { // Параметр turn планируется использовать позднее при доработке AI
        int counter=0;
        for (int i = 0; i < field.length; i++) {
            if (field[i][i] == symbol) {
                counter++;
            }
        }
        return counter;
    }
    static int countDiag2 (char[][] field, int[] turn, char symbol) { // Параметр turn планируется использовать позднее при доработке AI
        int counter=0;
        for (int i = 0; i < field.length; i++) {
            if (field[i][field.length-i-1] == symbol) {
                counter++;
            }
        }
        return counter;
    }

    static int countH(char[][] field, int[] turn, char symbol) {
        int counter = 0;
        for (int i = 0; i < field.length; i++) {
            if (isXOCell(field, i, turn[1], symbol)) {
                counter++;
            }
        }
        return counter;
    }
    //    static int countHH(char[][] field, int[] turn, char symbol) {
    //    return (int) IntStream.range(0, field.length).filter(i -> isXOCell(field, i, turn[1], symbol)).count();
    //}
    static int countV(char[][] field, int[] turn, char symbol) { // Использование лямбда выражений
        return (int) IntStream.range(0, field.length).filter(i -> isXOCell(field, turn[0], i, symbol)).count();
    }

    static int doDetectDangerLine (char[][] field, int[] turn, char mySymbol, char yourSymbol) {
        // Параметры mySymbol и yourSymbol планируется использовать позднее при доработке AI
        int[] maxX = new int[5];
        int indexMax = 4;
        if (countV(field, turn, mySymbol) == 0 && countV(field, turn, '-') > 0) {
            maxX[0]= countV(field, turn,yourSymbol);
        }
        if (countH(field, turn, mySymbol) == 0 && countH(field, turn, '-') > 0) {
            maxX[1]= countH(field, turn,yourSymbol);
        }
        if (countDiag1(field, turn, mySymbol) == 0 && countDiag1(field, turn, '-') > 0) {
            maxX[2]=countDiag1(field, turn,yourSymbol);
        }
        if (countDiag2(field, turn, mySymbol) == 0 && countDiag2(field, turn, '-') > 0) {
            maxX[3]=countDiag2(field, turn,yourSymbol);
        }
        for (int i = 0; i < maxX.length; i++) {
            if (maxX[i]>maxX[indexMax]) {
                indexMax = i;
            }
        }
        return indexMax;
    }
    static int[] doAIMove(char[][] field, int[] turn) { // Можно было использовать void, планируется использовать позднее при доработке AI
        System.out.println("Твой ход был "+ (turn[0]+1) + " " + (turn[1]+1));
        int[] move = new int[2];
        int dangerLine = doDetectDangerLine(field, turn, 'O','X');
        Random random = new Random();
        switch (dangerLine) {
            case 0:
                System.out.println("Блокирую горизонтальную линию " + (turn[0] + 1));
                do {
                    move[0] = turn[0];
                    move[1] = random.nextInt(field.length);
                } while (isNotFreeCell(field, move[0], move[1]));
                break;
            case 1:
                System.out.println("Блокирую вертикальную линию " + (turn[1] + 1));
                do {
                    move[0] = random.nextInt(field.length);
                    move[1] = turn[1];
                } while (isNotFreeCell(field, move[0], move[1]));
                break;
            case 2:
                System.out.println("Блокирую диагональную линию 1");
                do {
                    move[1] = move[0] = random.nextInt(field.length);
                } while (isNotFreeCell(field, move[0], move[1]));
                break;
            case 3:
                System.out.println("Блокирую диагональную линию 2");
                do {
                    move[0] = random.nextInt(field.length);
                    move[1] = field.length - move[0] - 1;
                } while (isNotFreeCell(field, move[0], move[1]));
                break;
            default:
                move = doRandomAIMove(field);
                break;
        }
        System.out.printf("Мой ход %s %s %n",move[0]+1,move[1]+1);
        field[move[0]][move[1]] = 'O';
        return new int[] {move[0],move[1]};
    }
}
