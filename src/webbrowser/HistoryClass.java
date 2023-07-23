/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webbrowser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jimmy
 */
public class HistoryClass implements RW {

    FileWriter mFileWrite;
    FileReader mFileRead;
    File historyFile;
    FileOutputStream fop = null;

    public HistoryClass() {
        try {
            mFileWrite = new FileWriter("C:\\Users\\jimmy\\Desktop\\New folder\\history.txt", true);
        } catch (IOException ex) {
            Logger.getLogger(HistoryClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        historyFile = new File("C:\\Users\\jimmy\\Desktop\\New folder\\history.txt");
        try {
            fop = new FileOutputStream(historyFile);
            if (!historyFile.exists()) {
                try {
                    historyFile.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(HistoryClass.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistoryClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public char read() {
        try {
            mFileRead = new FileReader("C:\\Users\\jimmy\\Documents\\NetBeansProjects\\WebBrowser\\src\\webbrowser\\history.txt");
            int ch = 0;
            try {
                ch = mFileRead.read();
            } catch (IOException ex) {
                Logger.getLogger(HistoryClass.class.getName()).log(Level.SEVERE, null, ex);
            }

            char[] c = null;
            for (int i = 0; ch != -1; i++) {
                c[i] = (char) ch;
                return c[i];

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistoryClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ' ';

    }

    @Override
    public void write(ArrayList<String> urlsToSave) {

        try {
            mFileWrite = new FileWriter("C:\\Users\\jimmy\\Documents\\NetBeansProjects\\WebBrowser\\src\\webbrowser\\history.txt", false);

            for (String s : urlsToSave) {
                mFileWrite.write(s + ",");

            }
            mFileWrite.flush();
            mFileWrite.close();

        } catch (IOException ex) {
            Logger.getLogger(HistoryClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
