import java.util.Arrays;

public class Palindrome
{
    static final int X = 242;

    public static void main(String args[]) {
        
        for (int base = 2; base < 242; base++) {
            int[] number = separate(base);
            isPalindrome(number, base);
        }
    }

    static int[] separate(int base) {
        int digits = 0;
        while (Math.pow(base, digits) <= X) {
            digits++;
        }

        int x = X;
        int[] number = new int[digits];
        for (int i = 0; i < digits; i++) {
            int div = (int) Math.pow(base, digits-i-1);
            number[i] = x/div;
            x = x - (x/div)*div;
        }

        return number;
    }

    static void isPalindrome(int[] number, int base) {
        int[] numberReverse = new int[number.length];
        for (int i = 1; i <= number.length; i++)
            numberReverse[i - 1] = number[number.length - i];

        if (Arrays.equals(number, numberReverse)) {
            System.out.print("Palindrome found at base " + base + ": 242 [10] = ");
            
            for (int j = 0; j < number.length; j++)
                System.out.print(number[j] + " ");
            
            System.out.println("[" + base + "]");
        }
    }
}