package BOJ.Implementation;

import java.time.LocalDate;

public class BOJ_16170_230524 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        System.out.println(String.format("%02d\n%02d\n%02d", year, month, day));
    }
}
