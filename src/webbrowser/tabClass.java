/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webbrowser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;
import static javax.swing.text.StyleConstants.Bold;

/**
 *
 * @author jimmy
 */
public class tabClass {

    ArrayList<String> urls;
    private TextField search;
    private ToolBar b;
    private Button back;
    private Button forward;
    private Button refresh;
    private Button bookmarks;
    private ComboBox combo;
    private ChoiceBox choice;
    BorderPane pane;
    WebView webView;
    WebEngine engine;
    Bookmark bookmark;
    HistoryClass history;

    public tabClass() {
        settings.defaultPage = "https://www.google.com";
        settings.description = "About MY\n" + "MY browser\n" + "(ver.1.8)(64-bit)\n" + "MY Terms of Service\n" + "Copyright 2019 MY Inc. All rights reserved.";
        urls = new ArrayList<String>();
        history = new HistoryClass();
        bookmark = new Bookmark();
        b = new ToolBar();
        search = new TextField();
        search.setPromptText("Enter your URL here....");
        search.setMinWidth(400);
        back = new Button("<-");
        forward = new Button("->");
        refresh = new Button("refresh");
        bookmarks = new Button("*");
        combo = new ComboBox();
        combo.setMaxWidth(6);
        choice = new ChoiceBox();
        b.getItems().addAll(back, forward, refresh, search, bookmarks, combo);
        pane = new BorderPane();
        webView = new WebView();
        engine = webView.getEngine();
        pane.setTop(b);
        pane.setCenter(webView);
        search.setOnAction(e -> Search());
        refresh.setOnAction(e -> refresh());
        back.setOnAction(e -> goBack());
        forward.setOnAction(e -> goForward());
        bookmarks.setOnAction(e -> bookmark.write(search.getText()));
        engine.load(settings.defaultPage);
        combo.setItems(engine.getHistory().getEntries());
        search.setText(settings.defaultPage);
        System.out.println("Tab class created");
        System.out.println(settings.description);
    }

    public void Search() {
        String searchBar;
        if (search.getText().substring(0, 7) == "https://") {
            searchBar = search.getText();
            engine.load(searchBar);
        } else {
            searchBar = "https://" + search.getText();
            engine.load(searchBar);

            search.setText(engine.getLocation());
        }
        urls.clear();
        for (Entry e : engine.getHistory().getEntries()) {
            urls.add(e.getUrl());
            history.write(urls);

            System.out.println(e.getUrl());
        }

    }

    public BorderPane getLayout() {
        return pane;
    }

    public void refresh() {
        engine.reload();
    }

    public void goBack() {
        engine.executeScript("history.back()");
    }

    public void goForward() {
        engine.executeScript("history.forward()");
    }
}
