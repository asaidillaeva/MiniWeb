package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;


public class Controller {
    @FXML
    private TextField searchTextField;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button searchButton;
    private WebEngine webBrowserEngine;

    @FXML
    private Label loadingLabel;

    @FXML
    private WebView mainWebView;
     @FXML
    void initialize(){
         webBrowserEngine = mainWebView.getEngine();
         loadingLabel.setText(" ");
         mainWebView.prefWidthProperty().bind(borderPane.widthProperty());
         mainWebView.prefHeightProperty().bind(borderPane.heightProperty());
     }
    public void searchTextFieldClicked(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER))
        {
            load();
        }
    }
    public String getUrl(String url){
        String prefix = url.substring(0, 7);
        if(!(prefix.equals("http://"))){
            url = "http://" + url;
        }

        return url;
    }


    public void searchButtonPressed(ActionEvent actionEvent) {
         load();
    }
    public void load(){
        String validUrl = getUrl(searchTextField.getText());
        webBrowserEngine.load(validUrl);
        searchTextField.setText(validUrl);
        loadingLabel.setText("Loading ...");
        webBrowserEngine.setOnStatusChanged(new EventHandler<WebEvent<String>>() {
            @Override
            public void handle(WebEvent<String> event) {
                loadingLabel.setText(" ");
            }
        });
    }
}
