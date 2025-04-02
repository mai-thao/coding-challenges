import java.util.Scanner;

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
