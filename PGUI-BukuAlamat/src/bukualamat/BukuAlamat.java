/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bukualamat;

import bukualamat.model.DataPersonal;
import bukualamat.view.EditDialogController;
import bukualamat.view.ViewBukuAlamatController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
*
* @author Ernando
*/
public class BukuAlamat extends Application {

//variabel kelas
private Stage stageAplikasi;
private BorderPane rootAplikasi;
private ObservableList<DataPersonal> dataperson = FXCollections.observableArrayList();


public BukuAlamat(){
    dataperson.add(new DataPersonal("Ernando", "Pratama"));
    dataperson.add(new DataPersonal("Budi", "Santoso"));
    dataperson.add(new DataPersonal("Ahmad", "Dahlan"));
    dataperson.add(new DataPersonal("Hasyim", "Asy'ari"));
    dataperson.add(new DataPersonal("Anies", "Baswedan"));
    dataperson.add(new DataPersonal("Ridwan", "Kamil"));
}

public ObservableList<DataPersonal> getDataPersonal(){
    return dataperson;
}




@Override
 public void start(Stage primaryStage){
 this.stageAplikasi = primaryStage;
 this.getStageAplikasi().setTitle("Buku Alamat");

  initGuiKerangka(); //fungsi untuk inisialisasi node dari Guikerangka.fxml
  initViewBukuAlamat();//fungsi inisialisasi node dari viewBukuAlamat
 }

 /**
 * @param args the command line arguments
 */
 public static void main(String[] args) {
 launch(args);
 }

 private void initGuiKerangka() {
    try {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(BukuAlamat.class.getResource("view/GuiKerangka.fxml"));
    rootAplikasi = (BorderPane)loader.load();

    Scene sceneAplikasi = new Scene(rootAplikasi);
            getStageAplikasi().setScene(sceneAplikasi);
            getStageAplikasi().show();
    } catch (IOException ex) {
     Logger.getLogger(BukuAlamat.class.getName()).log(Level.SEVERE, null, ex);
     }
 }

private void initViewBukuAlamat() {
    try {
     FXMLLoader loader = new FXMLLoader();
    loader.setLocation(BukuAlamat.class.getResource(
    "view/viewBukuAlamat.fxml"));
    AnchorPane guiIsi = (AnchorPane)loader.load();
    rootAplikasi.setCenter(guiIsi);
    
    ViewBukuAlamatController kontroler = loader.getController();
    kontroler.setKelasUtama(this);
    
    } catch (IOException ex) {
    Logger.getLogger(BukuAlamat.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    /**
     * @return the stageAplikasi
     */
    public Stage getStageAplikasi() {
        return stageAplikasi;
    }
    //metode untuk membuka edit dialog
    public boolean bukaEditDialog(DataPersonal person){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/EditDialog.fxml"));
            Parent root = loader.load();
            
            Stage editStage = new Stage();
            editStage.setTitle(" Edit Person ");
            editStage.initModality(Modality.WINDOW_MODAL);
            editStage.initOwner(stageAplikasi);
            
            Scene editScane = new Scene(root);
            editStage.setScene(editScane);
            
            //Set dataperson ke kontoler
            EditDialogController kontrol = loader.getController();
            kontrol.setDialogStage(editStage);
            kontrol.setPerson(person);
            
            editStage.showAndWait();
            return kontrol.isOkclicked();
            
    } catch (IOException ex) {
        Logger.getLogger(BukuAlamat.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }  
    }
}