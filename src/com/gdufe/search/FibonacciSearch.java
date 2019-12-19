package com.gdufe.search;

import java.util.Arrays;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/17 11:27
 * @version V1.0
 */
public class FibonacciSearch {

    public static int maxSize = 20;
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 100, 1234};

        System.out.println("index=" + fibSearch(arr, 89));
    }

    // 因为后面我们mid=low+F(k-1)-1,需要使用到斐波那契数列，因此我们需要先获取到一个斐波那契数列
    // 非递归方法得到一个斐波那契数列
    public static int[] fib() {
        int f[] = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for(int i=2; i<maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    // 编写斐波那契查找算法
    // 使用非递归的方法编写算法

    /**
     *mid = low + F(k-1) - 1;
     * f(k) - 1 >= high
     * @param a 数组
     * @param key 我们需要查找的关键码(值）
     * @return 返回对应的下标，如果没有-1
     */
    public static int fibSearch(int[] a, int key) {

        int low = 0;
        int high = a.length - 1;
        int k = 0; //表示斐波那契分割数值的下标
        int mid = 0; // 存放mid值
        int f[] = fib(); // 获取到斐波那契数列
        // 获取斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        // 因为f[k] 值 可能大于a的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向a[]
        // 不足的部门会使用0填充
        int[] temp = Arrays.copyOf(a, f[k]); // f[k]表示数组长度

        // 实际上需求使用a数组最后的数填充 temp
        // 举例
        // temp = {1, 8, 10, 89, 100, 1234, 0, 0, 0} => {1, 8, 10, 89, 100, 1234, 1234, 1234, 1234}
        for (int i=high+1; i< temp.length; i++) {
            temp[i] = a[high];
        }
        // 使用while来处理，找到我们的数 key
        while (low <= high) { // 只要这个条件满足，就可以找
            // low表示下标，f[k-1]-1=偏移量
            // 数组长度=f[k]-1 可以拆分为f[k-1]-1 和f[k-2]-1 加上 1
            // 在f[k-1] - 1和f[k-2]的中间就是mid的值
            // 所以mid的值为low+ f[k-1] - 1;
            mid = low + f[k-1] - 1;
            if (key < temp[mid]) { // 我们应该继续向数组的前面查找（左边）
                high = mid - 1;
                // 为什么k--?
                // 说明
                // 1. 全部元素 = 前面的元素 + 后边元素
                // 2. f[k] = f[k-1] + f[k-2]
                // 因为前面有 f[k-1] 个元素，所以可以继续拆分 f[k-1] = f[k-2] + f[k-3];
                // 即在 f[k-1] 的前面继续查找k--;
                // 即下次循环 mid = f[k-1-1] - 1;
                k--;
            } else if (key > temp[mid]) { // 我们应该继续向数组的后面查找（右边）
                low = mid + 1;
                // 为什么是 k -= 2
                // 说明
                // 1. 全部元素 = 前面的元素 + 后边元素
                // 2. f[k] = f[k-1] + f[k-2]
                // 3. 因为后面我们有f[k-2] 所以可以继续拆分 f[k-2] = f[k-3] + f[k-4]
                // 4. 即在f[k-2] 的前面进行查找 k -= 2
                // 5. 即下次循环 mid=f[k - 1 - 2] - 1
                k -= 2;
            } else {
                // 找到
                // 需要确定，返回的是哪个下标
                if(mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
