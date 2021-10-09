import java.util.*;
import java.io.*;


public class SteppingStone
{
    static int N = 0, answer = 0;
    static int[] A;
    static int[] DP;

    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            N = Integer.parseInt(br.readLine());
            A = new int[N];
            DP = new int[N];

            String[] str = br.readLine().split(" ");
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(str[i]);
            }

            int maxIdx = 0;
            DP[0] = A[0];

            for(int value: A) {
                if(DP[maxIdx] < value) {
                    maxIdx++;
                    DP[maxIdx] = value;
                }
                else {
                    DP[binarySearch(value, maxIdx)] = value;
                }
            }

            for(int i: DP) {
                if(i != 0) answer++;
                System.out.print(i + " ");
            }
            System.out.println();

            System.out.print(answer);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    static int binarySearch(int value, int idx) {
        int start = 0, end = 0;
        int mid = idx / 2;
        if(value < DP[mid]) {
            end = mid;
        }
        else {
            start = mid;
            end = idx;
        }

        for(int i = start; i <= end; i++) {
            if(value < DP[i]) return i;
        }

        return 0;
    }
}