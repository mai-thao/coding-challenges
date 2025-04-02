import java.util.Scanner;

/**
 * Takes a size and a 2D array and rotate it counter clockwise,
 * in-place, without creating a new rotated array.
 * 
 * Example- 
 * 
 * INPUT:
 * size = 3
 * img  = 
 *    8 2 3
 *    2 9 1
 *    9 0 6
 * 
 * OUTPUT:
 *    3 1 6
 *    2 9 0
 *    8 2 9
 */

public class RotateImage {
    public static void rotate_image(int size, int[][] img) {
        if (size == 0) {
            return;
        }
        // transpose
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int temp = img[i][j];
                img[i][j] = img[j][i];
                img[j][i] = temp;
            }
        }
        // swap each column
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size / 2; i++) {
                int temp = img[i][j];
                img[i][j] = img[size - i - 1][j];
                img[size - i - 1][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.close();
        int[][] img = new int[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                img[i][j] = scanner.nextInt();
            }
        }
        rotate_image(size, img);
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                System.out.print(img[i][j]);

                if (j < size - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
