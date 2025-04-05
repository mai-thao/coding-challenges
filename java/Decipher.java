package java;
import java.util.Scanner;

/**
 * Takes an encrypted string and returns the original, unencrypted string.
 * 
 * First, find the shift amount and if using that amount aligns with the
 * original "knownWord" input string then that is the correct amount and
 * the string can be unencrypted successfully. Otherwise, the encrypted
 * string cannot be deciphered.
 * 
 * Example-
 * INPUT:
 *     ciphertext = "Eqfkpi vguvu ctg hwp!"
 *     knownWord = "tests"
 * 
 * OUTPUT:
 *    "Coding tests are fun!"
 */
public class Decipher {
    public static String decipher(String ciphertext, String knownWord) {
        int shiftAmt = findShiftAmt(ciphertext, knownWord);
        if (shiftAmt == -1) {
            return "Invalid";
        }
        StringBuilder cipheredText = new StringBuilder();
        for (char letter : ciphertext.toCharArray()) {
            if (Character.isLetter(letter)) {
                char baseLetter = Character.isUpperCase(letter) ? 'A' : 'a';
                int shiftedVal = (letter - baseLetter - shiftAmt);
                char newLetter = (char) (Math.floorMod(shiftedVal, 26) + baseLetter);
                cipheredText.append(newLetter);
            } else {
                cipheredText.append((letter));
            }
        }
        return cipheredText.toString();
    }

    public static int findShiftAmt(String ciphertext, String knownWord) {
        int knownWorldLength = knownWord.length();

        String[] words = ciphertext.split(" ");

        for (String word : words) {
            if (word.length() == knownWorldLength) {
                int shift = calcShiftAmt(knownWord.charAt(0), word.charAt(0));
                boolean consistent = true;

                for (int i = 1; i < knownWorldLength; i++) {
                    int currentShift = calcShiftAmt(knownWord.charAt(i), word.charAt(i));
                    if (currentShift != shift) {
                        consistent = false;
                        break;
                    }
                }
                if (consistent) {
                    return shift;
                }
            }
        }
        return -1;
    }

    public static int calcShiftAmt(char knownChar, char unknownChar) {
        return (unknownChar - knownChar + 26) % 26;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ciphertext = scanner.nextLine();
        String knownWord = scanner.nextLine();
        scanner.close();

//        String ciphertext = "Eqfkpi vguvu ctg hwp!"; // Coding tests are fun!
//        String knownWord = "tests";
//
//        String ciphertext = "cdeb nqxg"; // abcz love
//        String knownWord = "love";
//
//        String ciphertext = "Eqfkpi vguvu ctg hwp cpf ejcnngpikpi!"; // abcz love
//        String knownWord = "are";

        String result = decipher(ciphertext, knownWord);
        System.out.println(result);
    }
}
