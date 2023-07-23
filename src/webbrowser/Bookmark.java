/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webbrowser;

/**
 *
 * @author jimmy
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author win10
 */
public class Bookmark {

    FileWriter mFileWrite;
    File BookmarkFile;
    FileOutputStream fop = null;

    public Bookmark() {
        try {
            mFileWrite = new FileWriter("C:\\Users\\jimmy\\Desktop\\New folder\\bookmark.txt", true);
        } catch (IOException ex) {
            Logger.getLogger(HistoryClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        BookmarkFile = new File("C:\\Users\\jimmy\\Desktop\\New folder\\bookmark.txt");
        try {
            fop = new FileOutputStream(BookmarkFile);
            if (!BookmarkFile.exists()) {
                try {
                    BookmarkFile.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Bookmark.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Bookmark.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void write(String url) {
        try {
            mFileWrite = new FileWriter("C:\\Users\\jimmy\\Documents\\NetBeansProjects\\WebBrowser\\src\\webbrowser\\bookmark.txt", true);
            mFileWrite.write(url);
            mFileWrite.flush();
            mFileWrite.close();
        } catch (IOException ex) {
            Logger.getLogger(Bookmark.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
 