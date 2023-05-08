/**
 *  设置dp[i][j]代表长度为i的字符串变为长度为j的字符串，需要修改的最少次数
 *  初始情况，若其中一个为0，那么只能进行删除，有多少个就需要做多少次
 *  下面就是若两者相等，则当前最少编辑次数就是和长度为i - 1，j - 1的字符串编辑字数相同
 *  若不等，则从三种情况选一种最小的考虑，因为不等的话，要么改，要么删，等，反正只需要操作一次
 */
public class _36_编辑距离 {

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++)
            dp[i][0] = i;
        for (int i = 1; i <= word2.length(); i++)
            dp[0][i] = i;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if(word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],Math.min(dp[i][j - 1],dp[i - 1][j - 1]));
            }
        }
        return dp[word1.length()][word2.length()];
    }

}
