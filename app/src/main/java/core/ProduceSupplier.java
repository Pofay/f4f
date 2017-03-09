package core;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Gilos on 3/8/2017.
 */
public class ProduceSupplier {

    private final List<String> produceOffers;
    private final String name;

    public ProduceSupplier(String name, List<String> produceOffers) {

        this.name = name;
        this.produceOffers = produceOffers;
    }

    public String getName() {
        return name;
    }

    public String getProductOffers() {
        String productOffersString = "";
        for (String offer : produceOffers) {
            productOffersString += appendWithComma(offer);
        }
        return productOffersString;
    }

    @NonNull
    private String appendWithComma(String offer) {
        return offer + ", ";
    }
}
