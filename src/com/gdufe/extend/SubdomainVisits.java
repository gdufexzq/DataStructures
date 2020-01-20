package com.gdufe.extend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2020/1/19 11:25
 * @version V1.0
 */
public class SubdomainVisits {
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap();
        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<cpdomains.length; i++) {
            String str = cpdomains[i];
            String[] split = str.split(" ");
            int count = Integer.valueOf(split[0]);
            String s = split[1];
            String[] sp = s.split("\\.");
            int index = 0;
            sp[0] = s;
            for(int j=1; j<sp.length; j++) {
                index = s.indexOf(".", index+1);
                sp[j] = s.substring(index+1);
            }
            for(int m = 0; m < sp.length; m++) {
                if(map.containsKey(sp[m])) {
                    map.put(sp[m], map.get(sp[m]) + count);
                } else {
                    map.put(sp[m], count);
                }
            }
        }
        map.forEach((str,count) -> {
            list.add(count + " " + str);
        });
        return list;
    }

    public static void main(String[] args) {
        String[] arr = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisits(arr);
    }
}
