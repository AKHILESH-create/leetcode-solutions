class Solution {

    public boolean checkDivisibility(int n) {
        if (n == 0) {
            return false;
        }

        int original = n;
        int digitSum = 0;
        int digitProduct = 1;

        if (n < 0) {
            n = -n;
        }

        while (n > 0) {
            int digit = n % 10;
            n /= 10;

            digitSum += digit;
            digitProduct *= digit;
        }

        if (digitSum == 0 || digitProduct == 0) {
            return false;
        }

        return original % digitSum == 0 && original % digitProduct == 0;
    }
}
