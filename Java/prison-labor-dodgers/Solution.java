public class Solution {
    public static int solution(int[] x, int[] y) {
        int sum_x = 0, sum_y = 0;
        for (int i = 0; i < x.length; i++) {
            sum_x = sum_x + x[i];
        }
        for (int i = 0; i < y.length; i++) {
            sum_y = sum_y + y[i];
        }
        if (x.length > y.length) {
            return sum_x - sum_y;
        } else {
            return sum_y - sum_x;
        }
    }

}