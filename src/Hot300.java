import java.util.Arrays;

// 最长递增子序列
public class Hot300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        // 定义 dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // 每个元素都至少可以单独成为子序列
        int maxL = 1;
        for (int i = 0; i < nums.length; i ++){
            for (int j = 0; j < i; j ++){
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxL = Math.max(maxL, dp[i]);
        }
        return maxL;
    }

    public static int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        // tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
        int[] tail = new int[len];
        // 遍历第 1 个数，直接放在有序数组 tail 的开头
        tail[0] = nums[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end = 0;

        for (int i = 1; i < len; i++) {
            if (nums[i] > tail[end]) {
                // 直接添加在那个元素的后面，所以 end 先加 1
                end++;
                tail[end] = nums[i];
            } else {
                // 使用二分查找法，在有序数组 tail 中 找到第 1 个大于等于 nums[i] 的元素，尝试让那个元素更小
                int left = 0, right = end;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (tail[mid] >= nums[i])
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
                // 走到这里是因为 【逻辑 1】 的反面，因此一定能找到第 1 个大于等于 nums[i] 的元素
                // 用更小的值进行替换
                tail[left] = nums[i];
            }
            // 调试方法
            // printArray(nums[i], tail);
        }
        // 此时 end 是有序数组 tail 最后一个元素的索引
        // 题目要求返回的是长度，因此 +1 后返回
        end++;
        return end;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,0,1,2,6,3};
        int x = lengthOfLIS2(arr);
        System.out.println(x);
    }
}
