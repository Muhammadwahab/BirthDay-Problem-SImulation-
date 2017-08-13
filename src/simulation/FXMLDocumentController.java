/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Engr.Uzma
 */
public class FXMLDocumentController implements Initializable {
    
  
     
   
    @FXML
    
    
     public Button individualday;
      Parent root;
      public Button pair;

      static int number;
    
    public Button samebirth;
    
    public VBox vbox;
    private LineChart<?, ?> chart;
      public Button simulate,reset;
    public TextField NumberOfPeople,success,trials,probability;
    public ListView birthdates,sorted,result;
    PigenholePrinciple pigenholePrinciple=new PigenholePrinciple();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //assert simulate != null : "fx:id=\"simulate\" was not injected: check your FXML file 'simple.fxml'.";
        simulate.setOnAction((ActionEvent event) -> {
           // NumberOfPeople=new TextField();
            System.err.println(NumberOfPeople.getText());
            int ArrayBirthDates[]=pigenholePrinciple.getBirthDays(Integer.parseInt(NumberOfPeople.getText()));
          //  pigenholePrinciple.getBirthDays(Integer.parseInt(NumberOfPeople.getText()));
             
            String birth=Arrays.toString(ArrayBirthDates);
           
            String b[]=birth.split(",");
          //  System.err.println(b.toString());
           
            
             ObservableList<String> items =FXCollections.observableArrayList (b);
             birthdates.setItems(items);
             
              birth=Arrays.toString(pigenholePrinciple.sortedBithDates());
               b=birth.split(",");
             
              items =FXCollections.observableArrayList (b);
             sorted.setItems(items);
             

            
            
             probability.setText(String.valueOf(pigenholePrinciple.simulate()));
             
             ArrayList ArrayList = pigenholePrinciple.getResult();
              
             
             items =FXCollections.observableArrayList (ArrayList);
             result.setItems(items);
             
            trials.setText(String.valueOf(PigenholePrinciple.trails));
             success.setText(String.valueOf(PigenholePrinciple.succes));
            
            
            
        });
         
         reset.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                pigenholePrinciple=new PigenholePrinciple();
                result.setItems(null);
                sorted.setItems(null);
                birthdates.setItems(null);
                NumberOfPeople.clear();
                probability.clear();
                trials.clear();
                success.clear();
                PigenholePrinciple.succes=0;
                PigenholePrinciple.trails=0;
            }
        });
         
         samebirth.setOnAction((ActionEvent event) -> {
             //create a new scene with root and set the stage
             Stage stage;
             
              number=Integer.parseInt(NumberOfPeople.getText());
             stage=(Stage)samebirth.getScene().getWindow();
             try {
                 root = FXMLLoader.load(getClass().getResource("line.fxml"));
             } catch (IOException ex) {
                 System.err.println("exception in root"+ex);
             }
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.setTitle("Same Birth Day");
             stage.show();
        });
          individualday.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.err.println("indivual");
                //  PigenholePrinciple.sample(22);
                
                         
               Stage stage;
             
              number=Integer.parseInt(NumberOfPeople.getText());
             stage=(Stage)individualday.getScene().getWindow();
             try {
                 root = FXMLLoader.load(getClass().getResource("individual.fxml"));
             } catch (IOException ex) {
                 System.err.println("exception in root"+ex);
             }
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.setTitle("Diferent Probability");
             stage.show();
            }
        });
           pair.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.err.println("indivual");
               //   PigenholePrinciple.sample(22);
                
                         
               Stage stage;
             
              number=Integer.parseInt(NumberOfPeople.getText());
             stage=(Stage)pair.getScene().getWindow();
             try {
                 root = FXMLLoader.load(getClass().getResource("pair.fxml"));
             } catch (IOException ex) {
                 System.err.println("exception in root"+ex);
             }
             Scene scene = new Scene(root);
             stage.setScene(scene);
              stage.setTitle("Homogenous Probabilty");
             stage.show();
            }
        });
          
         
        
    }    
    
}
