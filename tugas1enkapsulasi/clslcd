public class clslcd {
    private String Status, Cable;
    private int Brightness, Volume;

    public void turnon(){
        setStatus("On");
        setVolume(50);
        setBrightness(50);
        setCable("VGA");
    }

    public void turnoff(){
        setStatus("Off");
        setVolume(0);
        setBrightness(0);
        setCable("-");
    }

    public void freeze(){
        setStatus("Freeze");
    }

    public int VolumeUp(){
        Volume++;
        return Volume;
    }

    public int VolumeDown(){
        Volume--;
        return Volume;
    }

    public int setVolume(int volume){
        this.volume = Volume;
        return Volume;
    }

    public int BrightnessUp(){
        Brightness++;
        return Brightness;
    }

    public int BrightnessDown(){
        Brightness--;
        return Brightness;
    }

    public int setBrightness(int brightness){
        this.brightness = Brightness;
        return Brightness;
    }

    public void setCable(int cable){
        if (cable==1 && cable < 1 && cable > 4){
            Cable = "VGA";
        } else if (cable==2){
            Cable = "DVI";
        } else if (cable==3){
            Cable = "HDMI";
        } else if (cable==4){
            Cable = "Display Port";
        }
    }

    public String getStatus(){
        return Status;
    }

    public String getCable(){
        return Cable;
    }

    public int getVolume(){
        return Volume;
    }

    public int getBrightness(){
        return Brightness;
    }

    public void display(){
        System.out.println("LCD Status: " + Status);
        System.out.println("Volume: " + Volume);
        System.out.println("Brightness: " + Brightness);
        System.out.println("Cable: " + Cable);
    }

}
