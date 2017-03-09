package core;

/**
 * Created by Gilos on 3/9/2017.
 */
public class ProduceSupplierViewModel {

    public String productOffers;
    public String name;

    public ProduceSupplierViewModel(String name, String productOffers) {
        this.name = name;
        this.productOffers = productOffers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProduceSupplierViewModel that = (ProduceSupplierViewModel) o;

        if (productOffers.equals(that.productOffers) && (name.equals(that.name)))
            return true;
        else
            return false;
    }

}
