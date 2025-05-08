import java.util.Scanner;
class Diffie_Hellman {
    //(a^b) % p
    private static long power(long a, long b, long p)
    {
        if (b == 1)
            return a;
        else
            return (((long)Math.pow(a, b)) % p);
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        long P, G, x, a, y, b, ka, kb; //P-prime no, G-Primitive root
        System.out.println("Enter value of P:");
        P=sc.nextInt();
        System.out.println("The value of P:" + P);
        System.out.println("Enter value of G:");
        G=sc.nextInt();
        System.out.println("The value of G:" + G);
        System.out.println("Enter private key a for Alice:");
        a = sc.nextInt();
        System.out.println("The private key a for Alice:"
                           + a);
        x = power(G, a, P); //x = (G^a) % P
        System.out.println("Enter private key a for Bob:");
        b = sc.nextInt();
        System.out.println("The private key b for Bob:"
                           + b);

       
        y = power(G, b, P); //y = (G^b) % P

       
        ka = power(y, a, P);  // ka = (y^a) % P
        kb = power(x, b, P);  // kb = (x^b) % P

        System.out.println("Secret key for the Alice is:"
                           + ka);
        System.out.println("Secret key for the Bob is:"
                           + kb);
                           sc.close();
    }
}