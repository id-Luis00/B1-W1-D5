import Multimedia.AudioRecord;
import Multimedia.Image;
import Multimedia.MultimediaElement;
import Multimedia.Video;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String risp = "";
        Scanner s = new Scanner(System.in);
        MultimediaElement[] elementi = new MultimediaElement[5];
        System.out.println("\nCiao, vuoi inserire contenuti multimediali? si/no\nPuoi inserire un massimo di 5 elementi ");
        risp = s.nextLine();


        if (risp.toLowerCase().equals("si")) {
            for (int i = 0; i < elementi.length; i++) {
                System.out.println("Quale contenuto multimediale vuoi inserire? \n1 - Immagine\n2 - Video\n3 - Registrazione audio\nPremere 0 per uscire");
                risp = s.nextLine();

                switch (risp) {
                    case "1":
                        System.out.println("Inserisci titolo dell'immagine: ");
                        String imgTitle = s.nextLine();
                        System.out.println("Inserisci la luminosità base: ");
                        int brigth = s.nextInt();
                        s.nextLine();
                        elementi[i] = new Image(imgTitle, brigth);
                        break;
                    case "2":
                        System.out.println("Inserisci titolo del video: ");
                        String videoTitle = s.nextLine();
                        System.out.println("Inserisci durata del video: ");
                        int videoDuration = s.nextInt();
                        System.out.println("Inserisci il volume di base: ");
                        int videoVolume = s.nextInt();
                        System.out.println("Inserisci la luminosità di base: ");
                        int videoBrigth = s.nextInt();
                        s.nextLine();
                        elementi[i] = new Video(videoTitle, videoDuration, videoVolume, videoBrigth);
                        break;

                    case "3":
                        System.out.println("Inserisci titolo dell'audio: ");
                        String title = s.nextLine();

                        System.out.println("Inserisci durata audio: ");
                        int duration = s.nextInt();

                        System.out.println("Inserisci il volume di base: ");
                        int volume = s.nextInt();
                        s.nextLine();
                        elementi[i] = new AudioRecord(title, duration, volume);
                        break;
                    default:
                        break;

                }

                if (risp.equals("0")) {
//                    System.out.println("Arrivederci!!!");
                    break;
                }

            }


        } else if (risp.toLowerCase().equals("no")) {
            System.out.println("va bene :c\n ci vediamo...");
        }

        System.out.println("\nGrazie!\n\nVuoi vedere la tua lista di contenuti multimediali? si/no");
        risp = s.nextLine();

        if (risp.toLowerCase().equals("si")) {
            for (int i = 0; i < elementi.length; i++) {
                MultimediaElement obj = elementi[i];
                if (obj != null) {
                    System.out.println("\n" + (i + 1) + " : " + obj);
                } else {
                    System.out.println("\n" + (i + 1) + " : Spazio vuoto, nessun elemento trovato!\n");
                }
            }
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Vuoi effettuare azioni sugli elementi? si/no");
        risp = s.nextLine();

        if (risp.toLowerCase().equals("si")) {

            while (true) {
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.println("su quale elemento multimediale vuoi effettuare un azione?    premere 0 per uscire");
                for (int i = 0; i < elementi.length; i++) {
                    MultimediaElement obj = elementi[i];
                    if (obj != null) {
                        System.out.println("\n" + (i + 1) + " : " + obj);
                    }
                }
                System.out.println("\n");
                int rispInt = Integer.parseInt(s.nextLine());
                if (rispInt == 0) break;

                if (elementi[rispInt - 1] instanceof AudioRecord) {
                    System.out.println("------------------------------------------------------------------------------------------");
                    System.out.println("Le azioni disponibili sono:\n1 - aumenta volume\n2 - diminuisci volume\n3 - Play!\n");

                    int action = s.nextInt();
                    s.nextLine();

                    switch (action) {
                        case 1:
                            ((AudioRecord) elementi[rispInt - 1]).alzaVolume();
                            System.out.println("Volume aumentato!\n");
                            System.out.println(((AudioRecord) elementi[rispInt - 1]).getVolume());
                            break;
                        case 2:
                            ((AudioRecord) elementi[rispInt - 1]).abbassaVolume();
                            System.out.println("Volume abbassato!\n");
                            break;
                        case 3:
                            ((AudioRecord) elementi[rispInt - 1]).play();
                            System.out.println("Azione play effettuata!\n");
                            break;
                        default:
                            break;
                    }
                } else if (elementi[rispInt - 1] instanceof Video) {
                    System.out.println("------------------------------------------------------------------------------------------");
                    System.out.println("Le azioni disponibili sono:\n1 - aumenta volume\n2 - diminuisci volume\n3 - aumenta luminosità\n4 - diminuisci luminosità\n5 - Play!\n");

                    int action = s.nextInt();
                    s.nextLine();

                    switch (action) {
                        case 1:
                            ((Video) elementi[rispInt - 1]).alzaVolume();
                            System.out.println("Volume aumentato!\n");

                            break;
                        case 2:
                            ((Video) elementi[rispInt - 1]).abbassaVolume();
                            System.out.println("Volume abbassato!\n");
                            break;
                        case 3:
                            ((Video) elementi[rispInt - 1]).aumentaLuminosita();
                            System.out.println("Luminosità aumentata!\n");
                            break;
                        case 4:
                            ((Video) elementi[rispInt - 1]).diminuisciLuminosita();
                            System.out.println("Luminosità diminuita!\n");
                            break;
                        case 5:
                            ((Video) elementi[rispInt - 1]).play();
                            System.out.println("Azione play effettuata!\n");
                            break;
                        default:
                            break;
                    }
                } else if (elementi[rispInt - 1] instanceof Image) {

                    System.out.println("------------------------------------------------------------------------------------------");
                    System.out.println("Le azioni disponibili sono:\n1 - aumenta luminosità\n2 - diminuisci luminosità\n3 - show!\n");

                    int action = s.nextInt();
                    s.nextLine();

                    switch (action) {
                        case 1:
                            ((Image) elementi[rispInt - 1]).aumentaLuminosita();
                            System.out.println("Volume aumentato!\n");
                            break;
                        case 2:
                            ((Image) elementi[rispInt - 1]).aumentaLuminosita();
                            System.out.println("Volume abbassato!\n");
                            break;
                        case 3:
                            ((Image) elementi[rispInt - 1]).show();
                            System.out.println("Azione show effettuata!\n");
                            break;
                        default:
                            break;
                    }

                }
            }


        }

        // si

        /* su quale elemento vuoi effettuare un'azione?
         * lista elementi...
         *
         *
         *
         *  */


        /* hai selezionato l'elemento <title>, è <typeObject>
         *
         * quale azione vuoi effettuare?
         *
         * (esempio di immagine)
         *
         * - aumenta la luminosità...
         * - diminuisci la luminosità...
         * - show...
         *
         *
         *
         * */

//        for (MultimediaElement obj : elementi) {
//
//            if (obj instanceof AudioRecord) ((AudioRecord) obj).play();
//            if (obj instanceof Video) ((Video) obj).play();
//
//        }


        s.close();
    }
}