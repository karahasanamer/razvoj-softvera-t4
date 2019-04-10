package sample;

import java.util.ArrayList;

public class Racun {

    private ArrayList<Proizvod>proizvodi;

    public Racun(){

        proizvodi = new ArrayList<>();
    }

    public void ubaci(Artikal artikal,int kol)
    {
        proizvodi.add(new Proizvod(artikal,kol));
    }

    public double vrijednost(){

        double rez = 0;
        for(Proizvod p : proizvodi){
            rez = rez + p.kol * p.artikal.getCijena();
        }
        return rez;
    }
    private class Proizvod{

        int kol;
        Artikal artikal;
        Proizvod(){}
        Proizvod(Artikal artikal, int kol){

            artikal = artikal;
            kol = kol;
        }


        public String toString(){
            String c = "";
            for(Proizvod p : proizvodi){
                c = c + String.format("%-8s %-4d %0.2f\n",p.artikal.getSifra(),p.kol,p.kol * p.artikal.getCijena());

            }
            c = c + String.format("%-8s %-4d %0.2f\n","Za platiti: ",vrijednost());
            return c;
        }

    }

}
