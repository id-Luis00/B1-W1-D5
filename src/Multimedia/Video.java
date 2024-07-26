package Multimedia;

public class Video extends MultimediaElement implements Play {

    private int duration;
    private int volume;
    private int brightness;
    private final boolean playable = true;


    public Video(String title, int duration, int volume, int brightness) {
        super(title);
        this.duration = duration;
        this.volume = volume;
        this.brightness = brightness;
    }

    public int getDuration() {
        return duration;
    }

    public void alzaVolume() {
        this.volume++;
    }

    public void abbassaVolume() {
        this.volume--;
    }

    public void aumentaLuminosita() {
        this.brightness++;
    }

    public void diminuisciLuminosita() {
        this.brightness--;
    }

    @Override
    public String toString() {
        return "\nVideo = {" +
                "\ntitolo = '" + title + '\'' +
                "\ndurata = " + duration +
                "\nvolume = " + volume +
                "\nluminosità = " + brightness +
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
                for (int h = 0; h < this.brightness; h++) {
                    System.out.print("*");
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
                for (int h = 0; h < this.brightness; h++) {
                    System.out.print("*");
                }
                System.out.println("\n");
            }
        }

    }
}
