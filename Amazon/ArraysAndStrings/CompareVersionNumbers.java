package Amazon.ArraysAndStrings;

public class CompareVersionNumbers {
    public static void main(String[] args) {

        String version1 = "1.01", version2 = "1.001";
        String version3 = ".01", version4 = "1.01";

        CompareVersionNumbers cvn = new CompareVersionNumbers();
//        System.out.println(cvn.compareVersion(version1, version2));
        System.out.println(cvn.compareVersion("1.0", "1.0.0"));
    }

    public int compareVersion(String version1, String version2) {

//        System.out.println("str1 " + version1 + " str2 "+ version2);
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < v1.length; i++) {
            s1.append(v1[i]);
        }

        for (int i = 0; i < v2.length; i++) {
            s2.append(v2[i]);
        }
        int length = 0;

//        System.out.println("s1 " + s1);
//        System.out.println("s2 " + s2);

        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 < l2) {
            length = l1;
        } else {
            length = l2;
        }

//        System.out.println("l1 " + l1 + " l2 " + l2);

        for (int i = 0; i <= length; i++) {

            System.out.println("s1 " + s1.charAt(i));
            System.out.println("s2 " + s2.charAt(i));

            if (i == length) {
                if (l1 == length) {
                    int lenRem = l2 - length;
                    for (int j = 0; j <= lenRem; j++) {
                        if (s2.charAt(i + j) > 0) return 1;
                        if(i+j == l2 -1 && s2.charAt(i+j) ==0) return 0;
                    }
                } else if (l2 == length) {
                    int lenRem = l1 - length;
                    for (int j = 0; j <= lenRem; j++) {
                        if (s1.charAt(i + j) > 0) return -1;
                    }
                }
            }
//            int x = ('1' > '0')? 1: 0;
//            System.out.println("x " + x);
                if (s1.charAt(i) > s2.charAt(i)) return -1;
                if (s1.charAt(i) < s2.charAt(i)) return 1;


        }
        return 0;
    }
}
