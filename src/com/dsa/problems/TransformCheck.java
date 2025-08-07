package com.dsa.problems;

/**
 * Determines whether a pair of integers (a, b) can be converted to (c, d)
 * by performing any number of the following operations:
 *   - (a, b) → (a + b, b)
 *   - (a, b) → (a, a + b)
 *
 * @param a The first integer of the starting pair
 * @param b The second integer of the starting pair
 * @param c The first integer of the target pair
 * @param d The second integer of the target pair
 * @return "Yes" if (a, b) can be converted to (c, d), otherwise "No"
 */
public class TransformCheck {

    public static boolean isAns(int a, int b, int c , int d) {
        if(a > c || b > d) return false;
        if(a ==c && b == d) return true;

         return isAns(a+b, b, c, d) || isAns(a, a+b, c, d);
    }

  

    public static String isPossible(int a, int b, int c, int d) {
        // Work backwards from (c, d) to (a, b)
        while (c >= a && d >= b) {
            if (c == a && d == b) return "Yes";

            if (c == d) break; // Cannot reduce further

            if (c > d) {
                if (d > b)
                    c %= d;
                else
                    return (c - a) % d == 0 ? "Yes" : "No";
            } else {
                if (c > a)
                    d %= c;
                else
                    return (d - b) % c == 0 ? "Yes" : "No";
            }
        }
        return "No";
    }

    // Sample test call
    public static void main(String[] args) {
        //int a = 1, b = 1;
        //int c = 5, d = 2;

        int a = 1, b = 2;
        int c = 3, d = 6; 

        System.out.println("Is it possible? " + isPossible(a, b, c, d)); // Output: Yes
    }
}
