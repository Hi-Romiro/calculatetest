import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение:");
        String input = scanner.nextLine();
        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println("throws Exception");
        }
    }

    public static String calc(String input) throws Exception {
        input = input.trim();  // лишние пробелы по бокам
        String[] tokens = input.split(" "); // разбиваем по пробелам

        // проверка на формат
        if (tokens.length != 3) {
            throw new Exception("Некорректный формат ввода");
        }

        int a, b;
        try {
            a = Integer.parseInt(tokens[0]);
            b = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Введены некорректные числа");
        }

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Числа должны быть в диапазоне от 1 до 10");
        }

        String operator = tokens[1]; // выполняем операцию
        int result;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new Exception("Деление на ноль");
                }
                result = a / b;
                break;
            default:
                throw new Exception("Некорректный оператор");
        }

        return String.valueOf(result); // результат в виде строки
    }
}