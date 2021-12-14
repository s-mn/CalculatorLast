public class Converter {
    /**
     * toArabic() конвертирует римское число в арабское
     * @param roman римское число в сканере
     * @return result возвращает римское число в арабской системе счисления
     * @throws Exception "Допустимый лимит значений для римской СС"
     */
    public static int toArabic(String roman) throws Exception {

        int[] intervals = {0, 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] numerals = {"", "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int result = 0;

        for (int i = intervals.length-1; i >= 0; i-- ) {
            while (roman.indexOf(numerals[i]) == 0 && numerals[i].length() > 0) {
                result += intervals[i];
                roman = roman.substring(numerals[i].length());
                if (result > 10) {
                    throw new Exception ("Римские числа только от I до X");
                }
            }
        } return result;
    }


    /**
     * toRoman() конвертирует арабское число в римское
     * @param number результат выражения в арабской системе счисления
     * @return result арабское число в римской системе счисления
     */
    public static String toRoman(int number) throws Exception {
        if (number == 0){
            throw new Exception("Ноль отсутствует в римской системе счисления");
        }

        Integer[] romanValueList = new Integer[] {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        String[] romanCharList = new String[]{
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        StringBuilder result = new StringBuilder();

        if (number < 0){
            System.out.println("В римской системе счисления нет отрицательных чисел.");
            System.exit(1);
        }

        for (int i = 0; i < romanValueList.length; i++)
        {
            while(number >= romanValueList[i])
            {
                number -= romanValueList[i];
                result.append(romanCharList[i]);
            }
        }
        return result.toString();
    }
}