import java.util.ArrayList;
import java.util.List;

// 找到所有数组中消失的数字, 不使用额外空间且时间复杂度为 O(n)
public class Hot448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums){
            int to = num - 1;
            int curNum = num;
            int nextNum;
            while (nums[to] != curNum){
                nextNum = nums[to];
                nums[to] = curNum;
                curNum = nextNum;
                to = curNum - 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] != i + 1)
                res.add(i + 1);
        }
        return res;
    }

}
