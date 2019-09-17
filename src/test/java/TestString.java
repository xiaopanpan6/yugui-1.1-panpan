public class TestString {
    public static void main(String[] args) {
        String strOrig = "yugui-2019-0002";
        int lastIndex = strOrig.lastIndexOf("-");
        String prefix = strOrig.substring(0, lastIndex);
        System.out.println(prefix);

        String lastStr = strOrig.substring(lastIndex+1, strOrig.length());

        System.out.println(lastStr);

        int i = Integer.parseInt(lastStr);

        System.out.println(i);

        i++;

        String s =String.valueOf(i);

        String value = prefix + "-" + s;

        System.out.println(value);

    }
}
