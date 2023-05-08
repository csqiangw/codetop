public class _17_合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mNum = new int[m + n];
        int i = 0,j = 0,k = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j])
                mNum[k++] = nums1[i++];
            else
                mNum[k++] = nums2[j++];
        }
        while(i < m)
            mNum[k++] = nums1[i++];
        while(j < n)
            mNum[k++] = nums2[j++];
        for (int l = 0; l < k; l++)
            nums1[l] = mNum[l];
    }

}
