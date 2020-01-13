package com.gdufe.extend;

import java.util.*;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/7 14:43
 * @version V1.0
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
           list1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(list1.contains(nums2[i]) && !list.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


    public int[] intersection2(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        set1.retainAll(set2);
        int index = 0;
        int[] arr = new int[set1.size()];
        for (int s : set1) {
            arr[index++] = s;
        }
        return arr;
    }


}
