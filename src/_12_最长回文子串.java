/**
 * 回文子串，从中间往外扩散的思想
 */
public class _12_最长回文子串 {

    public String palindrome(String s,int l,int r){
        while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l + 1,r);
    }

    public String longestPalindrome(String s) {
        String ret = "";
        for (int i = 0; i < s.length(); i++) {
            //两种可能
            String palindrome1 = palindrome(s, i, i);
            String palindrome2 = palindrome(s, i, i + 1);
            //这面比较考虑，两者比出一个大的，再和ret比较，不如都和ret比较，最终若大来直接赋值
            if(palindrome1.length() > ret.length())
                ret = palindrome1;
            if(palindrome2.length() > ret.length())
                ret = palindrome2;
        }
        return ret;
    }

}
