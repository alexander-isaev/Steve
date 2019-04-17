package com.javacore.Steve.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Record {

    // Record in one line of database.
    // 12; Alexey; javaCourse
    List<String> values;
    List<String> columns;

    {
        values = new ArrayList<>();
    }

    public Record(Table table) {
        columns = table.getColumns();
    }

    public void setValues(String values) {
        this.values.clear();
        this.values = Arrays.asList(values);
    }

    public int getInt(String fieldName) throws FieldNotFoundExeption {
        int index = columns.indexOf(fieldName);

        if(index == -1) {
            throw new FieldNotFoundExeption("FIELD NOT FOUND " + fieldName);
        }
        return Integer.parseInt(values.get(index));
    }

    public boolean getBoolean(String fieldName) throws FieldNotFoundExeption {
        int index = columns.indexOf(fieldName);

        if(index == -1) {
            throw new FieldNotFoundExeption("FIELD NOT FOUND " + fieldName);
        }
        return Boolean.parseBoolean(values.get(index));
    }

    public class FieldNotFoundExeption extends Exception {
        public FieldNotFoundExeption(String mes) {
            super(mes);
        }
    }


}
