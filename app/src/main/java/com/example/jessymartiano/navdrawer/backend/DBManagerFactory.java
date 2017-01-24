package com.example.jessymartiano.navdrawer.backend;

import com.example.jessymartiano.navdrawer.data.*;
import com.example.jessymartiano.navdrawer.data.MySQL_DBManager;

/**
 * Created by David on 01/12/2016.
 */

public class DBManagerFactory {


        static DB_manager manager = null;

        public static DB_manager getManager() {
            if (manager == null) {
                manager = new MySQL_DBManager()
                {};
            }
            return manager;
        }

}
