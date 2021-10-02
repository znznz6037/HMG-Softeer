import java.io.BufferedReader;
import java.io.InputStreamReader;

class Interval {
    public int start;
    public int end;
    public int limitSpeed;

    public Interval(int start, int end, int limitSpeed) {
        this.start = start;
        this.end = end;
        this.limitSpeed = limitSpeed;
    }
}

public class GBC {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] len = br.readLine().split(" ");
            int N = Integer.parseInt(len[0]);
            int M = Integer.parseInt(len[1]);

            Interval[] interval = new Interval[N];
            Interval[] userInterval = new Interval[M];

            int s = 0;
            for(int i = 0; i < N; i++) {
                String[] str = br.readLine().split(" ");
                interval[i] = new Interval(s, s + Integer.parseInt(str[0]), Integer.parseInt(str[1]));
                s = interval[i].end;
            }

            s = 0;
            for(int i = 0; i < M; i++) {
                String[] str = br.readLine().split(" ");
                userInterval[i] = new Interval(s, s + Integer.parseInt(str[0]), Integer.parseInt(str[1]));
                s = userInterval[i].end;
            }

            br.close();

            int exceedSpeedDiff = 0;
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(userInterval[i].start >= interval[j].end || userInterval[i].end <= interval[j].start) continue;
                    else if(userInterval[i].start <= interval[j].end) {
                        int diff = userInterval[i].limitSpeed - interval[j].limitSpeed;
                        exceedSpeedDiff = Math.max(exceedSpeedDiff, diff);
                    }
                }
            }

            System.out.print(exceedSpeedDiff);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
