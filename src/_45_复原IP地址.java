import java.util.ArrayList;
import java.util.List;

/**
 * 只能说要去拍断的情况太多了：
 * 首先，整体考虑回朔法，因为从一个点不断扩张，继而往下探索
 * 其次，每个ip最多为3位，所以此时，要判断是否越界
 * 但是这个不够，还要判断剩余的字符长度是否大于后面ip能容纳的最大值
 * 还是不够，还要判断剩余的字符长度，再每次取了之后，是否能使得后面满足能容纳的最大值
 * 还是不够，还要判断拆取的字符是否以0开头，注意0.0.0.0的情况，所以截取子串后，长度大于2，且开头为字符0的也要去掉
 */
public class _45_复原IP地址 {

    List<String> ret = new ArrayList<>();

    public void getRestoreIpAddresses(String s,List<String> list,int idx,int index){
        if(index == 0){
            ret.add(list.get(0) + "." + list.get(1) + "." + list.get(2) + "." + list.get(3));
        }
        for (int i = 1; i <= 3; i++) {
            if(idx + i - 1 >= s.length())//越界了，不需要考虑之后的所有情况了
                break;
            if(s.length() - idx > index * 3)
                break;
            if(s.length() - idx - i > (index - 1) * 3)
                continue;
            String substring = s.substring(idx, idx + i);
            if(substring.length() > 1 && substring.charAt(0) == '0')
                break;
            if(Integer.parseInt(substring) > 255)
                break;
            list.add(substring);
            getRestoreIpAddresses(s,list,idx + i,index - 1);
            list.remove(list.size() - 1);
        }
    }

    public List<String> restoreIpAddresses(String s){
        List<String> list = new ArrayList<>();
        getRestoreIpAddresses(s,list,0,4);
        return ret;
    }

}
