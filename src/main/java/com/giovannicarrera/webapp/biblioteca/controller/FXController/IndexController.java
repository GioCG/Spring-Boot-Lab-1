package com.giovannicarrera.webapp.biblioteca.controller.FXController;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.giovannicarrera.webapp.biblioteca.system.Main;

import javafx.fxml.Initializable;
import lombok.Setter;

@Component
public class IndexController implements Initializable {

    @Setter
    private Main stage;

    //se ejecuta cada que se levanta la vista
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        
    }
}
