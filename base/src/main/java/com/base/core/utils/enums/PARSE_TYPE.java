package com.base.core.utils.enums;

public enum PARSE_TYPE {
    NONE( 0, "NONE", " ")
    , PRICE( 1, "PRICE", "0")
    , ENC_STT_KEY( 2, "ENC_STT_KEY", "")
    , DEC_STT_KEY( 3, "DEC_STT_KEY", "")
    , ENC_CHG_KEY( 4, "ENC_CHG_KEY", "")
    , DEC_CHG_KEY( 5, "DEC_CHG_KEY", "")
    ;

    public int IDX;
    public String CODE;
    public String VALUE;
    private PARSE_TYPE( int idx, String code, String value) {
        this.IDX = idx;
        this.CODE = code;
        this.VALUE = value;
    }
}
