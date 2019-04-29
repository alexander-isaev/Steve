package com.epam.javacore2019.steve2.db.dbstate;

import com.epam.javacore2019.steve2.db.server.DBServer;
import com.epam.javacore2019.steve2.db.server_old.DBApplication;
import com.epam.javacore2019.steve2.db.misc.DBConstants;
import com.epam.javacore2019.steve2.db.misc.Utils;
import com.epam.javacore2019.steve2.db.misc.DataHandler;
import com.epam.javacore2019.steve2.db.data.Table;
import com.epam.javacore2019.steve2.db.data.TableMetaData;

public class DBStateInit extends DBState {

    public DBStateInit(String name) {super(name);}

    @Override
    public void enter() {
        System.out.println("Entering DBInit state");
        initTables();
        try {
            DBServer.INSTANCE.start();
            DBApplication.INSTANCE.changeState(DBApplication.INSTANCE.stateRun);
        } catch (Exception ex) {
            ex.printStackTrace();
            DBApplication.INSTANCE.changeState(DBApplication.INSTANCE.stateStop);
        }
    }

    private void initTables() {
        // For each file cfg
        Utils.readDir(DBConstants.TABLE_DIR, new DataHandler() {
            @Override
            public void handleFile(String filePath) {
                TableMetaData metaData = TableMetaData.loadFromFile(filePath);
                Table table = new Table(metaData);
                table.load();
            }
        });
    }

    @Override
    public void onStop() {
        //check if everything is ok
        DBApplication.INSTANCE.changeState(DBApplication.INSTANCE.stateStop);
    }
}
