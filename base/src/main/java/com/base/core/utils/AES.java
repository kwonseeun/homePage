package com.base.core.utils;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {


    /**
     * AES Base64 암호화
     * @param sTxt 암호화 대상 String
     * @param sKey 암/복호화 KEY
     * @param sIv  암/복호화 IV
     * @return
     */
    public static String AES_Base64_Encrypt( String sTxt, String sKey, String sIv )
    {
        String encStr = "";

        try {

            byte[] bTxt = sTxt.getBytes("UTF-8");
            byte[] bKey = sKey.getBytes("UTF-8");
            byte[] bIv = sIv.getBytes("UTF-8");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(bKey, "AES");
            IvParameterSpec ivParamSpec = new IvParameterSpec(bIv);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

            byte[] encrypted = cipher.doFinal( bTxt );

            encStr = Base64.getEncoder().encodeToString( encrypted );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return encStr;
    }

    /**
     * AES Base64 복호화
     * @param sTxt 복호화 대상 String
     * @param sKey 암/복호화 KEY
     * @param sIv  암/복호화 IV
     * @return
     */
    public static String AES_Base64_Decrypt( String sTxt, String sKey, String sIv )
    {
        String sStr = "";

        try {

            byte[] bTxt = sTxt.getBytes("UTF-8");
            byte[] bKey = sKey.getBytes("UTF-8");
            byte[] bIv = sIv.getBytes("UTF-8");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(bKey, "AES");
            IvParameterSpec ivParamSpec = new IvParameterSpec(bIv);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

            byte[] decrypt = Base64.getDecoder().decode( bTxt );

            byte[] decrypted = cipher.doFinal( decrypt );

            sStr = new String( decrypted );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sStr;
    }





    /**
     * AES128
     * @param sTxt 암호화 대상 String
     * @return
     */
    public static String EncryptAES128( String sTxt )
    {
        String sStr = "";

        try {

            String sKey = PropUtils.getProp( "aes128_key" );
            String sIv = PropUtils.getProp( "aes128_iv" );

            sStr = AES_Base64_Encrypt(sTxt, sKey, sIv);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sStr;
    }
    /**
     * AES256
     * @param sTxt 암호화 대상 String
     * @return
     */
    public static String EncryptAES256( String sTxt )
    {
        String sStr = "";

        try {

            String sKey = PropUtils.getProp( "aes256_key" );
            String sIv = PropUtils.getProp( "aes256_iv" );

            sStr = AES_Base64_Encrypt(sTxt, sKey, sIv);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sStr;
    }

    /**
     * AES128 복호화
     * @param sTxt 복호화 대상 String
     * @return
     */
    public static String DecryptAES128( String sTxt )
    {
        String sStr = "";

        try {

            String sKey = PropUtils.getProp( "aes128_key" );
            String sIv = PropUtils.getProp( "aes128_iv" );
            sStr = AES_Base64_Decrypt(sTxt, sKey, sIv);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sStr;
    }
    /**
     * AES256 복호화
     * @param sTxt 복호화 대상 String
     * @return
     */
    public static String DecryptAES256( String sTxt )
    {
        String sStr = "";

        try {

            String sKey = PropUtils.getProp( "aes256_key" );
            String sIv = PropUtils.getProp( "aes256_iv" );
            sStr = AES_Base64_Decrypt(sTxt, sKey, sIv);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sStr;
    }




}
