import java.util.*;
import java.io.*;

public class Main
{
    static char[][] keyArr = new char[5][5];

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message = br.readLine();
        String key = br.readLine();

        br.close();

        List<String> dividedMessage = new ArrayList<>();

        getKeyArr(key);
        dividedMessage = divideMessage(message);

        StringBuilder encode = new StringBuilder();
        for(String oneMessage: dividedMessage) {
            encode.append(encodeOneMessage(oneMessage));
        }

        System.out.println(encode.toString());
    }

    public static String encodeOneMessage(String oneMessage) {
        //1. 두 글자가 같은 행에 존재하는지 체크
        for(int i = 0; i < 5; i++) {
            int firstIdx = -1, lastIdx = -1;
            for(int j = 0; j < 5; j++) {
                if(oneMessage.charAt(0) == keyArr[i][j]) {
                    firstIdx = j + 1;
                    if(firstIdx == 5) firstIdx = 0;
                }
                if(oneMessage.charAt(1) == keyArr[i][j]) {
                    lastIdx = j + 1;
                    if(lastIdx == 5) lastIdx = 0;
                }
            }

            if(firstIdx >= 0 && lastIdx >= 0) return "" + keyArr[i][firstIdx] + keyArr[i][lastIdx];
        }

        //2. 두 글자가 같은 열에 존재하는지 체크
        for(int j = 0; j < 5; j++) {
            int firstIdx = -1, lastIdx = -1;
            for(int i = 0; i < 5; i++) {
                if(oneMessage.charAt(0) == keyArr[i][j]) {
                    firstIdx = i + 1;
                    if(firstIdx == 5) firstIdx = 0;
                }
                if(oneMessage.charAt(1) == keyArr[i][j]) {
                    lastIdx = i + 1;
                    if(lastIdx == 5) lastIdx = 0;
                }
            }

            if(firstIdx >= 0 && lastIdx >= 0) return "" + keyArr[firstIdx][j] + keyArr[lastIdx][j];
        }

        //3. 두 글자가 서로 다른 행, 열에 존재하는지 체크
        int firstYIdx = -1, firstXIdx = -1, lastYIdx = -1, lastXIdx = -1;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(oneMessage.charAt(0) == keyArr[i][j]) {
                    firstYIdx = i;
                    firstXIdx = j;
                }

                if(oneMessage.charAt(1) == keyArr[i][j]) {
                    lastYIdx = i;
                    lastXIdx = j;
                }
            }
        }

        return "" + keyArr[firstYIdx][lastXIdx] + keyArr[lastYIdx][firstXIdx];
    }

    public static List<String> divideMessage(String message) {
        List<String> dividedMessage = new ArrayList<>();

        for(int i = 0; i < message.length();) {
            String str = "";

            if(i == message.length() - 1) {
                dividedMessage.add(message.charAt(i) + "X");
                break;
            }
            else str = message.substring(i, i + 2);

            if(str.charAt(0) == str.charAt(1)) {
                if(str.charAt(0) == 'X') dividedMessage.add(str.charAt(0) + "Q");
                else dividedMessage.add(str.charAt(0) + "X");
                i++;
            }
            else {
                dividedMessage.add(str);
                i += 2;
            }
        }

        return dividedMessage;
    }

    public static void getKeyArr(String key) {
        List<Character> list = new ArrayList<>();
        List<Character> alphabet = new ArrayList<>();
        int keyLength = key.length();
        int curIdx = 0;

        for(int i = 0; i < 26; i++) {
            char c = (char)('A' + i);
            if(c != 'J' && !key.contains("" + c)) alphabet.add(c);
        }

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(curIdx < keyLength) {
                    char c = key.charAt(curIdx);
                    if(!list.contains(c)) {
                        list.add(c);
                        keyArr[i][j] = c;
                    }
                    else {
                        j--;
                    }
                    curIdx++;
                }
                else {
                    keyArr[i][j] = alphabet.remove(0);
                }
            }
        }
    }
}