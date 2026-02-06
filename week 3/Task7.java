import java.util.*;

public class Task7 {

    public static int NthPrime(int input1) {
        int count = 0; 
        int number = 2; 

        while (true) {
            if (isPrime(number)) {
                count++;
                if (count == input1) {
                    return number; 
                }
            }
            number++;
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        if (num == 2)
            return true;
        if (num % 2 == 0)
            return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        System.out.println(NthPrime(n));

        sc.close();
    }
}
