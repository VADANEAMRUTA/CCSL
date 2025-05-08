import java.math.*;
import java.util.Scanner;

class RSA {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter first prime number (p): ");
        int p = sc.nextInt(); 
        System.out.print("Enter second prime number (q): ");
        int q = sc.nextInt();
        System.out.print("Enter the message (number) to encrypt: ");
        int msg = sc.nextInt();

        int n = p * q;  // public key
        int z = (p - 1) * (q - 1);  //Euler’s Totient Function (φ(n))
        System.out.println("The value of z = " + z);

        int e;
        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1) { // Finding e (public key exponent)[gcd function relatively prime]
                break;
            }
        }
        System.out.println("The value of e = " + e);

        int d = 0; 
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % e == 0) { // Finding d (private key exponent)
                d = x / e;
                break;
            }
        }
        System.out.println("The value of d = " + d);  //d≡e^−1 mod z

        // Encrypting the message
        double c = (Math.pow(msg, e)) % n;
        System.out.println("Encrypted message is: " + c);

        // Decrypting the message(M=C^d mod n)
        BigInteger N = BigInteger.valueOf(n);
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        BigInteger msgback = (C.pow(d)).mod(N);

        System.out.println("Decrypted message is: " + msgback);
        sc.close();
    }

    // Function to calculate GCD
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        else
            return gcd(b % a, a);
    }
}
