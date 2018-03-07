package sejm;

public class Arguments {
    private int cadency;
    private Attribute attribute;
    private String details;

    public void Arguments(int cadency, Attribute attribute, String details){
        this.cadency = cadency;
        this.attribute = attribute;
        this.details = details;
    }

    public int getCadency(){
        return cadency;
    }

    public Attribute getAttribute(){
        return attribute;
    }

    public String getDetails(){
        return details;
    }

    public void setCadency(int cadency) {

        this.cadency = cadency;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
