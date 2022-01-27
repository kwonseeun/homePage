package com.base.core.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.util.HtmlUtils;

import freemarker.template.utility.HtmlEscape;

public class StringUtils {


    /**
     * camelCaseConverter
     * camelCase 변환 처리
     * @param pStr	: 변환 문자
     * @return
     */
    public static String camelCaseConverter( String pStr )
    {
        String vStr = pStr.toLowerCase();
        String nStr = "";
        for( int i=0; i<vStr.length(); i++ )
        {
            String cStr = String.valueOf( vStr.charAt( i ) );
            if( "_".equals( cStr ) )
            {
                nStr += String.valueOf( vStr.charAt( i + 1 ) ).toUpperCase();
                i++;
                continue;
            }
            nStr += cStr;
        }
        return nStr;
    }

    /**
     * nullToBlank
     * Object String null 일경우 return ""
     * @param obj
     * @return
     */
    public static String nullToBlank( Object obj )
    {
        String sStr = "";
        try {

            sStr = obj == null ? "" : String.valueOf( obj ).equals( "null" ) ? "" : String.valueOf( obj );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return sStr;

    }

    /**
     * InputStream => String 변경 처리
     * @return
     */
    public static String convertStreamToString( InputStream cInputStream )
    {
        try {

            StringBuilder cStringBuilder = new StringBuilder();
            InputStreamReader cInputStreamReader = new InputStreamReader( cInputStream , "UTF-8");
            BufferedReader cBufferedReader = new BufferedReader( cInputStreamReader );
            Stream<String> cStream = cBufferedReader.lines();
            Iterator<String> cIterator =  cStream.iterator();
            while ( cIterator.hasNext() ) {
                cStringBuilder.append( cIterator.next() );
            }
            return cStringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
