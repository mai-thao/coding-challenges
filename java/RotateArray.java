package java;
import java.util.Scanner;

/**
 * Takes a size and a 2D array and rotate it counter clockwise,
 * in-place, without creating a new rotated array.
 * 
 * Example- 
 * 
 * INPUT:
 * size = 3
 * arr  = 
 *    8 2 3
 *    2 9 1
 *    9 0 6
 * 
 * OUTPUT:
 *    3 1 6
 *    2 9 0
 *    8 2 9
 */

public class RotateArray {
    public static void rotate_arr(int size, int[][] arr) {
        if (size == 0) {
            return;
        }
        // transpose
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        // swap each column
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size / 2; i++) {
                int temp = arr[i][j];
                arr[i][j] = arr[size - i - 1][j];
                arr[size - i - 1][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.close();
        int[][] arr = new int[size][size];
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                arr[i][j] = scanner.nextInt();
            }
        }
        rotate_arr(size, arr);
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                System.out.print(arr[i][j]);

                if (j < size - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
