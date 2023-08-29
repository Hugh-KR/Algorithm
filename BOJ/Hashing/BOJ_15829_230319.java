package BOJ.Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;

public class BOJ_15829_230319 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Long> map = new HashMap<>();
        long L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long num = 1;
        for(int i = 97; i <= 123; i++) {
            map.put((char)i, num);
            num++;
        }

        BigInteger sum = new BigInteger("0");

        for(int i = 0; i < L; i++) {
            sum = sum.add(BigInteger.valueOf(map.get(str.charAt(i))).multiply(BigInteger.valueOf(31).pow(i)));
        }
        System.out.println(sum.remainder(BigInteger.valueOf(1234567891)));
    }
}
