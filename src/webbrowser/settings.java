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
public class settings {

    public static String defaultPage;
    public static String description;

    public settings(String defaultPage) {
        this.defaultPage = defaultPage;
        this.description = "MY browser\n+" + "(ver.1.8)(64-bit\n)" + "MY Terms of Service\n";
    }

    public settings() {

    }

    public void setDefaultPage(String defaultPage) {
        this.defaultPage = defaultPage;
    }

    public String getDescription() {
        return description;
    }

}
