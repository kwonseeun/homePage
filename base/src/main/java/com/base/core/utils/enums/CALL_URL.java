package com.base.core.utils.enums;

import java.util.HashMap;
import java.util.Map;

public enum CALL_URL {

    BOARD_REGIST(1,"/boardRegistAction")
    , BOARD_LIST(2,"/boardList")
    ;

    private static Map<Integer, CALL_URL> map = new HashMap<Integer, CALL_URL>();
    private final int code;
    private final String url;
    private CALL_URL( int code, String url ) {
        this.code = code;
        this.url = url;
    }

    static {
        for( CALL_URL callUrl : CALL_URL.values() )
        {
            map.put( callUrl.code , callUrl );
        }
    }


    public int getCode() {
        return code;
    }

    public String getUrl() {
        return url;
    }

    public static CALL_URL valuesOf( int i )
    {
        return map.get( i );
    }

}
