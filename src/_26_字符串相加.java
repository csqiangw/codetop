public class _26_字符串相加 {

    public String addStrings(String num1, String num2) {
        int carry = 0,i = num1.length() - 1,j = num2.length() - 1,n1,n2,sum;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0){
            sum = 0;
            n1 = i >= 0 ? Character.digit(num1.charAt(i),10) : 0;
            n2 = j >= 0 ? Character.digit(num2.charAt(j),10) : 0;
            sum += n1 + n2 +carry;
            if(sum == 10){
                carry = 1;
                sb.append('0');
            }else{
                carry = sum / 10;
                sb.append(sum % 10);
            }
            i--;
            j--;
        }
        if(carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

}
