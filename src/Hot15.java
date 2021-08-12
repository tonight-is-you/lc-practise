import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 三数之和，排序+双指针
public class Hot15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i ++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = n - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r]));
                    lists.add(list);

                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r -1]) r--;
                    l ++;
                    r --;
                }
                else if (sum < 0)
                    l ++;
                else
                    r --;
            }
        }
        return lists;
    }
}
