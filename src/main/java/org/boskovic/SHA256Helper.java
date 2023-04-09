package org.boskovic;

import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SHA256Helper {

    private SHA256Helper(){
        throw new IllegalStateException("Utility class");
    }

    @SneakyThrows
    public static String generateHash(String data){
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte [] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
        StringBuilder hexademicalString = new StringBuilder();

        for (byte b: hash){
            String hexademical = Integer.toHexString(0xff & b);
            if (hexademical.length() == 1){
                hexademicalString.append("0");
            }
            hexademicalString.append(hexademical);
        }
        return hexademicalString.toString();
    }

}
