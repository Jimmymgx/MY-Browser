/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webbrowser;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
/**
 *
 * @author jimmy
 */
public class FXMLController implements Initializable{

   @FXML private WebView webView;
    private WebEngine engine;
    @FXML private TextField x;
    @FXML private Button tab;
    @FXML private Button newTab;
    @FXML private ToolBar tabs;
    @FXML private TabPane p; 
    @FXML private ToolBar bar;
    @FXML private ButtonBar b;
    @FXML private HBox h=new HBox(5);
    @FXML private ComboBox c;
    
    WebHistory history;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        engine = webView.getEngine();
        engine.load("https://www.google.com");
        history = engine.getHistory();
        c.setItems(history.getEntries());
    }
    
    public void Search(ActionEvent e){
        String searchBar = "https://"+ x.getText();
        engine.load(searchBar);
        String siteName = x.getText();
        tab.setText(siteName.substring(4, siteName.length()-4));
        history = engine.getHistory();
        c.setItems(history.getEntries());
    }
    public void refresh(ActionEvent e){
        engine.reload();
    }
    public void newTab(ActionEvent e){
        Button m = new Button("new tab");
        h.getChildren().add(m);
    }
     
      
    public void goBack(ActionEvent e) {
		engine.getHistory().go(history.getEntries().size() > 1 && engine.getHistory().getCurrentIndex() > 0 ? -1 : 0);
		//System.out.println(history.getCurrentIndex() + "," + historyEntryList.size())
	}
    public void goForward(ActionEvent e){
        engine.getHistory().go(history.getEntries().size()>1&&engine.getHistory().getCurrentIndex()>0 ? 1 :0);
    }
}
