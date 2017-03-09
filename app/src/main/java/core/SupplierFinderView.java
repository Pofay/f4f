package core;

import java.util.List;

/**
 * Created by Gilos on 3/8/2017.
 */
public interface SupplierFinderView {
    void displaySuppliers(List<ProduceSupplierViewModel> suppliers);

    void displayProfileFor(ProduceSupplier expected);
}
