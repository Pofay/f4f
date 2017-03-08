package core;

/**
 * Created by Gilos on 3/8/2017.
 */
public class SupplierFinderPresenter {
    private final SupplierFinderModel model;
    private final SupplierFinderView view;

    public SupplierFinderPresenter(SupplierFinderView view, SupplierFinderModel model) {
        this.view = view;
        this.model = model;
        model.addOnSuccessListener((suppliers) -> view.loadSuppliers(suppliers));
    }

    public void onInitialize() {
        model.loadSuppliers();
    }
}
