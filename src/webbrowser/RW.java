/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webbrowser;

import java.util.ArrayList;

/**
 *
 * @author jimmy
 */
public interface RW {
   char read();
   void write(ArrayList<String> urlsToSave);
}
