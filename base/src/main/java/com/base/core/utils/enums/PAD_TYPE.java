package com.base.core.utils.enums;

import java.util.HashMap;
import java.util.Map;

public enum PAD_TYPE {
      RPAD(1)
    , LPAD(2)
    ;

    private static Map<Integer, PAD_TYPE> map = new HashMap<Integer, PAD_TYPE>();
    private final int code;
    private PAD_TYPE( int code ) {
        this.code = code;
    }

    static {
        for( PAD_TYPE padType : PAD_TYPE.values() )
        {
            map.put( padType.code , padType );
        }
    }


    public int getCode() {
        return code;
    }

    public static PAD_TYPE valuesOf( int i )
    {
        return map.get( i );
    }

}
