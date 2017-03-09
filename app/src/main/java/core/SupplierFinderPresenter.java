package core;

import android.support.annotation.NonNull;

import java.util.ArrayList;
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
        List<ProduceSupplierViewModel> viewModels = new ArrayList<>();
        for(ProduceSupplier s: suppliers){
            ProduceSupplierViewModel viewModel = convertToViewModel(s);
            viewModels.add(viewModel);
        }
        return viewModels;
    }

    @NonNull
    private ProduceSupplierViewModel convertToViewModel(ProduceSupplier s) {
        return new ProduceSupplierViewModel(s.getName(), s.getProductOffers());
    }

    public void onInitialize() {
        model.loadSuppliers();
    }

    public void onLoadProfileFor(ProduceSupplierViewModel supplier) {
        view.displayProfileFor(supplier);
    }
}
