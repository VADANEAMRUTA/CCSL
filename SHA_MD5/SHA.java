import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {
    public static void main(String[] args) {
        String input = "Sanjivani";

        try {
            // Create a MessageDigest instance for SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // Convert the input string to bytes and update the digest
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into hexadecimal representation
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                // Convert each byte to hex
                hexString.append(String.format("%02x", b));
            }

            // Print the result
            System.out.println("The hexadecimal equivalent of SHA1 is : ");
            System.out.println(hexString.toString());

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Algorithm SHA-1 not found");
        }
    }
}
