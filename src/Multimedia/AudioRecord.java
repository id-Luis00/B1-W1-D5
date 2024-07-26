package Multimedia;

public class AudioRecord extends MultimediaElement implements Play {

    private int duration;
    private int volume;
    private boolean playable = true;


    public AudioRecord(String title, int duration, int volume) {
        super(title);
        this.duration = duration;
        this.volume = volume;
    }

    public int getDuration() {
        return duration;
    }

    public int getVolume() {
        return volume;
    }

    public void alzaVolume() {
        this.volume++;
    }

    public void abbassaVolume() {
        this.volume--;
    }


    @Override
    public String toString() {
        return "\nAudio = {" +
                "\ntitolo = '" + title + '\'' +
                "\ndurata = " + duration +
                "\nvolume = " + volume +

                "\n}";
    }

    @Override
    public void play() {
        System.out.println("\n");

        if (this.volume <= 10) {
            for (int i = 0; i < this.duration; i++) {
                System.out.print(this.title);
                for (int j = 0; j < this.volume; j++) {
                    System.out.print("!");
                }
                System.out.println("\n");
            }

        } else if (this.volume > 10) {
            this.volume = 10;
            for (int i = 0; i < this.duration; i++) {
                System.out.print(this.title);
                for (int j = 0; j < this.volume; j++) {
                    System.out.print("!");
                }
            }
        }

    }
}
