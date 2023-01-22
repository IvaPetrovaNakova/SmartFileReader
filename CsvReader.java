package io;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.CharBuffer;

public class CsvReader<T> implements Closeable, Readable {

    private int numberOfRows;
    private int numberOfColumn;



//So 6 possible constructors in total.

    //char getRecordDelimiter()



    //String[] getHeaderRow() – get the first row String[]

    public int getNumberOfRows() {
        return numberOfRows;
    }

    //int getColumnsCount() – Get the total number of columns
    public int getColumnCount() {
        return numberOfColumn;
    }


     //int getRecordsCount() – Get the total number of rows
    public int getRecordsCount() {
        //TODO
        return numberOfRows;
    }

    //Map get(i) – Get the i-th record – key,value by the header

    //rowMap get(columnHeader) – Get the record, identified by the given header column

    //CSVIterator iterator = new CSVIterator(reader);
    //for(String[] nextLine : iterator) {
    // or for(String[] nextLine : reader.iterator())
    //{

    @Override
    public void close() throws IOException {}

    @Override
    public int read(CharBuffer cb) throws IOException {
        return 0;
    }
}
