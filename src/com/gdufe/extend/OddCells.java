package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/27 15:59
 * @version V1.0
 */
public class OddCells {
    public static int oddCells(int n, int m, int[][] indices) {
        int[][] arr = new int[n][m];
        for(int i=0; i< indices.length; i++){
            int h = indices[i][0]; // 行
            int l = indices[i][1]; // 列
            for(int k=0; k<arr[h].length; k++) {
                arr[h][k]++;
            }
            for(int a=0; a<n; a++) {
                arr[a][l]++;
            }
        }
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                if(arr[i][j] % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] indices = new int[2][2];
        indices[0][0] = 0;
        indices[0][1] = 1;
        indices[1][0] = 1;
        indices[1][1] = 1;
        int count = oddCells(2, 3, indices);
        System.out.println(count);
    }
}
