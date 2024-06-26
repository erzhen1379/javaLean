package leaning.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
 
public class AESEncryption {
    public static void main(String[] args) throws Exception {
        String text = "Hello World!";
 
        // 初始化密钥
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, new SecureRandom()); // 192 and 256 bits may not be available
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] keyBytes = secretKey.getEncoded();
 
        // 转换为AES密钥
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
 
        // 加密
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
 
        // 将加密后的数据转换为Base64字符串
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
 
        System.out.println("Encrypted Text: " + encryptedText);
    }
}