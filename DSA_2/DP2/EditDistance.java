public class EditDistance {

    /* 
     * Given 2 Strings Sa and Sb, find the minimum number of operations
     * required to convert Sa to Sb. The operations allowed are:
     * 
     * 1. Insert a character
     * 2. Delete a character
     * 3. Update a character
     * 
    */

    public static int editDistance1(String Sa, String Sb, int lenA, int lenB) {
        if (lenA == 0 || lenB == 0) {
            return Math.max(lenA, lenB);
        }
        

        if (Sa.charAt(lenA-1) == Sb.charAt(lenB-1)) {
            editDistance1(Sa, Sb, lenA-1, lenB-1);
        }
        else if(lenA > lenB) {
            return Math.min(1 + editDistance1(Sa, Sb, lenA-1, lenB), 1 + editDistance1(Sa, Sb, lenA, lenB-1));
        }
        else if (lenA < lenB) {
            return Math.min(1 + editDistance1(Sa, Sb, lenA-1, lenB), 1 + editDistance1(Sa, Sb, lenA, lenB-1));
        }
        else {
            return 1 + editDistance1(Sa, Sb, lenA-1, lenB-1);
        }

        return 0;
    }

    public static void main(String[] args) {
        String Sa = "horse";
        String Sb = "ros";

        System.out.println(editDistance1(Sa, Sb, Sa.length(), Sb.length()));
        // System.out.println(editDistance2(Sa, Sb));
    }
}
