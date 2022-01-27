package com.base.core.utils;

import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

public class PropUtils {

    /**
     * [공통] properties 파일 값 읽기
     * @param sKey
     * @return
     */
    public static String getProp( String sKey )
    {
        String sProp = "";

        try {

            String sResources = "properties/common.properties";  // properties파일명
            Reader reader = Resources.getResourceAsReader(sResources);

            Properties prop = new Properties();
            prop.load( reader );
            sProp = prop.getProperty( sKey );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sProp;
    }


}
