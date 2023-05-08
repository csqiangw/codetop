import java.util.HashSet;

//考虑滑动窗口法

/**
 *
 */
public class _1_无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0,right = 0,len = 0;
        HashSet<Character> set = new HashSet<>();
        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
            }else{
                if(len < right - left)
                    len = right - left;
                while(s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
                left++;
            }
            right++;
        }
        return right - left > len ? left - right : len;
    }

}
