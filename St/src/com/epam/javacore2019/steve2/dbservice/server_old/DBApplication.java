package com.epam.javacore2019.steve2.dbservice.server_old;

import com.epam.javacore2019.steve2.dbservice.data.QueryResult;
import com.epam.javacore2019.steve2.dbservice.dbstate.DBState;
import com.epam.javacore2019.steve2.dbservice.dbstate.DBStateInit;
import com.epam.javacore2019.steve2.dbservice.dbstate.DBStateRunning;
import com.epam.javacore2019.steve2.dbservice.dbstate.DBStateStop;

public enum DBApplication {
    INSTANCE;

    public enum DataEncryptionLevel {LOW, MED, HIGH}
    public static final DataEncryptionLevel DATA_ENCRYPTION_LEVEL = DataEncryptionLevel.LOW;
    private DBState currentState;
    public DBState stateInit = new DBStateInit("Init");
    public DBState stateRun = new DBStateRunning("Running");
    public DBState stateStop = new DBStateStop("Stop");

    public void start() {
        changeState(stateInit);
    }

    public String getStateName() { return currentState.getName(); }

    public void stop() {
        currentState.onStop();
    }

    public QueryResult query(String query) {
        return null;
    }

    public void changeState(DBState state) {
        if (currentState != null) {
            if (currentState.equals(state)) {
                return;
            } else {
                currentState.exit();
            }
        }
        currentState = state;
        currentState.enter();
    }

}
