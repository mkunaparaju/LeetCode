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
        int versionOneLength = version1.length();
        int versionTwoLength = version2.length();
        int result = 0;

        if (versionOneLength == 0 && versionTwoLength == 0) {
            return 0;
        }
        if (versionOneLength == 0) {
            return -1;
        }
        if (versionTwoLength == 0) {
            return 1;
        }


        String[] versionOneSplit = version1.split("\\.");
        String[] versionTwoSplit = version2.split("\\.");

        int lengthToUse = versionOneSplit.length;

        if (versionOneSplit.length > versionTwoSplit.length) {
            lengthToUse = versionOneSplit.length;
        } else if (versionTwoSplit.length > versionOneSplit.length) {
            lengthToUse = versionTwoSplit.length;
        }

        for (int i = 0; i < lengthToUse; i++) {
            int verOne = 0;
            int verTwo = 0;
            if (i < versionOneSplit.length) {
                verOne = Integer.parseInt(versionOneSplit[i]);
            }

            if (i < versionTwoSplit.length) {
                verTwo = Integer.parseInt(versionTwoSplit[i]);
            }

            if (verOne > verTwo) {
                return 1;
            } else if (verTwo > verOne) {
                return -1;
            }
        }

        return result;
    }
}




