package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/8 15:36
 * @version V1.0
 */
public class Transpose {

    // 输入：输入：[[1,2,3],[4,5,6]]
    // 输出：[[1,4],[2,5],[3,6]]
    public int[][] transpose(int[][] A) {
        int[][] a = new int[A[0].length][A.length];
        for(int i=0; i<A[0].length; i++) {
            for(int j=0; j<A.length; j++) {
                a[i][j] = A[j][i];
            }
        }
        return a;
    }
}
