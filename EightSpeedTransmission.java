import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EightSpeedTransmission {

    public static void main(String[] args) {
        try {
            String answer = "";

            // 입력 받기
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            br.close();

            // 입력 문자열 정수로 변환하여 저장
            int[] transmission = new int[8];
            for(int i = 0; i < 8; i++) transmission[i] = Integer.parseInt(str[i]);

            // 변속 방향 판단
            boolean isAscend = true, isDescend = true;
            for(int i = 0; i < 8; i++) {
                if(!(transmission[i] == i + 1 && isAscend)) isAscend = false;
                if(!(transmission[i] == 8 - i && isDescend)) isDescend = false;
            }

            System.out.print(answer = isAscend ? "ascending" : isDescend ? "descending" : "mixed");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
