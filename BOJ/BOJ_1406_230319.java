package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ_1406_230319 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String n = br.readLine();
        int m = Integer.parseInt(br.readLine());
        LinkedList<String> list = new LinkedList<>();

        for(int i = 0; i < n.length(); i++) {
            list.add(String.valueOf(n.charAt(i)));
        }

        ListIterator<String> iter = list.listIterator();

        while(iter.hasNext()) {
            iter.next();
        }

        for(int i = 0; i < m; i++) {
            String command = br.readLine();
            if(command.length() > 1) {
                iter.add(String.valueOf(command.charAt(2)));
            } else if(command.equals("L")) {
                if(iter.hasPrevious()) {
                    iter.previous();
                }
            } else if(command.equals("D")) {
                if(iter.hasNext()) {
                    iter.next();
                }
            } else if(command.equals("B")) {
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            }
        }

        for(String x : list){
            sb.append(x);
        }
        System.out.println(sb);


    }
}
