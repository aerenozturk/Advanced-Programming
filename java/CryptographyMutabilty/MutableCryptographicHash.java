package CryptographyMutabilty;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MutableCryptographicHash {
    private final MessageDigest md;

    public MutableCryptographicHash() throws NoSuchAlgorithmException {
        md = MessageDigest.getInstance("MD5");
    }

    // This method is not thread safe and should be used with caution!
    public String digest(String input) {
        md.update(input.getBytes());
        byte[] digest = md.digest();
        return bytesToHex(digest);
    }

    public boolean isTrue(String input, String md5) {
        return digest(input).equals(md5.toUpperCase());
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
