/**
 * Given an integer `n`, render as ASCII art pyramid with `n` levels by printing
 * `n` rows of asteriks. The top row has a single asterisk in the center and each
 * successive row has two additional asteriks on either side.
 *
 * Time complexity: O(n^2) because nested loops where first loop visits each row, and 2 inner loops does work on each row (print space & print stars)
 * Space complexity: O(1) because no extra dataset or memory used
 */
public class PrintAsciiArt {
    public static void renderArt(int n) {
        // Loop through each row
        for (int i = 1; i <= n; i++) {
            // Print spaces (aka move star to middle)
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            // Print stars (aka expand triangle shape row by row)
            for (int k = 0; k < (2 * i - 1); k++) {
                System.out.print("*");
            }

            // Move to next row
            System.out.println();
        }
    }

    public static void main(String[] args) {
        renderArt(0);
        renderArt(1);
        renderArt(3);
        renderArt(5);
        renderArt(10);
    }
}
