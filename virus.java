import java.math.BigInteger;
import java.util.Scanner;

public class virus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int P = sc.nextInt();
        int N = sc.nextInt();

        sc.close();
        long virus = K;
        int remainder = 1000000007;

        for(int i = 0; i < N; i++) {
            virus *= P;
            if(virus > remainder) virus %= remainder;
        }

        System.out.print(virus);

        // K <= 10 ^ 8, P <= 10 ^ 8, N <= 10 ^ 6
        // virus 수는 최대 10 ^ (8 + 8 * 6) = 10 ^ 56


    }
}
