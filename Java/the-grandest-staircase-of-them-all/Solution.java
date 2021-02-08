public class Solution {
    public static int solution(int N) {
        int memo[][] = new int[N+2][N+2];
//        for(int i=0;i<N+2;i++) {
//        	for(int j=0;j<N+2;j++) {
//        		System.out.print(memo[i][j]);
//        	}
//        	System.out.println();
//        }
        return buildStairCase(1, N, memo) - 1;
    }
    
    public static int buildStairCase(int height,int length,int[][] memo){
    	if (memo[height][length] != 0)
            return memo[height][length];
        if (length == 0)
            return 1;
        if (length < height)
            return 0;
        memo[height][length] = buildStairCase(height + 1, length - height, memo) + buildStairCase(height + 1, length, memo);
        return memo[height][length];
    }
    public static void main(String[] args) {
    	System.out.println(solution(200));
    }
}