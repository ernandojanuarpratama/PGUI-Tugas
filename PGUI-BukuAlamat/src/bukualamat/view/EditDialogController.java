/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bukualamat.view;

import bukualamat.model.DataPersonal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO G40
 */
public class EditDialogController {

    @FXML
    private TextField inputNamaDepan;
    @FXML
    private TextField inputNamaBelakang;
    @FXML
    private TextField inputAlamat;
    @FXML
    private TextField inputKota;
    @FXML
    private TextField inputNoHp;

    private Stage dialogStage;
    private DataPersonal dataperson;
    private boolean okTerklik = false;
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
    }    
    //dengan metode ini, stage dari EditDialog bisa diakses dari kealas ini
    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }
    //fungsi setPerson ini menerima referensi data person dari kelas utama
    //melalui parameter pemanggian metode setPerson dari kelas utama
    public void setPerson(DataPersonal dataperson){
        this.dataperson = dataperson;
        inputNamaDepan.setText(dataperson.getNamaDepan());
        inputNamaBelakang.setText(dataperson.getNamaBelakang());
        inputAlamat.setText(dataperson.getAlamat());
        inputKota.setText(dataperson.getKotaKabupaten());
        inputNoHp.setText(dataperson.getNoHp());   
    }
    //metode berikut untuk mengetahui kondisi tombol "ok"
    public boolean isOkclicked(){
        return okTerklik;
    }
   @FXML
   private void batalkan(){
       dialogStage.close();
   }
   //metode berikut dijalankan kalau tombol OK ditekan
   //data pada Editdialog akan disimpan dalam List data personal
   @FXML
   private void jalankan(){
       if(isInputValid()){//cekdulu apakah inpunya valid
           dataperson.setNamaDepan(inputNamaDepan.getText());
           dataperson.setNamaBelakang(inputNamaBelakang.getText());
           dataperson.setAlamat(inputAlamat.getText());
           dataperson.setKotaKabupaten(inputKota.getText());
           dataperson.setNoHp(inputNoHp.getText());
           
           okTerklik = true;
           dialogStage.close();
       }
   }

    private boolean isInputValid() {
       String errorMessage = "";//teks yang akan ditampilkam kalau salah input
       if(inputNamaDepan.getText()==null ||
               inputNamaDepan.getText().length() == 0){
           //jika input nama depan kosong
           errorMessage += " Nama Depan Tidak Valid\n";
       }
       if(inputNamaBelakang.getText()==null ||
               inputNamaBelakang.getText().length() == 0){
           //jika input nama depan kosong
           errorMessage += " Nama Belakang Tidak Valid\n";
       }
       if(inputAlamat.getText()==null ||
               inputAlamat.getText().length() == 0){
           //jika input nama depan kosong
           errorMessage += " Alamat Tidak Valid\n";
       }
       if(inputKota.getText()==null ||
               inputKota.getText().length() == 0){
           //jika input nama depan kosong
           errorMessage += " Kota / Kabupaten Tidak Valid\n";
       }
       if(inputNoHp.getText()==null ||
               inputNoHp.getText().length() == 0){
           //jika input nama depan kosong
           errorMessage += " Nomor Hp Tidak Valid\n";
       }
       if(errorMessage.length() == 0){
           return true;
           //jika tidak ada error di atas, sehingga error message kosong
           //return true, sehingga fungsi jalankan() bisa melakukan menimpan data
       }else{//jika ada error
           //tampilkan dialog error
           Alert alert = new Alert(AlertType.ERROR);
           alert.initOwner(dialogStage);//menentukan window yang menampilkan error
           alert.setTitle(" Kesalahan Dalam Input ");
           alert.setHeaderText(" Silahkan Perbaiki Input Yang Masih Salah ");
           alert.setContentText(errorMessage);
           
           alert.showAndWait();
           
           return false;
       }
    }
}

    