import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Pos {
    public int x;
    public int y;

    public Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class ObstacleRecognition {

    static boolean[][] visited;
    static int[][] map;
    static int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    static int N;
    static int blockCnt = 0;
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++) {
                String line = br.readLine();
                for(int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }
            br.close();

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] != 0 && !visited[i][j]) {
                        blockCnt++;
                        BFS(i, j);
                    }
                }
            }

            System.out.println(blockCnt);
            Collections.sort(answer);
            for(int i: answer) System.out.println(i);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    static void BFS(int y, int x) {
        int cnt = 1;

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(y, x));
        visited[y][x] = true;

        while(!q.isEmpty()) {
            int curY = q.peek().y, curX = q.peek().x;
            q.poll();

            int ny = 0, nx = 0;
            for (int i = 0; i < 4; i++) {
                ny = curY + dir[i][0];
                nx = curX + dir[i][1];
                if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx] && map[ny][nx] == 1) {
                    cnt++;
                    visited[ny][nx] = true;
                    q.add(new Pos(ny, nx));
                }
            }
        }

        answer.add(cnt);
    }
}