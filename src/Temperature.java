public class Temperature {
    private String type;
    private String date;
    private double raise;

    public Temperature(String type, String date, double raise){
        /*System.out.println(type);
        System.out.println(date);
        System.out.println(raise);*/
        this.type = type;
        this.date = date;
        this.raise = raise;
    }

    public String getDate(){
        return this.date;
    }

    public double getRaise(){
        return this.raise;
    }

    public String getType(){
        return this.type;
    }
}
