import java.util.Scanner;

public class MapAutoCreation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.print(numberOfPoint(2, 4, 0, N));
    }

    /*
    한 가로줄의 정사각형의 개수 + 1 = 한 가로줄의 점 수
    정사각형이므로, 총 점의 개수 = 한 가로줄의 수 ^ 2
     */
    public static int numberOfPoint(int square, int point, int idx, int iteration) {
        if(iteration == idx) return point;

        point = (int) Math.pow(square + 1, 2);

        return numberOfPoint(square * 2, point, idx + 1, iteration);
    }
}
