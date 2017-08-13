/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Engr.Uzma
 */
public class PairController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML 
    LineChart chart;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        String arr[]=PigenholePrinciple.StringNumber();
        //System.out.println(Arrays.toString(arr));
         XYChart.Series series1 = new XYChart.Series();
           XYChart.Series series2 = new XYChart.Series();
        for(int i=0;i<FXMLDocumentController.number;i++)
        {
            series1.getData().add(new XYChart.Data(arr[i], PigenholePrinciple.sample(i)));
            series2.getData().add(new XYChart.Data(arr[i], 1-PigenholePrinciple.sample(i)));
        
        }
//            XYChart.Series series1 = new XYChart.Series();
//        series1.getData().add(new XYChart.Data("0", 0));
//        series1.getData().add(new XYChart.Data("1", 0.8));
//         series1.getData().add(new XYChart.Data("2", 0.8));
//          series1.getData().add(new XYChart.Data("3", 0.8));
//           series1.getData().add(new XYChart.Data("4", 0.8));
//            series1.getData().add(new XYChart.Data("5", 0.8));
        chart.getData().addAll(series1,series2);
    }    
    
}
