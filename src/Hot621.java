import java.util.Arrays;

// 任务调度器
public class Hot621 {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length <= 1 || n < 1) return tasks.length;
        int[] arr = new int[26];
        for (char c : tasks)
            arr[c - 'A'] ++;
        Arrays.sort(arr);
        int max = arr[25];
        int resCnt = (max - 1) * (n + 1) + 1;
        int i = 24;
        while (i >= 0 && arr[i] == max){
            resCnt ++;
            i --;
        }
        return Math.max(resCnt, tasks.length);
    }
}
