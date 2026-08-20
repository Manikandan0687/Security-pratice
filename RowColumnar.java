import java.util.*;

class RowColumnar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine().replace(" ", "").toUpperCase();

        System.out.print("Enter key: ");
        String key = sc.nextLine().toUpperCase();

        int col = key.length();
        int row = (int)Math.ceil((double)text.length() / col);
        char[][] m = new char[row][col];

        int k = 0;

        // Fill row-wise
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                m[i][j] = k < text.length() ? text.charAt(k++) : 'X';

        // Read columns
        String enc = "";
        for(int j=0;j<col;j++)
            for(int i=0;i<row;i++)
                enc += m[i][j];

        System.out.println("Encrypted: " + enc);
    }
}
