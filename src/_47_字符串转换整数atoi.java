import java.util.ArrayList;
import java.util.List;

public class _47_字符串转换整数atoi {

    public int myAtoi(String s) {
        String trimS = s.trim();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < trimS.length(); i++) {
            if(trimS.charAt(i) == ' ' || (trimS.charAt(i) >= 'a' && trimS.charAt(i) <= 'z')
                    || (trimS.charAt(i) >= 'A' && trimS.charAt(i) <= 'Z') || trimS.charAt(i) == '.')
                break;
            if((trimS.charAt(i) == '+' || trimS.charAt(i) == '-') && list.size() >= 1)
                break;
            list.add(trimS.charAt(i));
        }
        int ret = 0;
        if(list.size() == 0)
            return ret;
        boolean positive = list.get(0) == '-' ? false : true;
        if(list.get(0) == '+' || list.get(0) == '-')
            list.remove(0);
        for (int i = 0; i < list.size(); i++) {
            if(positive){
                if(ret > (Integer.MAX_VALUE - Character.digit(list.get(i),10)) / 10)
                    return Integer.MAX_VALUE;
                ret = ret * 10 + Character.digit(list.get(i),10);
            }else{
                if(ret * (-1) < (Integer.MIN_VALUE + Character.digit(list.get(i),10)) / 10)
                    return Integer.MIN_VALUE;
                ret = ret * 10 + Character.digit(list.get(i),10);
            }
        }
        return positive ? ret : ret * (-1);
    }

}
