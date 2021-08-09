import java.util.Arrays;

// 根据身高重建队列
public class Hot406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) ->{
            if (p1[0] != p2[0])
                return p2[0] - p1[0];
            else
                return p1[1] - p2[1];
        });
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i ++){
            if (people[i][1] >= i)
                res[i] = people[i];
            else{
                int target = people[i][1];
                for (int j = i; j > target; j --)
                    res[j] = res[j - 1];
                res[target] = people[i];
            }
        }
        return res;
    }
}
