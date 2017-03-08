package core;

import java.util.List;

/**
 * Created by Gilos on 3/8/2017.
 */
public class FilledGateway implements SupplierGateway {
    private final List<ProduceSupplier> suppliers;

    public FilledGateway(List<ProduceSupplier> suppliers){
        this.suppliers = suppliers;
    }

    @Override
    public void querySuppliers(SupplierFinderModel sut, String token) {
        sut.onSuccess(suppliers);
    }
}
