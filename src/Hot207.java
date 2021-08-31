import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// 课程表，判断课程安排是否为有向无环图
public class Hot207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false;
        // 特判
        if (prerequisites.length == 0) return true;
        int[] inDegree = new int[numCourses];
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i ++)
            adj[i] = new HashSet<>(); // 存储后继节点
        for (int[] p : prerequisites){
            inDegree[p[0]] ++;
            adj[p[1]].add(p[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        // 首先加入入度为 0 的结点
        for (int i = 0; i < numCourses; i ++)
            if (inDegree[i] == 0)
                q.offer(i);
        // 记录已经出队的课程数量
        int cnt = 0;
        while (!q.isEmpty()){
            int top = q.poll();
            cnt ++;
            // 遍历当前出队结点的所有后继结点
            for (int successor : adj[top]){
                inDegree[successor] --;
                if (inDegree[successor] == 0) q.offer(successor);
            }
        }
        return cnt == numCourses;
    }
}
