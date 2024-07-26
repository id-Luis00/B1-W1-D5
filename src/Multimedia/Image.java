package Multimedia;

import java.util.SortedMap;

public class Image extends MultimediaElement implements Show {

    private int brigthness;


    public Image(String title, int brigthness) {
        super(title);
        this.brigthness = brigthness;
    }

    public int getBrigthness() {
        return brigthness;
    }

    public void aumentaLuminosita() {
        this.brigthness++;
    }

    public void diminuisciLuminosita() {
        this.brigthness--;
    }


    @Override
    public String toString() {
        return "\nImmagine = {" +
                "\n titolo = '" + title + '\'' +
                "\n luminosità = '" + brigthness + '\'' +
                "\n}";
    }

    @Override
    public void show() {
        System.out.println("\n");
        System.out.print(this.title);
        for (int i = 0 ; i < this.brigthness; i++) {
            System.out.print("*");
        }


    }
}
