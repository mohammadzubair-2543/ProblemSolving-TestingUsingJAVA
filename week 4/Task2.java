import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();   
        while (T-- > 0) {
            String S = sc.nextLine();
            int n = S.length();

            int[] freq1 = new int[26];
            int[] freq2 = new int[26];

            int mid = n / 2;

            for (int i = 0; i < mid; i++) {
                freq1[S.charAt(i) - 'a']++;
            }

            int start = (n % 2 == 0) ? mid : mid + 1;

            for (int i = start; i < n; i++) {
                freq2[S.charAt(i) - 'a']++;
            }

            boolean isLapindrome = true;

            for (int i = 0; i < 26; i++) {
                if (freq1[i] != freq2[i]) {
                    isLapindrome = false;
                    break;
                }
            }

            if (isLapindrome)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        sc.close();
    }
}