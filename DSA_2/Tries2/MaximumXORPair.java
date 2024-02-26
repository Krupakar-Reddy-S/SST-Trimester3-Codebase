import java.util.Arrays;
import java.util.HashSet;

public class MaximumXORPair {
    

    /* 
     * Given an Array of integers, find the pair with maximum XOR.
     * 
    */

    // TC = O(N), SC = O(1) [N = no. of elements in the array] :x:
    // Since our datatypes and their sizes can vary generally TC = O(NlogM) [M = Max value in the given datatype]
    public static int[] maximumXORPair1(int[] arr) {
        int ans[] = new int[2];
        int max = 0;
        int mask = 0;

        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            HashSet<Integer> set = new HashSet<>();

            for (int num : arr) {
                set.add(num & mask);
            }

            int temp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(temp ^ prefix)) {
                    max = temp;
                    ans[0] = temp ^ prefix;
                    ans[1] = prefix;
                    break;
                }
            }
        }

        return ans;
    }

    // TC = O(n), SC = O(n) [n = no. of elements in the array]
    public static int[] maximumXORPair2(int[] arr) {
        final class Trie {
            Trie left;
            Trie right;
        
        
            public void insert(int num) {
                Trie curr = this;
                for (int i = 31; i >= 0; i--) {
                    int bit = (num >> i) & 1;
                    if (bit == 0) {
                        if (curr.left == null) {
                            curr.left = new Trie();
                        }
                        curr = curr.left;
                    } else {
                        if (curr.right == null) {
                            curr.right = new Trie();
                        }
                        curr = curr.right;
                    }
                }
            }
        
        }

        int ans[] = new int[2];

        Trie root = new Trie();
        for (int num : arr) {
            root.insert(num);
        }

        int max = 0;
        for (int num : arr) {
            Trie curr = root;
            int currXOR = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (bit == 0) {
                    if (curr.right != null) {
                        currXOR += (1 << i);
                        curr = curr.right;
                    } 
                    else {
                        curr = curr.left;
                    }
                } 
                else {
                    if (curr.left != null) {
                        currXOR += (1 << i);
                        curr = curr.left;
                    } 
                    else {
                        curr = curr.right;
                    }
                }
            }

            if (currXOR > max) {
                max = currXOR;
                ans[0] = num;
                ans[1] = currXOR ^ num;
            }
        }

        return ans;
    }


    // public static int[] maximumXORPair3(int[] arr) {
    //     int ans[] = new int[2];
    //     int max = 0;

    //     Trie root = new Trie();
    //     for (int i = 0; i < arr.length; i++) {
    //         root.insert(Integer.toBinaryString(arr[i]));
    //     }
    // }


    public static void main(String[] args) {
        int arr[] = { 3, 10, 5, 25, 2, 8 };
        int ans[] = maximumXORPair2(arr);
        System.out.println(Arrays.toString(ans)); // [5, 25]
        System.out.println("Maximum XOR: " + (ans[0] ^ ans[1]));
    }
}
