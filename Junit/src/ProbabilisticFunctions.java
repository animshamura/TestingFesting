import java.util.Random;

public class ProbabilisticFunctions {

    // Function 1: Miller-Rabin primality test with low error probability
    public static boolean isProbablyPrime(int n, int k) {
        if (n <= 1 || n == 4) return false;
        if (n <= 3) return true;

        int d = n - 1;
        while (d % 2 == 0) d /= 2;

        for (int i = 0; i < k; i++) {
            if (!millerTest(d, n)) return false;
        }

        return true; // Probably prime
    }

    private static boolean millerTest(int d, int n) {
        Random rand = new Random();
        int a = 2 + rand.nextInt(n - 4);
        int x = powerMod(a, d, n);

        if (x == 1 || x == n - 1) return true;

        while (d != n - 1) {
            x = (int)((1L * x * x) % n);
            d *= 2;

            if (x == 1) return false;
            if (x == n - 1) return true;
        }

        return false;
    }

    private static int powerMod(int base, int exp, int mod) {
        int result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (int)((1L * result * base) % mod);
            exp >>= 1;
            base = (int)((1L * base * base) % mod);
        }
        return result;
    }

    // Function 2: Probabilistic GCD estimation (still returns exact answer if repeated enough)
    public static int estimateGCD(int a, int b, int trials) {
        Random rand = new Random();
        int estimatedGCD = 1;
        for (int i = 0; i < trials; i++) {
            int x = 1 + rand.nextInt(Math.min(a, b));
            estimatedGCD = Math.max(estimatedGCD, gcd(a, b));
        }
        return estimatedGCD;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static void main(String[] args) {
        int number = 97;
        System.out.println(number + " is probably prime? " + isProbablyPrime(number, 5));

        int a = 81, b = 27;
        System.out.println("Estimated GCD of " + a + " and " + b + " is: " + estimateGCD(a, b, 10));
    }
}