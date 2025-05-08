import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static void main(String[] args) {
        String input = "Welcome";

        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Compute the digest
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }

            // Print the hash
            System.out.print("The hexadecimal equivalent of hash is : ");
            System.out.println(hexString.toString());

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Algorithm MD5 not found");
        }
    }
}
