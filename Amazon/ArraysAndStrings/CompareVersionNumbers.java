package Amazon.ArraysAndStrings;

import java.util.Arrays;
import java.util.List;
import java.util.ListResourceBundle;

public class CompareVersionNumbers {
    public static void main(String[] args) {

        String version1 = "1.01", version2 = "1.001";
        String version3 = ".01", version4 = "1.01";
        CompareVersionNumbers cvn = new CompareVersionNumbers();
        cvn.compareVersion(version3, version4);
    }

    public int compareVersion(String version1, String version2) {

        List<String> ver1 = Arrays.asList(version1.split("\\."));
        List<String> ver2 = Arrays.asList(version2.split("\\."));

        int l1 = ver1.size();
        int l2 = ver2.size();

        if(l1< l2) {
            int padding = l2 - l1;
            for(int i = 0; i < padding; i++){
                ver1.add("0");
            }
        }else if (l2< l1) {
            int padding = l1 - l2;
            for(int i = 0; i < padding; i++){
                ver1.add("0");
            }
        }

        for(int i = 0 ; i< l1; i++){
            System.out.print(ver1.get(i));
            System.out.println();
            System.out.print(ver2.get(i));
        }

        return 0;
    }

}
