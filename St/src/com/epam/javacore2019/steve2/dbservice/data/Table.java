package com.epam.javacore2019.steve2.dbservice.data;

import com.epam.javacore2019.steve2.dbservice.misc.DataHandler;
import com.epam.javacore2019.steve2.dbservice.misc.Utils;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<TableRow> rows;
    private TableMetaData metaData;

    public Table(TableMetaData metaData) {
        this.metaData = metaData;
        rows = new ArrayList<>();
    }

    public void load() {
        Utils.readFileLineByLine(metaData.getPathToData(), new DataHandler() {
            @Override
            public void handleString(String line) {
                TableRow row = new TableRow();
                row.setValues(line);
                addRow(row);
            }
        });
        System.out.println(this.toString());
    }

    public void save() {

    }

    public void addRow(TableRow row) {
        rows.add(row);
    }

    @Override
    public String toString() {
        String result = "\n" + metaData.getTableName();
        result += "\nStructure file: " + metaData.getPathToStructure();
        result += "\nData file: " + metaData.getPathToData();
        result += "\n" + metaData.getColumns();
        result += "\nnumber of rows: " + rows.size();
        return result;
    }
}
