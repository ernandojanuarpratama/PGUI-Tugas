/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextArea display;
    @FXML
    private Button btnCE;
    @FXML
    private Button btnC;
    @FXML
    private Button btnMinPlus;
    @FXML
    private Button btnBagi;
    @FXML
    private Button btnDelapan;
    @FXML
    private Button btnTujuh;
    @FXML
    private Button btnSembilan;
    @FXML
    private Button btnKali;
    @FXML
    private Button btnEmpat;
    @FXML
    private Button btnLima;
    @FXML
    private Button btnEnam;
    @FXML
    private Button btnTitik;
    @FXML
    private Button btnSatu;
    @FXML
    private Button btnDua;
    @FXML
    private Button btnTiga;
    @FXML
    private Button btnPlus;
    @FXML
    private Button btnNol;  
    @FXML
    private Button btnSamadengan;
    @FXML
    private Button btnMin;
private double angka1,angka2,hasil;
private String operasi,jawaban;
private int btnTitikClick;

 
@Override
public void initialize(URL url, ResourceBundle rb) {
// TODO
}
 @FXML
private void buttonClicked(ActionEvent event) {
if(event.getSource()== btnNol){ //cek apakah tombol yang ditekan adalah 0
if(!display.getText().isBlank()){ //cek, apakah display masih kosong
display.setText(display.getText() + "0"); //jika tidak kosong, tambahkan 0
}
}
//Input Angka
if(event.getSource()== btnSatu){
display.setText(display.getText() + "1");
}else if (event.getSource() == btnDua) {
display.setText(display.getText() + "2");
}else if (event.getSource() == btnTiga) {
display.setText(display.getText() + "3");
}else if (event.getSource() == btnEmpat) {
display.setText(display.getText() + "4");
}else if (event.getSource() == btnLima) {
display.setText(display.getText() + "5");
}else if (event.getSource() == btnEnam) {
display.setText(display.getText() + "6");
}else if (event.getSource() == btnTujuh) {
display.setText(display.getText() + "7");
}else if (event.getSource() == btnDelapan) {
display.setText(display.getText() + "8");
}else if (event.getSource() == btnSembilan) {
display.setText(display.getText() + "9");

//aksi
} if (event.getSource() == btnC) {
angka2=0;
hasil=0;
display.setText("");
btnTitikClick=0;
} else if (event.getSource() == btnCE) {
display.setText("");


//Proses
}if (event.getSource() == btnPlus) {
angka1 = Integer.parseInt(display.getText());
operasi = "plus";
display.setText("");
}else  if (event.getSource() == btnMin) {
angka1 = Integer.parseInt(display.getText());
operasi = "minus";
display.setText("");
}else if (event.getSource() == btnKali) {
angka1 = Integer.parseInt(display.getText());
operasi = "kali";
display.setText("");
}else if (event.getSource() == btnBagi) {
angka1 = Integer.parseInt(display.getText());
operasi = "bagi";
display.setText("");
} else if (event.getSource() == btnTitik) {
display.setText(display.getText()+ btnTitik.getText());
btnTitikClick=1;
} else if (event.getSource() == btnMinPlus)  {
double ops = Double.parseDouble(String.valueOf(display.getText()));
ops = ops *(-1);
display.setText(String.valueOf(ops));
btnTitikClick=0;
}
//hasil
else if (event.getSource() == btnSamadengan) {
angka2 = Integer.parseInt(display.getText());
if (operasi.equals("plus")) {
hasil = angka1 + angka2;
}if (operasi.equals("plus")) {
hasil = angka1 + angka2;
}
if (operasi.equals("minus")) {
hasil = angka1 - angka2;
}
if (operasi.equals("kali")) {
hasil = angka1 * angka2;
}
if (operasi.equals("bagi")) {
hasil = angka1 / angka2;
}
    
display.setText(String.valueOf(hasil));
operasi = "netral";
}
}
}