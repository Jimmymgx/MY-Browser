/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webbrowser;

import com.sun.javafx.scene.control.skin.TextFieldSkin;
import java.awt.AWTEventMulticaster;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import static sun.misc.Signal.handle;
import sun.plugin.javascript.navig.Anchor;
import static sun.plugin.javascript.navig.JSType.History;

/**
 *
 * @author jimmy
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    Tab tab;
    @FXML
    TabPane tabpane;
    @FXML
    Tab newTab;
    tabClass t = new tabClass();
    int counter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tab.setContent(t.getLayout());

        counter = 0;

    }

    public void handle(ActionEvent e) {
        if (newTab.isSelected()) {
            Tab tab1 = new Tab("new tab");
            tab1.setContent(t.getLayout());

            tabpane.getTabs().add(tabpane.getTabs().size(), tab1);
            tabpane.getTabs().add(newTab);
        }
    }
}
