
package bukualamat.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author LENOVO G40
 */
public class DataPersonal {

    private StringProperty namadepan = new SimpleStringProperty();
    private StringProperty namabelakang = new SimpleStringProperty();
    private StringProperty alamat = new SimpleStringProperty();
    private StringProperty kotakabupaten = new SimpleStringProperty();
    private StringProperty nohp = new SimpleStringProperty();

    public DataPersonal() {
    }
    
    public DataPersonal(String NamaDepan, String NamaBelakang) {
        //inisialisasi dari parameter
        this.namadepan = new SimpleStringProperty(NamaDepan);
        this.namabelakang = new SimpleStringProperty(NamaBelakang);
        //inisialisasi dengan nilai (untuk tes)
        this.alamat = new SimpleStringProperty("Suatu Alamat " + NamaDepan);
        this.kotakabupaten = new SimpleStringProperty("Suatu Kota " + NamaDepan);
        this.nohp = new SimpleStringProperty("08777 " + NamaDepan);
       
    }

    public String getNoHp() {
        return nohp.get();
    }

    public void setNoHp(String value) {
        nohp.set(value);
    }

    public StringProperty NoHpProperty() {
        return nohp;
    }

    public String getKotaKabupaten() {
        return kotakabupaten.get();
    }

    public void setKotaKabupaten(String value) {
        kotakabupaten.set(value);
    }

    public StringProperty KotaKabupatenProperty() {
        return kotakabupaten;
    }

    public String getAlamat() {
        return alamat.get();
    }

    public void setAlamat(String value) {
        alamat.set(value);
    }

    public StringProperty AlamatProperty() {
        return alamat;
    }

    public String getNamaBelakang() {
        return namabelakang.get();
    }

    public void setNamaBelakang(String value) {
        namabelakang.set(value);
    }

    public StringProperty NamaBelakangProperty() {
        return namabelakang;
    }
    
    public String getNamaDepan() {
        return namadepan.get();
    }

    public void setNamaDepan(String value) {
        namadepan.set(value);
    }

    public StringProperty NamaDepanProperty() {
        return namadepan;
    }
    
}
