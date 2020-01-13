package com.gdufe.extend;

import java.util.*;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/7 15:31
 * @version V1.0
 */
public class UniqueOccurrences {

    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> set = new HashSet<Integer>();

        // 记录出现次数
        for(int data :arr) {
            if (map.get(data) == null) {
                map.put(data, 1);
            }
            else {
                map.put(data, map.get(data) + 1);
            }
        }

        // 验证重复值
        for(Integer i : map.values()) {
            if (!set.add(i)) {
                return false;
            }
        }
        return true;
    }


    public static boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        if (arr.length >= 2) {
            int count = 1;
            for(int i=1; i<arr.length; i++) {
                if(i == arr.length - 1) {
                    if(arr[i-1] == arr[i]) {
                        count++;
                        if(list.contains(count)) {
                            return false;
                        } else {
                            return true;
                        }
                    } else {
                        if(!list.contains(count) && !list.contains(1) && count != 1) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                if(arr[i-1] == arr[i]) {
                    count++;
                } else {
                    if(list.contains(count)) {
                        return false;
                    } else {
                        list.add(count);
                        count = 1;
                    }
                }
            }
        } else {
            return true;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {5,-2,-2,1,5,-2};
        boolean b = uniqueOccurrences(arr);
        System.out.println(b);
    }
}
