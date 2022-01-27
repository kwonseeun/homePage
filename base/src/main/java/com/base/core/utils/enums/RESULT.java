package com.base.core.utils.enums;

import java.util.HashMap;
import java.util.Map;

public enum RESULT {
    SUCCESS("0000")		/** result code success */
    {
        @Override
        public String toString() {
            return "0000";
        }
    }
    , ERROR("9999")		/** result code system error */
    {
        @Override
        public String toString() {
            return "9999";
        }
    }
    , E9000("9000")		/** result code error */
    {
        @Override
        public String toString() {
            return "9000";
        }
    }
    ;

    private static Map<String, RESULT> map = new HashMap<String, RESULT>();
    private final String code;
    private RESULT( String code ) {
        this.code = code;
    }

    static
    {
        for( RESULT result : RESULT.values() )
        {
            map.put( result.code , result );
        }
    }

    public String getCode() {
        return code;
    }

    public static RESULT setStatus( String code )
    {
        return map.get( code );
    }


}
