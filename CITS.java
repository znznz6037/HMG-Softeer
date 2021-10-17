import java.util.*;
import java.io.*;

public class CITS
{
    static class Pos {
        int y;
        int x;
        int heading[];
        int time;

        public Pos(int y, int x, int[] heading, int time) {
            this.y = y;
            this.x = x;
            this.heading = heading;
            this.time = time;
        }
    }
    static int N = 0, T = 0;
    static int[][][] map;
    static int[][] dir = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };
    //[1][1]
    //신호등 첫번째 원소는 [n][n][0] 진입하는 방향
    static int[][][] trafficLight = {
            {{0, 0}},
            {{0, 1}, {0, 1}, {1, 0}, {-1, 0}},
            {{-1, 0}, {0, 1}, {0, -1}, {-1, 0}},
            {{0, -1}, {0, -1}, {1, 0}, {-1, 0}},
            {{1, 0}, {0, 1}, {0, -1}, {1, 0}},
            {{0, 1}, {0, 1}, {-1, 0}},
            {{-1, 0}, {0, -1}, {-1, 0}},
            {{0, -1}, {0, -1}, {1, 0}},
            {{1, 0}, {0, 1}, {1, 0}},
            {{0, 1}, {0, 1}, {1, 0}},
            {{-1, 0}, {0, 1}, {-1, 0}},
            {{0, -1}, {0, -1}, {-1, 0}},
            {{1, 0}, {0, -1}, {1, 0}}
    };
    static int time = 0;

    public static void main(String args[])
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            T = Integer.parseInt(str[1]);
            map = new int[N][N][4];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    str = br.readLine().split(" ");
                    for(int k = 0; k < 4; k++) {
                        map[i][j][k] = Integer.parseInt(str[k]);
                    }
                }
            }
            br.close();

            System.out.print(BFS());

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    static int BFS() {
        boolean[][] visited = new boolean[N][N];
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0, dir[3], 0));

        while(!queue.isEmpty()) {
            Pos pos = queue.poll();
            int curY = pos.y;
            int curX = pos.x;
            int[] curHeading = pos.heading;
            int curTime = pos.time;

            visited[curY][curX] = true;

            if(curTime == T) continue;

            int trafficIdx = map[curY][curX][curTime % 4];
            if(!isCorrectDir(curHeading, trafficLight[trafficIdx][0])) continue;
            for(int i = 1; i < trafficLight[trafficIdx].length; i++) {
                int nextY = curY + trafficLight[trafficIdx][i][0];
                int nextX = curX + trafficLight[trafficIdx][i][1];
                if(nextY < 0 || nextY >= N || nextX < 0 || nextX >= N) continue;

                queue.add(new Pos(nextY, nextX, trafficLight[trafficIdx][i], curTime + 1));
            }
        }
        int answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j]) answer++;
            }
        }

        return answer;
    }

    static boolean isCorrectDir(int[] curDir, int[] trafficDir) {
        return Objects.deepEquals(curDir, trafficDir);
    }
}