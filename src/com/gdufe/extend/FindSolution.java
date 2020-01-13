package com.gdufe.extend;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/7 16:05
 * @version V1.0
 */
public class FindSolution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        ArrayList<List<Integer>> arrayList = new ArrayList<>();
        for(int i=1; i<=z; i++) {
            for(int j=1; j<=z; j++) {
                if(customfunction.f(i, j) == z) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    arrayList.add(list);
                }
            }
        }
        return arrayList;
    }
    class CustomFunction {
        public int  f(int i, int j) {
            return 0;
        }
    }

}
