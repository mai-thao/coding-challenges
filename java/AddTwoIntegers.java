public class AddTwoIntegers {
    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static String stringSum(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
    }

    public static void main(String[] args) {
        System.out.println(sum(12, 5));     // 17
        System.out.println(sum(-10, 4));    // -6
        System.out.println(sum(-456, 77));  // -533
        System.out.println(sum(0, 0));      // 0

        System.out.println();

        System.out.println(stringSum("12", "5"));      // 17
        System.out.println(stringSum("-10", "4"));     // -6
        System.out.println(stringSum("-456", "77"));   // 533
        System.out.println(stringSum("0", "0"));       // 0
    }
}
