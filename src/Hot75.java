// 颜色分类
public class Hot75 {
    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for (int num: nums)
            cnt[num] += 1;
        int[] index = new int[4];
        for (int i = 0; i < 3; i ++)
            index[i + 1] = index[i] + cnt[i];
        for (int i = 0; i < 3; i ++){
            for (int j = index[i]; j < index[i + 1]; j ++)
                nums[j] = i;
        }
    }
}
