package com.epam.javacore2019.steve2.db.dbstate;

import com.epam.javacore2019.steve2.db.misc.*;

import java.util.ArrayList;
import java.util.List;

public class DBStateStop extends DBState {

    public DBStateStop(String name) {super(name);}

    @Override
    public void enter() {
        System.out.println("Entering DBStop state");

        List<String> list = new ArrayList<>();
        list.add("test string 145");
        list.add("test string two");
        DataEncryptor encryptor = new MainDataEncryptor();
        Utils.writeListToFile(list, DBConstants.DATA_DIR + "/test.dat", encryptor);

        Utils.readFileLineByLine(DBConstants.DATA_DIR + "/test.dat", new DataHandler() {
            @Override
            public void handleString(String line) {
                System.out.println(encryptor.decrypt(line));
            }
        });
    }

    @Override
    public void onStop() {
        System.out.println("Already trying to stop...");
    }
}
