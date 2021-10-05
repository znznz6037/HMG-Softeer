import java.util.*;
import java.io.*;


public class MeanOfGrade
{
    public static void main(String args[])
    {
        int N = 0, K = 0;
        int[] S;
        int[][] interval;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            K = Integer.parseInt(str[1]);
            S = new int[N + 1];
            interval = new int[K][2];

            str = br.readLine().split(" ");
            for(int i = 0; i < N; i++) S[i] = Integer.parseInt(str[i]);

            for(int i = 0; i < K; i++) {
                str = br.readLine().split(" ");
                interval[i][0] = Integer.parseInt(str[0]);
                interval[i][1] = Integer.parseInt(str[1]);
            }

            br.close();

            for(int i = 0; i < K; i++) {
                int cnt = 0;
                double sum = 0;
                for(int j = interval[i][0]; j <= interval[i][1]; j++) {
                    sum += S[j - 1];
                    cnt++;
                }
                sum /= cnt;
                System.out.printf("%.2f", sum);
                if(i != K - 1) System.out.println();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}