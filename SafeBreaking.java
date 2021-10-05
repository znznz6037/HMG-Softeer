import java.util.*;
import java.io.*;

class Value implements Comparable<Value> {
    public int weight;
    public int price;

    public Value(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Value v) {
        return v.price - this.price;
    }
}

public class SafeBreaking {
    public static void main(String args[]) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] str = br.readLine().split(" ");
            int W = Integer.parseInt(str[0]);
            int N = Integer.parseInt(str[1]);

            Value[] value = new Value[N];

            for(int i = 0; i < N; i++) {
                str = br.readLine().split(" ");
                value[i] = new Value(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            }

            br.close();

            //Greedy Algorithm
            Arrays.sort(value);

            long maxPrice = 0;
            for(int i = 0; i < N; i++) {
                if(W - value[i].weight >= 0) {
                    maxPrice += value[i].weight * value[i].price;
                    W -= value[i].weight;
                } else {
                    maxPrice += W * value[i].price;
                    break;
                }
            }

            System.out.print(maxPrice);

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
