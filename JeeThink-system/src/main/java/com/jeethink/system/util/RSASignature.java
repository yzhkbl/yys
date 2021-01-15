package com.jeethink.system.util;


import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSASignature {
    private static final String SIGN_ALGORITHMS = "SHA1WithRSA";
    private static final String encode = "UTF-8";

    public RSASignature() {
    }

    public static String sign(String data, String privateKey) {
        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64Util.base64StringToByte(privateKey));
        KeyFactory keyf = null;
        PrivateKey priKey = null;

        try {
            keyf = KeyFactory.getInstance("RSA");
            priKey = keyf.generatePrivate(priPKCS8);
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initSign(priKey);
            signature.update(data.getBytes("UTF-8"));
            byte[] signed = signature.sign();
            return Base64Util.byteToStringBase64(signed);
        } catch (Exception var7) {
            var7.printStackTrace();
            return "";
        }
    }

    public static boolean doCheck(String data, String sign, String publicKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64Util.base64StringToByte(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            Signature signature = Signature.getInstance("SHA1WithRSA");
            signature.initVerify(pubKey);
            signature.update(data.getBytes("UTF-8"));
            boolean bool = signature.verify(Base64Util.base64StringToByte(sign));
            return bool;
        } catch (Exception var8) {
            var8.printStackTrace();
            return false;
        }
    }
}