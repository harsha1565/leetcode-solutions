class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
          int temp = x;
        int sum = 0;

       
        while (temp > 0) {
            int rem = temp % 10;
            sum = sum + rem;
            temp = temp / 10;
        }

      
        if (x % sum == 0) {
            return sum;
        }

        return -1;
        
    }
}