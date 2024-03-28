package objekk;

import kelas.clslcd;

public class objlcd {
    public static void main(String[] args) {
        clslcd lcd1 = new clslcd();
        clslcd lcd2 = new clslcd();
        clslcd lcd3 = new clslcd();

        lcd1.turnon();
        lcd1.VolumeUp();
        lcd1.setVolume(41);
        lcd1.VolumeDown();
        lcd1.BrightnessUp();
        lcd1.setBrightness(61);
        lcd1.BrightnessDown();
        lcd1.setCable(2);

        lcd1.display();

        lcd2.turnon();
        lcd2.freeze();
        lcd2.VolumeUp();
        lcd2.setBrightness(21);
        lcd2.setVolume(92);
        lcd2.VolumeDown();
        lcd2.BrightnessUp();
        lcd2.setBrightness(58);
        lcd2.BrightnessDown();
        lcd2.setCable(3);

        lcd2.display();

        lcd3.turnon();
        lcd3.VolumeUp();
        lcd3.setVolume(67);
        lcd3.BrightnessDown();
        lcd3.VolumeDown();
        lcd3.VolumeDown();
        lcd3.BrightnessUp();
        lcd3.setBrightness(93);
        lcd3.BrightnessDown();
        lcd3.BrightnessDown();
        lcd3.BrightnessDown();
        lcd3.setVolume(65);
        lcd3.setCable(6);
        lcd3.turnoff();

        lcd3.display();
    }

    @Override
    public String toString() {
        return "objlcd []";
    }
}
