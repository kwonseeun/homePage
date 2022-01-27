package com.base.core.config.filter.wrapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.util.HtmlUtils;

import com.base.core.utils.StringUtils;
import com.base.core.utils.convert.JSONConvert;
import com.base.core.utils.enums.HTML_ESCAPE_TYPE;

public class EscapeRequestWrapper extends HttpServletRequestWrapper {

    private Map<String, String[]> rsMap = null;
    private String sBody = "";

    public EscapeRequestWrapper(HttpServletRequest request) {
        super(request);
        init();
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream( this.sBody.getBytes() );
        ServletInputStream sis = new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };

        return sis;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader( new InputStreamReader( this.getInputStream() ) );
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return rsMap;
    }

    @Override
    public Enumeration<String> getParameterNames() {

        List<String> cList = new ArrayList<String>();

        Set<String> cSet = rsMap.keySet();
        Iterator<String> cIterator = cSet.iterator();
        while ( cIterator.hasNext() ) {
            String sKey = cIterator.next();
            cList.add( sKey );
        }

        return Collections.enumeration( cList );
    }

    @Override
    public String getParameter( String name ) {
        String[] sValues =  rsMap.get( name );
        return sValues != null && sValues.length > 0 ? sValues[0] : null;
    }

    @Override
    public String[] getParameterValues(String name) {
        return rsMap.get( name );
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    public void init()
    {
        System.out.println("  EscapeRequestWrapper init START ");

        try {

            String sContentType = super.getContentType();
            if( "application/json".equals( sContentType ) )
            {
                sBody = JSONConvert.htmlEscapeToJson( HTML_ESCAPE_TYPE.ESCAPE , StringUtils.convertStreamToString( super.getInputStream() ) ).toJSONString();
            }
            else
            {

                if( rsMap == null )
                {
                    Map<String, String[]> mTemp = new LinkedHashMap<String, String[]>();

                    Enumeration<String> cEnumeration = super.getParameterNames();

                    JSONObject json = new JSONObject();
                    while (cEnumeration.hasMoreElements())
                    {
                        String sKey = String.valueOf( cEnumeration.nextElement() );
                        String[] sValue = super.getParameterValues( sKey );

                        for( int i=0; i<sValue.length; i++ )
                        {
                            sValue[i] = HtmlUtils.htmlEscape( sValue[i] );
                        }

                        if( sValue.length == 1 )
                        {
                            json.put( sKey , sValue[0]);
                        }
                        else
                        {
                            JSONArray jsonArray = new JSONArray();
                            for( String sStr : sValue )
                            {
                                jsonArray.add( sStr );
                            }
                            json.put( sKey , jsonArray );
                        }

                        mTemp.put( sKey , sValue );
                    }

                    rsMap =  Collections.unmodifiableMap( mTemp );
                    sBody = JSONConvert.htmlEscapeToJson( HTML_ESCAPE_TYPE.ESCAPE, json.toJSONString() ).toJSONString();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("  EscapeRequestWrapper init END ");
    }




}
