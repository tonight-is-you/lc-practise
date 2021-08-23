public class BinarySearch {
    // 通用模版，所有关于二分查找问题都可以用转化为找下界（x>=target）都问题
    public int lowerBound(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) // 或者是 >
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left; // 返回下界索引
    }

    // 求解上界问题(x<=target)同样可以用上面都模板，即互补问题都模版
    public int upperBound(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }

    // 查找第一次出现都位置。先查找满足 x >= target 的下界，然后再判断下界与 target 是否相等
    public int SearchFirst(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) // 或者是 >
                right = mid - 1;
            else
                left = mid + 1;
        }
        if (left >= arr.length || arr[left] != target) return -1;
        return left;
    }

    // 查找最后一次出现都位置。先查找满足 x <= target 的上界，然后再判断上界与 target 是否相等
    public int SearchLast(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) // 或者是 >
                right = mid - 1;
            else
                left = mid + 1;
        }
        if (right < 0 || arr[right] != target) return -1;
        return right;
    }

    // 查找指定值位置
    public int searchInsert(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] > target) // 或者是 >
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
