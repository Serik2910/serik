package soap.start.serik.models;

import java.util.HashMap;
import java.util.Map;

public class Const {
    public static final String HED_SERVICE_ID = "EDS_TEMP_FILES";
    public static final String DOCUMENT_STATE_SERVICE_ID = "ESEDO_UNIVERSAL_SERVICE";
    public static final String DOCUMENT_STATE_ROUTE_ID = "R_ESEDO";
    public static final String SENDER_ID = "izipaq";
    public static final String SENDER_PASS = "izipaq2022";
    public static final String NSI_SERVICE_ID = "ENSI_SeGetDataGetItems";
    public static final String SENDER_ID_CRED = "izipaq";
    public static final String SENDER_ID_DICT = "izipaq";
    public static final String SENDER_PASS_CRED = "2G68JEVJ";
    public static final String SENDER_PASS_DICT = "07QiJe5y_L";
    public static final String ESEDO_ENDPOINT = "https://195.12.113.29/bip-sync-wss-gost/";

    private static Map<String, String> SERVICE_MAP = new HashMap<>();
    public static void addConst(String key, String value){
        SERVICE_MAP.put(key, value);
    }
    public static String getValue(String key){
        return SERVICE_MAP.get(key);
    }
}
