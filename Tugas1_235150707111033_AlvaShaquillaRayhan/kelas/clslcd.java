package kelas;

public class clslcd {
    private String Status, Cable;
    private int Brightness, Volume;

    public void turnon(){
        setStatus("On");
        setVolume(50);
        setBrightness(50);
    }

    public void turnoff(){
        setStatus("Off");
        setVolume(0);
        setBrightness(0);
    }

    public void freeze(){
        setStatus("Freeze");
    }

    private void setStatus(String Status) {
        this.Status = Status;
    }

    public int VolumeUp(){
        Volume++;
        return Volume;
    }

    public int VolumeDown(){
        Volume--;
        return Volume;
    }

    public int setVolume(int Volume){
        this.Volume = Volume;
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

    public int setBrightness(int Brightness){
        this.Brightness = Brightness;
        return Brightness;
    }

    public void setCable(int set){
        if (Status.equalsIgnoreCase("Off")){
           Cable = "-";
        } else if (set==1){
            Cable = "VGA";
        } else if (set==2){
            Cable = "DVI";
        } else if (set==3){
            Cable = "HDMI";
        } else if (set==4){
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
        System.out.println("    ");
    }

}
