package com.gdufe.sparsearray;

import java.util.Arrays;

public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组11 * 11
        // 0：表示没有棋子，1：表示黑子，2：表示白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // 输出原始的二维数组
        System.out.println("原始的二维数组~~");
        Arrays.stream(chessArr1).forEach((chessArr2) -> {
            Arrays.stream(chessArr2).forEach(chess -> {
                System.out.printf("%d\t", chess);
            });
            System.out.println();
        });

        // 将二维数组转稀疏数组
        // 1. 先遍历二维数组得到非0数据的个数
        int sum = 0;
        for(int i=0; i<chessArr1.length; i++) {
            for(int j=0; j<chessArr1[0].length; j++) {
                if(chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);

        // 2. 创建对应的稀疏数组
        int sparseArray[][] = new int[sum+1][3];
        sparseArray[0][0] = chessArr1.length;
        sparseArray[0][1] = chessArr1[0].length;
        sparseArray[0][2] = sum;

        // 遍历二维数组，将非0的值存放到sparseArr中
        int count = 1;
        for(int i=0; i<chessArr1.length; i++) {
            for(int j=0; j<chessArr1[0].length; j++) {
                if(chessArr1[i][j] != 0) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }

        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为~~~");
        Arrays.stream(sparseArray).forEach(sparseArray2 -> {
            Arrays.stream(sparseArray2).forEach(sparse -> {
                System.out.printf("%d\t", sparse);
            });
            System.out.println();
        });

        // 将稀疏数组恢复成二维数组
        int chessArr2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for(int i=1; i<sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        //输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        System.out.println();
        Arrays.stream(chessArr2).forEach((chessArr3) -> {
            Arrays.stream(chessArr3).forEach(chess -> {
                System.out.printf("%d\t", chess);
            });
            System.out.println();
        });
    }
}
