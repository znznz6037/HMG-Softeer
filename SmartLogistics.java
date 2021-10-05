import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class SmartLogistics
{
    public static void main(String args[])
    {
        int N = 0, K = 0, answer = 0;
        String line = "";
        Queue<Integer> robot = new LinkedList<>();
        Queue<Integer> part = new LinkedList<>();


        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str[] = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            K = Integer.parseInt(str[1]);

            line = br.readLine();

            br.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        for(int i = 0; i < N; i++) {
            if(line.charAt(i) == 'P') robot.add(i);
            else part.add(i);
        }

        for(int robotIdx: robot) {
            while (!part.isEmpty()) {
                int partIdx = part.peek();

                if (Math.abs(robotIdx - partIdx) <= K) {
                    answer++;
                    part.poll();
                    break;
                }
                else if(robotIdx > partIdx) part.poll();
                else break;
            }
        }

        System.out.print(answer);
    }
}