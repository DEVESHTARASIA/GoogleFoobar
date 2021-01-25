public class Solution {
    public static int solution(String S) {
        int salutes = 0;
        int right = 0;
        for (int index = 0; index < S.length(); index++) {
            char ch = S.charAt(index);
            if (ch == '<') {
                salutes = salutes + (right * 2);
            } else if (ch == '>') {
                right++;
            } else {
                continue;
            }
        }
        return salutes;
    }

}