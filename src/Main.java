import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {


        System.out.println("----------------------------------------------------");
        System.out.println("Калькулятор работает с римскими и арабскими числами.");
        System.out.println("Введите ваше выражение: ");


        /*
         * Здесь получаем строку из сканера
         * Очищаем строку от пробелов и добавляем в массив containerInitial[]
         */

        String wholeLine = scanner.nextLine(); //  ввод пользователя
        String[] containerInitial = wholeLine.split("[\s]+");


        /*
         * Снова переводим очищенный массив в строку для раздвоения на операнды
         * myNewString новая строка для валидации, с которой будем работать дальше
         */

        StringBuilder result = new StringBuilder();
        for (String s : containerInitial) {
            result.append(s);
        }
        String myNewString = result.toString();


        /*
         * Убираем все кроме знаков операции. IVX, потому что символы в римском формате повторяются
         * Получаем массив из двух элементов {"", "знак"}
         */

        String[] operators = myNewString.split("[:?´`^)(&%$§<>=,._#0-9IVX\s]+");

        /*
         * Проверка на лимит операторов, один допустим
         * Здесь происходит двойная проверка, если оператор один, то операндов два.
         * operators[1] = "знак"
         */

        if (operators.length > 2)
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        if (operators.length == 1 || operators.length == 0)
            throw new Exception("Недопустимые символы. Попробуйте еще раз.");
        String sign = operators[1];


        /*
         * Раздвоение выражения на два операнда
         */
        String[] operands = myNewString.split("[-+/*]");
        String a = operands[0]; // a первое число в выражении
        String b = operands[1]; // b второе число в выражении


        /*
         * Блок try catch
         * Сначала пытаемся привести операнды к int
         * Если не получается используем конвертер
         */

        try {
            if (Integer.parseInt(a) <= 10 & Integer.parseInt(b) <= 10) {

                int numberOne = Integer.parseInt(a);
                int numberTwo = Integer.parseInt(b);
                int resultArabic = CalculatorEngine.calculate(numberOne, numberTwo, sign);

                System.out.println("Результат: " + a + " " + sign + " " + b + " = " + resultArabic);

            }  else {
                System.out.println("Принимаются арабские числа только от 1 до 10 включительно. Попробуйте еще раз.");
                System.exit(1);
            }
        } catch (Exception formatRoman) {

            int numberOne = Converter.toArabic(a);
            int numberTwo = Converter.toArabic(b);

            if (numberOne == 0 || numberTwo == 0){
                throw new Exception ("Разные системы счисления. Калькулятор работает либо с арабскими, либо с римскими числами ");
            } else {

                int resultRoman = CalculatorEngine.calculate(numberOne, numberTwo, sign);
                String resultRomanConverted = Converter.toRoman(resultRoman);

                System.out.println("Результат: " + a + " " + sign + " " + b + " = " + resultRomanConverted);
            }
        }
    }
}
