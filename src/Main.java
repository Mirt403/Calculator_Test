import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Ввод выражения
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            System.out.println(calc(input));
        }
    }

    public static String calc(String input) throws IOException {

        // Разделение выражения на составляющие
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IOException();
        }

        // Все римские числа от 0 до 100
        // (первый пустой элемент добавлен для более удобной работы с индексами)
        String[] romanNumbers = {" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII",
                "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
                "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV",
                "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI",
                "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII",
                "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
                "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        int num1 = 0, num2 = 0;
        boolean isRoman = false;

        // Проверка, являются ли оба числа римскими от 1 до 10
        String romanRegex = "^(I|II|III|IV|V|VI|VII|VIII|IX|X)$";
        if (parts[0].matches(romanRegex) && parts[2].matches(romanRegex)) {
            isRoman= true;
            // Перевод римских чисел в арабские
            for (int i = 1; i <= 10; i++) {
                if (parts[0].equals(romanNumbers[i])) {
                    num1 = i;
                }
                if (parts[2].equals(romanNumbers[i])) {
                    num2 = i;
                }
            }
        }
        else {
            // Проверка, являются ли оба числа арабскими
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[2]);


            // Проверка арабских чисел на величину от 1 до 10
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new IOException();
            }
        }

        int result;

        // Выполнение вычислений
        switch (parts[1]) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "/" -> result = num1 / num2;
            case "*" -> result = num1 * num2;
            default -> throw new IOException();
        }


        if (isRoman) {
            if (result > 0) {
                return romanNumbers[result];
            }
            else {
                throw new IOException();
            }
        }

        return String.valueOf(result);
    }
}