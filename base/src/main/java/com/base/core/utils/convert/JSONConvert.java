package com.base.core.utils.convert;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.util.HtmlUtils;

import com.base.core.utils.StringUtils;
import com.base.core.utils.enums.HTML_ESCAPE_TYPE;

public class JSONConvert {

    /**
     * jsonString => htmlescape => jsonObject 변경
     * @param reqBody
     * @return
     */
    @SuppressWarnings("unchecked")
    public static JSONObject htmlEscapeToJson( HTML_ESCAPE_TYPE htmlEscapeType, String reqBody )
    {
        JSONObject cJson = new JSONObject();
        try {

            if( "".equals( StringUtils.nullToBlank( reqBody ) ) )
            {
                return cJson;
            }

            JSONObject jsonObject = ( JSONObject ) new JSONParser().parse( reqBody );

            Set<String> cSet = jsonObject.keySet();
            Iterator<String> cIterator = cSet.iterator();
            while( cIterator.hasNext() )
            {
                String sKey = cIterator.next();
                Object obj = jsonObject.get( sKey );

                if( obj instanceof String )
                {
                    String rsValue = "";
                    if( htmlEscapeType.equals( HTML_ESCAPE_TYPE.ESCAPE ) )
                    {
                        rsValue = HtmlUtils.htmlEscape( String.valueOf( obj ) );
                    }
                    else if( htmlEscapeType.equals( HTML_ESCAPE_TYPE.UN_ESCAPE ) )
                    {
                        rsValue = HtmlUtils.htmlUnescape( String.valueOf( obj ) );
                    }
                    else
                    {
                        rsValue = String.valueOf( obj );
                    }

                    cJson.put( sKey , rsValue);
                }
                else if( obj instanceof Integer )
                {
                    int rsValue = Integer.parseInt( String.valueOf( obj ) );
                    cJson.put( sKey , rsValue);
                }
                else if( obj instanceof Long )
                {
                    long rsValue = Long.parseLong( String.valueOf( obj ) );
                    cJson.put( sKey , rsValue);
                }
                else if( obj instanceof Double )
                {
                    double rsValue = Double.parseDouble( String.valueOf( obj ) );
                    cJson.put( sKey , rsValue);
                }
                else if( obj instanceof Boolean )
                {
                    boolean rsValue = Boolean.valueOf( String.valueOf( obj ) );
                    cJson.put( sKey , rsValue);
                }
                else if( obj instanceof List )
                {
                    JSONArray rsValue = new JSONArray();
                    JSONArray jsonArray = ( JSONArray ) new JSONParser().parse( String.valueOf( obj ) );

                    for( Object sobj : jsonArray )
                    {
                        if( sobj instanceof String )
                        {
                            String value = "";
                            if( htmlEscapeType.equals( HTML_ESCAPE_TYPE.ESCAPE ) )
                            {
                                value = HtmlUtils.htmlEscape( String.valueOf( sobj ) );
                            }
                            else if( htmlEscapeType.equals( HTML_ESCAPE_TYPE.UN_ESCAPE ) )
                            {
                                value = HtmlUtils.htmlUnescape(  String.valueOf( sobj ) );
                            }
                            else
                            {
                                value = String.valueOf( sobj );
                            }
                            rsValue.add( value );
                        }
                        else if( obj instanceof Integer )
                        {
                            int sStr = Integer.parseInt( String.valueOf( sobj ) );
                            rsValue.add( sStr );
                        }
                        else if( obj instanceof Long )
                        {
                            long sStr = Long.parseLong( String.valueOf( sobj ) );
                            rsValue.add( sStr );
                        }
                        else if( obj instanceof Double )
                        {
                            double sStr = Double.parseDouble( String.valueOf( sobj ) );
                            rsValue.add( sStr );
                        }
                        else if( obj instanceof Boolean )
                        {
                            boolean sStr = Boolean.valueOf( String.valueOf( sobj ) );
                            rsValue.add( sStr );
                        }
                        else if( sobj instanceof Map )
                        {
                          Iterator<JSONObject> csIterator = jsonArray.iterator();
                          while( csIterator.hasNext() )
                          {
                              JSONObject rsMapJson = htmlEscapeToJson( htmlEscapeType, csIterator.next().toJSONString() );
                              rsValue.add( rsMapJson );
                          }
                        }
                    }

                    cJson.put( sKey , rsValue );
                }
                else if( obj instanceof Map )
                {
                    JSONObject rsValue = htmlEscapeToJson( htmlEscapeType, String.valueOf( obj ) );
                    cJson.put( sKey , rsValue );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cJson;

    }

    /**
     *
     * @param jsonStr
     * @return
     */
    public static Map<String, Object> convertJsonStrToMap( String jsonStr )
    {
        Map<String, Object> rsMap = new HashMap<String, Object>();

        try {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = ( JSONObject ) jsonParser.parse( jsonStr );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rsMap;
    }




}
