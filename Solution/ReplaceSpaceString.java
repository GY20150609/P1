package Solution;

public class ReplaceSpaceString {

    // 思路1 : 自带api
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ","%20");
    }

    // 思路2 : 循环遍历
    public String replaceSpace2(StringBuffer str) {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c == ' '){
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }



}
