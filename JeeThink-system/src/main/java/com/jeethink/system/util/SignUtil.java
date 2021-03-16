package com.jeethink.system.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import com.chinapay.secss.SecssUtil;

public class SignUtil {

	private static String verifyFilePathKey = "verify.file";
	private static String certFilePath = "sign.filePath";
	private static String signFile = "sign.file";
	private static String signPwd = "sign.file.password";
	private static String signCertType ="sign.cert.type";
	private static String signInvalidFields="sign.invalid.fields";
	private static String signatureField = "signature.field";

    private static SecssUtil secssUtil = null;
    static{
        /*
         * 初始化security.properties属性文件
         *
         */
        secssUtil = new SecssUtil();
        InputStream is = PathUtil.class.getResourceAsStream("/security.properties");
        Properties p = new Properties();
        try {
            p.load(is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.setProperty("", "");
     /*   p.setProperty("signPwd", "1");
        p.setProperty("signCertType", "PKCS12");
        p.setProperty("signInvalidFields", "Signature,CertId");
        p.setProperty("signInvalidFields", "Signature,CertId");
        p.setProperty("verifyFilePathKey", "C:/cer/cp_test.cer");
        p.setProperty("signatureField", "Signature");*/


        secssUtil.init(p);
    }

    public static String sign(Map signMap){
        secssUtil = new SecssUtil();
        secssUtil.init();
        secssUtil.sign(signMap);

        System.out.println(secssUtil.getErrCode());
        System.out.println(secssUtil.getErrMsg());

        return secssUtil.getSign();
    }

    public static String sign(String merId,String signData){
        return null;
    }

    public static boolean verify(Map map){
        secssUtil.verify(map);
        if("00".equals(secssUtil.getErrCode()))
            return true;
        return false;
    }

    public static String decode(String merId,String decData){

        return null;
    }

    public static String decryptData(String encData){
        secssUtil.decryptData(encData);
        return secssUtil.getSign();
    }
}
