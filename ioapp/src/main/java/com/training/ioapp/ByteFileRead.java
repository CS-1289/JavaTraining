package com.training.ioapp;

import java.io.*;
public class ByteFileRead
{
    public static void main( String[] args ) throws IOException
    {
        FileInputStream fis = new FileInputStream("C:\\Users\\10097443\\dover_data\\notes.txt");
        int data;
        while((data=fis.read())!=-1){
            System.out.print((char)data);
        }
        fis.close();
    }
}
