package 正则表达式.T468;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；
// 如果是有效的 IPv6 地址，返回 "IPv6" ；
// 如果不是上述类型的 IP 地址，返回 "Neither" 。

class Solution {
    public String validIPAddress(String queryIP) {
        String ipv4 = "^(?:(?:25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)($|(?!\\.$)\\.)){4}$";
        String ipv6 = "^(?:(?:[\\da-fA-F]{1,4})($|(?!:$):)){8}$";

        Pattern r4 = Pattern.compile(ipv4);
        Pattern r6 = Pattern.compile(ipv6);

        Matcher m4 = r4.matcher(queryIP);
        Matcher m6 = r6.matcher(queryIP);

        if (m4.find()) {
            return "IPv4";
        } else if (m6.find()) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }
}
