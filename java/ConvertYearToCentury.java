/**
 * Given a year, return the century it is in.
 *
 * First century spans from year 1 up to and including year 100.
 * Second century spans from year 101 up to and including year 200, etc.
 *
 * Time complexity: O(1) because just basic arithmetic performing fixed number of arithmetic operations
 * Space complexity: O(1) because no extra data structure or memory needed
 */
public class ConvertYearToCentury {
    public static int centuryFromYear(int year) {
        if (year <= 0) {
            return -1;
        }
        return (int) Math.ceil((double) year / 100);
    }

    public static void main(String[] args) {
        System.out.println(centuryFromYear(-1000)); // -1
        System.out.println(centuryFromYear(1)); // 1/100 = 0.01 = ciel = 1
        System.out.println(centuryFromYear(101)); // 101/100 = 1.01 = ciel = 2
        System.out.println(centuryFromYear(300)); // 300 / 100 = 3 = ciel = 3
        System.out.println(centuryFromYear(1700)); // 1700 / 100 = 17 = ciel = 17
        System.out.println(centuryFromYear(1701)); // 1701 / 100 = 17.01 = ciel = 18
        System.out.println(centuryFromYear(1900)); // 1900 / 100 = 19 = ciel = 19
        System.out.println(centuryFromYear(1935)); // 1935 / 100 = 19.35 = ciel = 20
        System.out.println(centuryFromYear(2000)); // 2000 / 100 = 20 = ciel = 20
        System.out.println(centuryFromYear(2010)); // 2010 / 100 = 20.1 = ciel = 21
        System.out.println(centuryFromYear(2500)); // 2500 / 100 = 25 = ciel = 25
        System.out.println(centuryFromYear(2990)); // 2990 / 100 = 29.9 = ciel = 30
        System.out.println(centuryFromYear(2999)); // 2999 / 100 = 29.99 = ciel = 30
    }
}
