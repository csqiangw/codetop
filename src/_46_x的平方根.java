public class _46_x的平方根 {

    public int mySqrt(int x) {
        if(x == 1)
            return 1;
        int l = 0,r = x,mid;
        while(r - l > 1){
            mid = l + (r - l) / 2;
            if(x / mid < mid)
                r = mid;
            else
                l = mid;
        }
        return l;
    }

}
