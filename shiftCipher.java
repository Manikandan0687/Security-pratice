import java.util.Scanner;

public class ShiftCipher {

    // Encrypts text using a traditional for loop
    public static String encrypt(String plaintext, int key) {
        String ciphertext = "";
        
        // Normalize key to handle large or negative numbers safely
        key = (key % 26 + 26) % 26;

        // Traditional indexed for loop
        for (int i = 0; i < plaintext.length(); i++) {
            char current = plaintext.charAt(i);

            if (Character.isUpperCase(current)) {
                // Calculate position (0-25), shift, wrap around, convert back to char
                char encryptedChar = (char) (((current - 'A' + key) % 26) + 'A');
                ciphertext += encryptedChar;
            } else if (Character.isLowerCase(current)) {
                // Same logic for lowercase letters
                char encryptedChar = (char) (((current - 'a' + key) % 26) + 'a');
                ciphertext += encryptedChar;
            } else {
                // Keep spaces, punctuation, and numbers as they are
                ciphertext += current;
            }
        }
        return ciphertext;
    }

    // Decrypts text by reversing the shift direction
    public static String decrypt(String ciphertext, int key) {
        String plaintext = "";
        key = (key % 26 + 26) % 26;

        // Traditional indexed for loop
        for (int i = 0; i < ciphertext.length(); i++) {
            char current = ciphertext.charAt(i);

            if (Character.isUpperCase(current)) {
                // Subtract key, add 26 to prevent negative results before modulo
                char decryptedChar = (char) (((current - 'A' - key + 26) % 26) + 'A');
                plaintext += decryptedChar;
            } else if (Character.isLowerCase(current)) {
                // Same logic for lowercase letters
                char decryptedChar = (char) (((current - 'a' - key + 26) % 26) + 'a');
                plaintext += decryptedChar;
            } else {
                // Leave spaces and symbols untouched
                plaintext += current;
            }
        }
        return plaintext;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Caesar/Shift Cipher Program ===");
        System.out.print("Enter your secret message: ");
        String message = scanner.nextLine();

        System.out.print("Enter shift key (e.g., 3 for Caesar): ");
        int key = scanner.nextInt();

        // Execution
        String encrypted = encrypt(message, key);
        String decrypted = decrypt(encrypted, key);

        // Output results
        System.out.println("\n=== Output ===");
        System.out.println("Original  : " + message);
        System.out.println("Encrypted : " + encrypted);
        System.out.println("Decrypted : " + decrypted);

        scanner.close();
    }
}

OUTPUT:
student@a4cse177:~$ javac ShiftCipher.java
student@a4cse177:~$ java ShiftCipher
=== Caesar/Shift Cipher Program ===
Enter your secret message: HELLO
Enter shift key (e.g., 3 for Caesar): 3

=== Output ===
Original  : HELLO
Encrypted : KHOOR
Decrypted : HELLO
