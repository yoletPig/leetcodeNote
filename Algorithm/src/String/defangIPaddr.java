package String;

import java.util.Arrays;

/**
 * 1108. IP 地址无效化
 */

public class defangIPaddr {
    public String defangIPaddr(String address) {
        String[] split = address.split("\\.");
        //System.out.println(Arrays.toString(split));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length-1; i++) {
            sb.append(split [i]+"[.]");
        }
        sb.append(split [split.length - 1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        defangIPaddr dfi = new defangIPaddr();
        System.out.println(dfi.defangIPaddr("1.1.1.1"));
    }
}
