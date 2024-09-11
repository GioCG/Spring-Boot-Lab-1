package com.giovannicarrera.webapp.biblioteca.system;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.giovannicarrera.webapp.biblioteca.Biblioteca313Application;
import com.giovannicarrera.webapp.biblioteca.controller.FXController.IndexController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    //atributos
    private ConfigurableApplicationContext applicationContext;
    private Stage stage;
    private Scene scene;
    //se ejecuta cada vez que se instancia la clase Main
    @Override
    public void init(){
        this.applicationContext = new SpringApplicationBuilder(Biblioteca313Application.class).run();
    }
    //Se ejecuta al iniciar la aplicacion de javaFX
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        stage.setTitle("Biblioteca Springboot");
        //carga la escena principal
        indexView();
        stage.show();
    }

    //metodo para cambiar la escena del stage
    public Initializable switchEscen(String fxmlName, int width, int height) throws IOException{
        Initializable initializable = null;
        FXMLLoader loader = new FXMLLoader();

        loader.setControllerFactory(applicationContext::getBean);
        InputStream archivo = Main.class.getResourceAsStream("/templates/" + fxmlName);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource("/templates/" + fxmlName));
        
        scene = new Scene((AnchorPane)loader.load(archivo), width,height);
        stage.setScene(scene);
        stage.sizeToScene();

        initializable = (Initializable)loader.getController();

        return initializable;
    }

    //metodo para mostrar el index
    public void indexView(){
        try {
            IndexController indexView = (IndexController)switchEscen("index.fxml",600,400);
            indexView.setStage(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
