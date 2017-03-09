package core;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Gilos on 3/8/2017.
 */
public class SupplierFinderPresenter {
    private final SupplierFinderModel model;
    private final SupplierFinderView view;

    public SupplierFinderPresenter(SupplierFinderView view, SupplierFinderModel model) {
        this.view = view;
        this.model = model;
        model.addOnSuccessListener((suppliers) -> {
             List<ProduceSupplierViewModel> viewModels = convertToViewModelList(suppliers);
             view.displaySuppliers(viewModels);
        });
    }

    private List<ProduceSupplierViewModel> convertToViewModelList(List<ProduceSupplier> suppliers) {
        return Arrays.asList();
    }

    public void onInitialize() {
        model.loadSuppliers();
    }

    public void onLoadProfileFor(ProduceSupplier supplier) {
        view.displayProfileFor(supplier);
    }
}
