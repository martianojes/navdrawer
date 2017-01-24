package com.example.jessymartiano.navdrawer.backend;

import android.net.Uri;

/**
 * Created by David on 12/12/2016.
 */

public class AcademyContract {

    /**
     * The authority for the contacts provider
     */
    public static final String AUTHORITY = "com.david.academy";
    /**
     * A content:// style uri to the authority for the contacts provider
     */
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    public static class Activity {
        public static final String ACTIVITY_ID = "_id";
        public static final String ACTIVITY_TYPE = "type";
        public static final String ACTIVITY_COUNTRY = "country";
        public static final String ACTIVITY_BEGIN = "begin";
        public static final String ACTIVITY_END = "end";
        public static final String ACTIVITY_PRICE = "price";
        public static final String ACTIVITY_EXPLANATION = "explanation";

        /**
         * The content:// style URI for this table
         */
        public static final Uri ACTIVITY_URI = Uri.withAppendedPath(AUTHORITY_URI, "activities");
    }

    public static class Business {
        public static final String BUSINESS_ID = "_id";
        public static final String BUSINESS_NAME = "name";
        public static final String BUSINESS_COUNTRY = "country";
        public static final String BUSINESS_STREET = "street";
        public static final String BUSINESS_PHONE = "phone";
        public static final String BUSINESS_MAIL = "mail";
        public static final String BUSINESS_WEBSITE = "website";



        /**
         * The content:// style URI for this table
         */
        public static final Uri BUSINESS_URI = Uri.withAppendedPath(AUTHORITY_URI, "business");
    }

    public static class User {
        public static final String USER_ID = "_id";
        public static final String USER_USERNAME = "username";
        public static final String USER_PASSWORD = "password";

        /**
         * The content:// style URI for this table
         */
        public static final Uri USER_URI = Uri.withAppendedPath(AUTHORITY_URI, "users");
    }
}
