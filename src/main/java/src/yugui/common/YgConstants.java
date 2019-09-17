package src.yugui.common;

import java.util.HashMap;
import java.util.Map;

public class YgConstants {

    public static final int AGENCY_FACTORY_TYPE = 1;
    public static final int AGENCY_WAREHOUSE_TYPE = 2;
    public static final int AGENCY_PHARMACY_TYPE = 3;

    public static final String LOGIN_USER = "loginUser";
    public static final String USER_TOKEN = "token";
    public static final String USER_SIG = "sig";
    public static final String USER_AUTHORITY = "userAuthority";
    public static final String USER_Menu = "userMenu";
    public static final int UNKNOWN_USER_ID = 0;

    public static final String DEFAULT_PAGE_SIZE = "100";
    public static final String DEFAULT_PAGE_NUM = "1";
    public static final String BOXCODE_PAGE_SIZE = "10";

    public static final String GS1_CODE_SEPERATOR = "\u001d";
    public static final String GS1_GTIN_CODE = "01";

    public static final Map<String, Integer> REQUTEST_METHOD_MAP;

    static {
        //pharm code
        REQUTEST_METHOD_MAP = new HashMap<>();

        //request method map
        REQUTEST_METHOD_MAP.put("POST", 1);
        REQUTEST_METHOD_MAP.put("DELETE", 2);
        REQUTEST_METHOD_MAP.put("PUT", 3);
        REQUTEST_METHOD_MAP.put("GET", 4);
    }

    private YgConstants(){}
}
