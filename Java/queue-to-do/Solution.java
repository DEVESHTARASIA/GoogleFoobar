public class Solution {
    public static int solution(int start, int length) {
        int index=0, pointer=length-1, count=0, answer=0, id = start;
        int end = (length * length) - 1 + start;
        while (id <= end) {
            index = (id - start) % length;
            if (index <= pointer) {
                answer = answer ^ id;
            }
            System.out.println("id "+id+" index "+index+" answer "+answer+" pointer "+pointer);
            count++;id++;
            if (count % length == 0) {
                pointer--;
            }
        }
        return answer;

    }
    
    public static void main(String[] args) {
    	System.out.println(solution(17,4));
    }
}