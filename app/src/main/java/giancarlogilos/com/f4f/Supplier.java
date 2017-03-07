package giancarlogilos.com.f4f;

/**
 * Created by Gilos on 3/6/2017.
 */
public class Supplier {
    private final String name;

    public Supplier(String name){
        this.name = name;
    }
    public String itemOffers() {
        return "Potatoes";
    }

    public String getName(){
        return name;
    }

}
