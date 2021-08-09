// 只出现一次的数字，异或操作三个性质：a^0 = a; a^a = 0; 异或操作满足交换律和结合律
public class Hot136 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums)
            res ^= num;
        return res;
    }
}
