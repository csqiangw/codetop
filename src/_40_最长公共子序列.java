/**
 * lcs算法　
 * 明确：子序列的问题，多半用二维dptable解决
 * 思路和编辑距离一致，dp[i][j]代表长度为i与长度为j的字符串的公共子序列的最长长度
 * 那么，若当前两个字符相等，它们的lcs就是i - 1与j - 1的最长公共子序列长度+1
 * 若不想等，就取最大的一个就可以了，那么i - 1，j i j - 1肯定比i - 1，j - 1大，所以就不参与比较了
 */
public class _40_最长公共子序列 {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i <= text1.length(); i++)
            dp[i][0] = 0;
        for (int i = 0; i <= text2.length(); i++)
            dp[0][i] = 0;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }

}
