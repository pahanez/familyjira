package com.pahanez.familytask.auth;

public class AccountGeneral {

    /**
     * Account type id
     */
    public static final String ACCOUNT_TYPE = "com.pahanez.familytask";

    /**
     * Account name
     */
    public static final String ACCOUNT_NAME = "FamilyTask";

    public static final String APPLICATION_ID = "qmvLuipc58hRQftCqRWx0R9xbVQMAwlsNt0Bfy4L";
    public static final String REST_API_ID = "oFFBEvq75OJZ40er1LxfcVAhzymqMIt0YcNpuKxl";

    /**
     * Auth token types
     */
    public static final String AUTHTOKEN_TYPE_READ_ONLY = "Read only";
    public static final String AUTHTOKEN_TYPE_READ_ONLY_LABEL = "Read only access to an Udinic account";

    public static final String AUTHTOKEN_TYPE_FULL_ACCESS = "Full access";
    public static final String AUTHTOKEN_TYPE_FULL_ACCESS_LABEL = "Full access to an Udinic account";

    public static final AuthenticateServer sServerAuthenticate = new ParseComServerAuthenticate();
}
