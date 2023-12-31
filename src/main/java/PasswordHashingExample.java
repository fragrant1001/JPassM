import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashingExample {
    public static void main(String[] args) throws NoSuchAlgorithmException{
        String password = "1234561";
        String salt = generateSalt();

        String hashedPassword = hashPassword(password, salt);
        System.out.println("Original Password: " + password + " , Hashed Password: " + hashedPassword);
    }

    private static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        String saltedPassword = password + salt;

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        byte[] hashedBytes = messageDigest.digest(saltedPassword.getBytes());

        StringBuilder stringBuilder = new StringBuilder();
        for(byte b : hashedBytes) {
            stringBuilder.append(String.format("%02x", b));
        }

        return stringBuilder.toString();
    }

    private static String generateSalt() {
        String salt = "123456";
        return salt;
    }




}
