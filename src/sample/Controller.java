package sample;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.net.URL;


public class Controller implements Initializable {


    public TextArea unosArtikala;
    public TextArea ispisArtikala;
    public ChoiceBox<Artikal> izborArtikla;
    public Spinner<Integer> kolicina;
    public TextArea racunLista;
    private Racun r = new Racun();
    private ArrayList<Artikal>a = new ArrayList<>();
    private ObservableList<Artikal> oList = FXCollections.observableArrayList();

    @Override
   public void initialize(URL location, ResourceBundle resources) {
       oList.setAll(a);
     izborArtikla.setItems(oList);
        SpinnerValueFactory<Integer> quantityValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        this.kolicina.setValueFactory(quantityValueFactory);

   }

    public void dodajArtikle(ActionEvent actionEvent) {

        String[] str = unosArtikala.getText().split("\n");

   for (String i : str) {
        a.add(new Artikal(i));

   }
    izborArtikla.getItems().clear();
   Artikal.izbaciDuplikate(a);

   String c ="";

   for(Artikal i : a){
       c = c + i + "\n";
   }
   ispisArtikala.setText(c);

//    int br = 0;
//     for(Artikal i : a){
//
//        if(br % 3 == 0){
//            izborArtikla.getItems().add(i);
//        }
//        br++;
//     }

    }



    public void dodaj(ActionEvent actionEvent) {
        Artikal odabir =  izborArtikla.getSelectionModel().getSelectedItem();

        int brojProizvoda = kolicina.getValue();
        r.ubaci(odabir,brojProizvoda);
    }
    private class Proizvod{
        int kol;
        Artikal artikal;
        Proizvod(){

        }
        Proizvod(Artikal artikal, int kol){
            artikal = artikal;
            kol = kol;
        }
    }
}
