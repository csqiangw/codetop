import java.util.ArrayList;
import java.util.List;

public class _23_螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> ret = new ArrayList<>();
        int m = matrix.length,n = matrix[0].length;
        int up = 0,down = m - 1,left = 0,right = n - 1;
        while(true){
            for (int i = left; i <= right; i++)
                ret.add(matrix[up][i]);
            if(++up > down) break;
            for (int i = up; i <= down; i++)
                ret.add(matrix[i][right]);
            if(--right < left) break;
            for (int i = right; i >= left; i--)
                ret.add(matrix[down][i]);
            if(--down < up) break;
            for (int i = down; i >= up; i--)
                ret.add(matrix[i][left]);
            if(++left > right) break;
        }
        return ret;
    }

}
