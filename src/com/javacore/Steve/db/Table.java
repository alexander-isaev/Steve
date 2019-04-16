package com.javacore.Steve.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table {

    protected String name;

    protected List<String> columns;

    protected List<Record> records;

    {
        records = new ArrayList<Record>();
    }

    public Table(String name, List<String> columns) {
        this.name = name;
        this.columns = columns;
    }

    public void insert(Record record) {
        records.add(record);
    }

    // TODO:
    // SELECT id, firstName, lastName
    // It should get parameters like firstName or lastName.
    // IT ALSO SHOULD WORK WITH THREADS AND HAVE LOADING THING! i.e. it has to have thead.sleep.
    // SO IT WORK IN IT:S ON THREAD.
    public void select(String quert) {};

    // Print on screen while calling select method.
    // ID      firstName       lastName
    // ---------------------------------
    // 1       Vladimir        Trump

    // TODO: After that need to do select method in DataBase instead of here.
    // DS.query(SELECT ID, NAME EMAIL FROM CRIMINAL)
    // FROM - means from exact table. So we have to parse all these parameters in Strings.

    // DS.query(SELECT ID, NAME EMAIL FROM CRIMINAL WHERE ID = ?)


    public List<String> selectField(String fieldName) {
        int index = columns.indexOf(fieldName);
        Iterator it = records.iterator();
        List<String> result = new ArrayList<>();
        while(it.hasNext()) {
            Record r = (Record)it.next();
            result.add(r.values.get(index));
        }

        return result;
    }
}
