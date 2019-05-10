package Google;

import java.util.*;

public class Coaching {

    public static void main(String[] args) {
        String [] arr = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        Coaching c = new Coaching();
        for(List<String> l : c.groupStrings(arr)){
            System.out.println(l.toString());
        }
    }

    public List<List<String>> groupStrings(String[] strings) {
        HashMap<Integer, List<List<String>>> lengthMap = new HashMap<>();
        for(String s : strings){
            int len = s.length();
            if(lengthMap.containsKey(len)){
                List<List<String>> lenList = lengthMap.get(len);
                boolean followsPattern = false;
                for(List<String> l : lenList){
                    if(followsPattern(l.get(0), s)){
                        l.add(s);
                        followsPattern = true;
                    }
                }
                if(!followsPattern){
                    List<String> l2 = new ArrayList<>();
                    l2.add(s);
                    lenList.add(l2);
                }
            }
            else{
                List<List<String>> lenList = new ArrayList<>();
                List<String> l = new ArrayList<>();
                l.add(s);
                lenList.add(l);
                lengthMap.put(len, lenList);
            }

        }
        List<List<String>> ans = new ArrayList<>();
        Iterator<Integer> iter = lengthMap.keySet().iterator();
        while (iter.hasNext()){
            int len = iter.next();
            List<List<String>> lenList = lengthMap.get(len);
            ans.addAll(lenList);


        }
        return ans;
    }

    private boolean followsPattern(String s1, String s2) {
        int len = s1.length();
        int diff  = 0;
        if(s1.charAt(0) == 'z' & s2.charAt(0) == 'a') diff = 1;
        if(s1.charAt(0) == 'a' & s2.charAt(0) == 'z') diff = -1;
        for(int i = 1 ; i < len ; i++) {
            int thisDiff = 0;
            if (s1.charAt(i) == 'z' & s2.charAt(i) == 'a') {
                thisDiff = 1;
                if (diff != thisDiff) return false;
            }
            if (s1.charAt(i) == 'a' & s2.charAt(i) == 'z') {
                thisDiff = -1;
                if (diff != thisDiff) return false;
            }
            thisDiff = s1.charAt(i) - s2.charAt(i);
            if(thisDiff != diff) return false;
        }

        return true;
    }

}
