import java.util.Scanner;

public class Main {

    public static String calc(String input) throws Exception{
        String result;
        String[] split = input.split(" ");
        if (split.length < 3) {
            throw new Exception("Строка не является математической операцией");
        } else if (split.length > 3){
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        String oper = split[1];
        int val1 = Integer.parseInt(split[0]);
        int val2 = Integer.parseInt(split[2]);

        return basicMath(oper, val1, val2);
    }

    public static String basicMath(String op, int v1, int v2) throws Exception {
        int result = switch (op) {
            case "+" -> v1 + v2;
            case "-" -> v1 - v2;
            case "*" -> v1 * v2;
            case "/" -> v1 / v2;

            default -> throw new Exception("Вы ввели не верный арифметический оператор");
        };

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println("Вас приветствует калькулятор." +
                "\nКалькулятор умеет выполнять операции:" +
                "\nсложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b" +
                "\nДанные передаются в одну строку с пробелами.");
        String input = new Scanner(System.in).nextLine();
        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}