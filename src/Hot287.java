// 寻找重复数, 不修改数组 nums 且只用常量级 O(1) 的额外空间
public class Hot287 {
    // 快慢指针，判断是否有环，并找到环入口
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }
    // 二分法，抽屉原理，9个抽屉放10个苹果，至少有一个抽屉放了两个
    public int findDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;

            int cnt = 0;
            for (int num : nums){
                if (num <= mid)
                    cnt ++;
            }
            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个，此时重复元素一定出现在 [1..4] 区间里
            if (cnt > mid)
                // 重复元素位于区间 [left..mid]
                right = mid;
            else
                // if 分析正确了以后，else 搜索的区间就是 if 的反面区间 [mid + 1..right]
                left = mid + 1;
        }
        return left;
    }
}
