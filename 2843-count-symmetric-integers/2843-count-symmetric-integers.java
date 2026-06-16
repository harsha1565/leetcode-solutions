class Solution {
    public int countSymmetricIntegers(int low, int high) {
          int count = 0;

        for (int num = low; num <= high; num++) {
            String s = String.valueOf(num);

            // Skip if number of digits is odd
            if (s.length() % 2 != 0) {
                continue;
            }

            int n = s.length() / 2;
            int firstSum = 0;
            int secondSum = 0;

            for (int i = 0; i < n; i++) {
                firstSum += s.charAt(i) - '0';
                secondSum += s.charAt(i + n) - '0';
            }

            if (firstSum == secondSum) {
                count++;
            }
        }

        return count;
       
        }
        
    }
