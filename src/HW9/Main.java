package HW9;


/*
 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
 При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
 и вывести результат расчета.
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("=HW9=");
        String[][] array = generateArray();

        try {
            calculateSumm(array);
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static String[][] generateArray() {
        String[][] array = new String[4][4];
        array[0][0] = "123";
        array[0][1] = "23";
        array[0][2] = "12";
        array[0][3] = "1";
        array[1][0] = "3";
        array[1][1] = "111";
        array[1][2] = "1";
        array[1][3] = "123";
        array[2][0] = "33";
        array[2][1] = "4";
        array[2][2] = "11";
        array[2][3] = "5";
        array[3][0] = "7";
        array[3][1] = "9";
        array[3][2] = "0";
        array[3][3] = "1";
        return array;
    }

    public static void calculateSumm(String[][] array) throws MyArraySizeException, MyArrayDataException {
        for (String[] strings : array) {
            if (array.length != 4 || strings.length != 4) {
                throw new MyArraySizeException("Ошибка размера массива");
            }

        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException("Ошибка преобразования в число в ячейке " + i + " " + j, exception);
                }
            }
        }
        System.out.println("Сумма всех элементов массива = " + sum);
    }

    public static class MyArrayDataException extends RuntimeException {
        public MyArrayDataException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(String message) {
            super(message);
        }
    }
}
