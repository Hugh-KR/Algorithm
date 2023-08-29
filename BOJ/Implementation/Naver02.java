package BOJ.Implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Naver02 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = new String[]{"INT", "INT", "BOOL", "SHORT", "LONG"};

        bw.write(Solution(arr));
        bw.flush();
        bw.close();
    }

    public static String Solution(String[] arr) {
        ArrayList<String> list = new ArrayList<>();
        String byteStr = "";

        for (String str : arr) {
            if (byteStr.length() + getType(str) > 8) {
                int num = 8 - byteStr.length();
                for (int i = 0; i < num; i++) {
                    byteStr += ".";
                }

                list.add(byteStr);
                byteStr = "";
            }

            switch (str) {
                case "BOOL":
                    byteStr += "#";
                    break;
                case "SHORT":
                    if (byteStr.length() % 2 == 0) byteStr += "##";
                    else byteStr += ".##";
                    break;
                case "FLOAT":
                    if (byteStr.length() % 4 == 0) byteStr += "####";
                    else {
                        int num = 4 - byteStr.length() % 4;
                        for (int i = 0; i < num; i++) {
                            byteStr += ".";
                        }
                        byteStr += "####";
                    }

                    break;
                case "INT":
                    list.add("########");
                    break;
                case "LONG":
                    list.add("########");
                    list.add("########");
                    break;
            }

            if (byteStr.length() == 8) {
                list.add(byteStr);
                byteStr = "";
            }

        }

        if (!byteStr.isEmpty()) {
            int num = 8 - byteStr.length();
            for (int i = 0; i < num; i++) {
                byteStr += ".";
            }
            list.add(byteStr);
        }

        if (list.size() > 16) {
            return "HALT";
        }

        return String.join(",", list);
    }

    private static int getType(String type) {
        switch (type) {
            case "BOOL":
               return 1;
            case "SHORT":
                return 2;
            case "FLOAT":
                return 4;
            case "INT":
                return 8;
            case "LONG":
                return 16;
            default:
                return 0;
        }
    }
}
