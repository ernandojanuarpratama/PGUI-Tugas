package bukualamat.view;

import bukualamat.BukuAlamat;
import bukualamat.model.DataPersonal;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewBukuAlamatController {

    @FXML
    private TableView<DataPersonal> tabelPerson;

    @FXML
    private TableColumn<DataPersonal, String> kolomNamaDepan;

    @FXML
    private TableColumn<DataPersonal, String> kolomNamaBelakang;

    @FXML
    private Label labelNamaDepan;

    @FXML
    private Label labelNamaBelakang;

    @FXML
    private Label labelAlamat;

    @FXML
    private Label labelKota;

    @FXML
    private Label labelNoHp;
    
    //referensi kelas utama
    private BukuAlamat kelasUtama;
    
    //konstraktor
    public ViewBukuAlamatController(){
    }

    @FXML
    private void initialize(){
        kolomNamaDepan.setCellValueFactory(celldata->celldata.getValue().NamaDepanProperty());
        kolomNamaBelakang.setCellValueFactory(celldata->celldata.getValue().NamaBelakangProperty());
        //menghapus lihat detail
        lihatDetail(null);
        
        //menambahkan listener untuk mengetahui perubahan baris yang dipilih user
        //lalu menampilkan nilai baru pada detail person dengan memanggil
        //metode lihatdetail() dengan nilai person baru yang dipilih
        tabelPerson.getSelectionModel().selectedItemProperty().
                addListener((observable,personlama,personbaru)->lihatDetail(personbaru));
    }
    //metode setKelasUtama agar Kontroller terhubung dengan Kelas BukuAlamat
    //untuk referensi Kelas BukuAlamat ke variabel kelasUtama
    //sehingga bisa menambahkan ObservableList pada kelas utama ke variabel tabelperson di kelas ini
    //metode ini akan dipanggil di keals utama
    
    public void setKelasUtama(BukuAlamat bukualamat){
        this.kelasUtama = bukualamat;
        
        tabelPerson.setItems(kelasUtama.getDataPersonal());
    }
    
    private void lihatDetail(DataPersonal person){
        if (person != null){
            labelNamaDepan.setText(person.getNamaDepan());
            labelNamaBelakang.setText(person.getNamaBelakang());
            labelAlamat.setText(person.getAlamat());
            labelKota.setText(person.getKotaKabupaten());
            labelNoHp.setText(person.getNoHp());
        }else{
    //jika person mash null,hapus semua label
            labelNamaDepan.setText("");
            labelNamaBelakang.setText("");
            labelAlamat.setText("");
            labelKota.setText("");
            labelNoHp.setText("");
            }
    }
    
    //metode untuk menangani ketika tombol hapus diklik
    @FXML
    private void hapusPerson(){
        int indeksTerpilih = tabelPerson.getSelectionModel().getSelectedIndex();
        //tabelPerson.getItems().remove(indeksTerpilih);
        //kode di atas diganti dengan kode berikut
        if (indeksTerpilih >= 0){//jika ada yg dipilih
        tabelPerson.getItems().remove(indeksTerpilih);
    } else {
            //tidak ada data yg dipilih
            Alert alert = new Alert (AlertType.WARNING);
            alert.initOwner (kelasUtama.getStageAplikasi());
            alert.setTitle(" Tidak Ada Yang Dipilih !! ");
            alert.setHeaderText(" Tidak Ada Person Terpilih !! ");
            alert.setContentText(" Silahkan Pilih Nama Yang hendak Dihapus ");
            
            alert.showAndWait();
            }
        }
    
    //eventhandler untuk menangani perintah user yang mengklik tombol tambah
    @FXML
    private void tambahPerson(){
        DataPersonal tambahanperson = new DataPersonal();
        boolean okClicked = kelasUtama.bukaEditDialog(tambahanperson);
        if (okClicked){
            kelasUtama.getDataPersonal().add(tambahanperson);
        }
    }
    
    //eventhandler untuk menangani perintah user yang mengklik tombol "edit"
    @FXML
    private void editPerson(){
        DataPersonal personDipilih = tabelPerson.getSelectionModel().getSelectedItem();
        if(personDipilih != null){
            boolean okClicked = kelasUtama.bukaEditDialog(personDipilih);
            if(okClicked){
                lihatDetail(personDipilih);
            }
        }else{
            //Belum ada person yang dipilih
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(kelasUtama.getStageAplikasi());
            alert.setTitle(" Belum Ada Nama Yang Dipilih ");
            alert.setHeaderText(" Tidak Ada Person Yang Dipilih ");
            alert.setContentText(" Silahkan Pilih Nama Person pada Tabel Yang Hendak Diedit ");
            
            alert.showAndWait();
            
        }
    }
}
