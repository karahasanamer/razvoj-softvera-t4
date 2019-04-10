package sample;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
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

   }

    public void dodajArtikle(ActionEvent actionEvent) {



        String[] str = unosArtikala.getText().split("\n");

   for (String i : str) {
        a.add(new Artikal(i));

   }

   Artikal.izbaciDuplikate(a);

   String c ="";

   for(Artikal i : a){
       c = c + i + "\n";
   }
   ispisArtikala.setText(c);




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
