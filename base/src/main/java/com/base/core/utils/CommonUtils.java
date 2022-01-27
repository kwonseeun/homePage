package com.base.core.utils;

import java.util.List;
import java.util.Map;

import com.base.core.utils.enums.PAD_TYPE;

public class CommonUtils {


    /**
     * isNotNull
     * @param obj
     * @return
     */
    public static boolean isNotNull ( Object obj)
    {
        boolean bFlag = false;

        if ( obj instanceof String )
        {
            bFlag = StringUtils.nullToBlank( obj ).equals("") ? false : true;
        }
        else if( obj instanceof Integer )
        {
            bFlag = obj == null ? false : true;
        }
        else if( obj instanceof Map )
        {
            Map map = ( Map ) obj;
            bFlag = map == null ? false : map.isEmpty() ? false : true;
        }
        else if( obj instanceof List )
        {
            List aList = ( List ) obj;
            bFlag = aList == null ? false : aList.isEmpty() ? false : true;
        }

        return bFlag;
    }
    /**
     * isNotNull
     * @param obj
     * @return
     */
    public static boolean isNull ( Object obj)
    {
        boolean bFlag = false;

        if ( obj instanceof String )
        {
            bFlag = StringUtils.nullToBlank( obj ).equals("") ? true : false;
        }
        else if( obj instanceof Integer )
        {
            bFlag = obj == null ? true : false;
        }
        else if( obj instanceof Map )
        {
            Map map = ( Map ) obj;
            bFlag = map == null ? false : map.isEmpty() ? true : false;
        }
        else if( obj instanceof List )
        {
            List aList = ( List ) obj;
            bFlag = aList == null ? false : aList.isEmpty() ? true : false;
        }

        return bFlag;
    }

    /**
     * LPAD
     * @param sStr : 기본값
     * @param len  : 총 길이 bytes
     * @param sfix : 치환문자
     * @return
     */
    public static String lPad( String sStr, int tLen, String sFix )
    {
        String rsStr = "";
        try {
            rsStr = makePadding( PAD_TYPE.LPAD, sStr, tLen, sFix );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rsStr;

    }
    /**
     * RPAD
     * @param sStr : 기본값
     * @param len  : 총 길이 bytes
     * @param sfix : 치환문자
     * @return
     */
    public static String rPad( String sStr, int tLen, String sFix)
    {
        String rsStr = "";
        try {
            rsStr = makePadding( PAD_TYPE.RPAD, sStr, tLen, sFix );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rsStr;

    }

    /**
     *
     * @param sStr
     * @param tLen
     * @param sFix
     * @param type
     * @return
     */
    public static String makePadding( PAD_TYPE padType, String sStr, int tLen, String sbFix)
    {
        String rsStr = "";
        try {

            // padding 치환 문자 없을 경우 공란
            if( isNull( sbFix ) )
            {
                sbFix = " ";
            }

            // 한글 3byte => 2byte 변경
            byte[] strByte = sStr.getBytes( "EUC-KR" );
            int strLen = strByte.length;

            byte[] sbFixByte = sbFix.getBytes( "EUC-KR" );
            int sbFixLen = sbFixByte.length;

            // 총 byte수에서 문자 byte 계산
            int iLen = tLen - strLen;

            // padding 처리 할 갯수가 없을 경우
            if( iLen <= 0 )
            {
                return "";
            }

            // padding 치환 갯수 계산
            int rowCnt = ( iLen / sbFixLen );

            // 문자 치환 값 byte => string add
            String nStr = "";
            for( int i=0; i<rowCnt; i++ )
            {
                nStr += new String( sbFixByte, "EUC-KR" );
            }

            // LPAD / RPAD 구분에 따른 Return 값 생성
            if( padType == PAD_TYPE.LPAD )
            {
                rsStr = new String( strByte, "EUC-KR" ) + nStr;
            }
            else if( padType == PAD_TYPE.RPAD )
            {
                rsStr = nStr + new String( strByte, "EUC-KR" );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rsStr;
    }


    /**
     * subStr byte사이즈 자르기
     * @param sStr : 기본값
     * @param tlen  : 총 길이 bytes
     * @return rsStr : byte 사이즈 문자
     */
    public static String subStr( String sStr, int sIdx, int eIdx )
    {
        String rsStr = "";
        try {

            byte[] strBytes = sStr.getBytes("EUC-KR");

            // byte 사이즈 별 문자 취득
            rsStr = new String( strBytes, sIdx, eIdx, "EUC-KR" );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rsStr;

    }


}
