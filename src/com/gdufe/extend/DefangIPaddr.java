package com.gdufe.extend;
/**
 * @Description: ${todo}
 * @author xuzq
 * @date 2019/12/26 15:47
 * @version V1.0
 */
public class DefangIPaddr {
    /**
     * 1108. IP 地址无效化
     */
    public static String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public static void main(String[] args) {
        String address = "1.1.1.1";
        String ip = defangIPaddr(address);
        System.out.println(ip);
    }
}
