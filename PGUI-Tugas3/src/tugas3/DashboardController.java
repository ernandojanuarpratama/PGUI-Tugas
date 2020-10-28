/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class DashboardController implements Initializable {

    @FXML
    private Label textNama;
    @FXML
    private Text textHnama;
    @FXML
    private Text textHtelepon;
    @FXML
    private Text textHalamat;
    @FXML
    private Label textTelepon;
    @FXML
    private Label textAlamat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    void showInformation(String Nama, String Telepon, String Alamat) {
       textHnama.setText(Nama);
       textHtelepon.setText(Telepon);
       textHalamat.setText(Alamat);
    }
    
}
