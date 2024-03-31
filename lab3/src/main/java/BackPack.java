import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;

public class BackPack {
    //动态规划
    public static int knapsack(int[] weights, int[] values, int capacity) {
        if( !judge(weights, values, capacity) )
            throw new NegativeException();
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacity];
    }

    //判断三个参数是否有小于0存在
    public static boolean judge(int[] weights, int[] values, int capacity){
        for(int i=0; i<weights.length; i++){
            if(weights[i] < 1 ){
                return false;
            }
        }
        for(int i=0; i<values.length; i++){
            if(values[i] < 0){
                return false;
            }
        }
        if(capacity < 0){
            return false;
        }
        if(weights.length != values.length){
            return false;
        }
        return true;
    }

}