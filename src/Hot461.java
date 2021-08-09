// 汉明距离, 逐位比较x和y的0~31位
public class Hot461 {
    public int hammingDistance(int x, int y){
        int ans = 0;
        for (int i = 0; i < 32; i ++){
            if ((x >> i & 1) != (y >> i & 1))  // 获取x的i位的值
                ans ++;
        }
        return ans;
    }
}