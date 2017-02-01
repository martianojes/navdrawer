package com.example.jessymartiano.navdrawer.backend;

import com.example.jessymartiano.navdrawer.data.ListDatabase;

/**
 * Created by David on 12/12/2016.
 */

public class DBManagerFactory {


        static DB_manager manager = null;

        public static DB_manager getManager() {
            if (manager == null) {
                manager = new ListDatabase()
                {};
            }
            return manager;
        }

}
