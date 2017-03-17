package core;

/**
 * Created by Gilos on 3/17/2017.
 */
public class SupplierProfilePresenter {
    private final SupplierProfileView view;

    public SupplierProfilePresenter(SupplierProfileView view) {
        this.view = view;
    }

    public void onDisplayAvailableItemsFor(ProduceSupplierViewModel supplier) {
        view.displayAvailableItemsFor(supplier);
    }
}
