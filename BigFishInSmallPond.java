import java.util.*;
import java.io.*;

public class BigFishInSmallPond
{
    public static void main(String args[])
    {
        try{
            int answer = 0;

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int W[] = new int[N];
            int result[] = new int[N];

            str = br.readLine().split(" ");
            for(int i = 0; i < N; i++) W[i] = Integer.parseInt(str[i]);

            for(int i = 0; i < M; i++) {
                str = br.readLine().split(" ");
                int idxA = Integer.parseInt(str[0]) - 1;
                int idxB = Integer.parseInt(str[1]) - 1;

                if(W[idxA] < W[idxB]) {
                    if(result[idxB] == 0) result[idxB] = 2;
                    result[idxA] = 1;
                }
                else if(W[idxA] > W[idxB]) {
                    if(result[idxA] == 0) result[idxA] = 2;
                    result[idxB] = 1;
                }
                else result[idxA] = result[idxB] = 1;
            }

            br.close();

            for(int i = 0; i < N; i++)
                if(result[i] != 1) answer++;

            System.out.print(answer);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}