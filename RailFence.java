import java.util.*;

class RailFence {

    static String encrypt(String s, int r) {
        StringBuilder[] rail = new StringBuilder[r];

        for (int i = 0; i < r; i++)
            rail[i] = new StringBuilder();

        int row = 0, dir = 1;

        for (char c : s.toCharArray()) {
            rail[row].append(c);

            if (row == 0) dir = 1;
            if (row == r - 1) dir = -1;

            row += dir;
        }

        String ans = "";
        for (StringBuilder x : rail)
            ans += x;

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter rails: ");
        int rails = sc.nextInt();

        System.out.println("Encrypted: " + encrypt(text, rails));
    }
}
