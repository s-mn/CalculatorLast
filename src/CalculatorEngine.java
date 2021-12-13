public class CalculatorEngine {

    /**
     * @param numberOne первый операнд
     * @param numberTwo второй операнд
     * @param sign знак операции
     * @return результат выражения
     */

    public static int calculate (int numberOne, int numberTwo, String sign) {
        int result = 0;
        switch (sign) {
            case "+":
                result = numberOne + numberTwo;
                break;
            case "-":
                result = numberOne - numberTwo;
                break;
            case "*":
                result = numberOne * numberTwo;
                break;
            case "/":
                try {
                    result = numberOne / numberTwo;
                } catch (ArithmeticException e) {
                    System.out.println("Делить на ноль нельзя : " + e);
                    System.exit(1);
                }
        } return result;
    }
}