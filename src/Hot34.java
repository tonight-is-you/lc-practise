// 在排序数组中查找元素的第一个和最后一个位置
public class Hot34 {
    // 不管是找上界还是找下界，异或是找指定值，都可以用找下界模版
    public int upper(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        if (r < 0 || nums[r] != target) return -1;
        return r;
    }

    public int lower(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        if (l >= nums.length || nums[l] != target) return -1;
        return l;
    }

    public int[] searchRange (int[] nums, int target) {
        return new int[]{lower(nums, target), upper(nums, target)};
    }

}
