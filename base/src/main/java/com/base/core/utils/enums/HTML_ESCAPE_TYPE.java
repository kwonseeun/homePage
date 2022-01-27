package com.base.core.utils.enums;

import java.util.HashMap;
import java.util.Map;

public enum HTML_ESCAPE_TYPE {

    UN_ESCAPE("UN_ESCAPE")
    {
        @Override
        public String toString() {
            return "UN_ESCAPE";
        }
    }
    , ESCAPE("ESCAPE")
    {
        @Override
        public String toString() {
            return "ESCAPE";
        }
    }
    , NONE("NONE")
    {
        @Override
        public String toString() {
            return "NONE";
        }
    }
    ;

    private static Map<String, HTML_ESCAPE_TYPE> map = new HashMap<String, HTML_ESCAPE_TYPE>();
    private final String code;
    private HTML_ESCAPE_TYPE( String code ) {
        this.code = code;
    }

    static
    {
        for( HTML_ESCAPE_TYPE result : HTML_ESCAPE_TYPE.values() )
        {
            map.put( result.code , result );
        }
    }

    public String getCode() {
        return code;
    }

    public static HTML_ESCAPE_TYPE setStatus( String code )
    {
        return map.get( code );
    }

}
