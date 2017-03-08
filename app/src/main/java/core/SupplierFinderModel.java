package core;

import java.util.List;

/**
 * Created by Gilos on 3/8/2017.
 */
public class SupplierFinderModel {
    private final SupplierGateway gateway;
    private final TokenContainer tokenContainer;
    private DataEvent<List<ProduceSupplier>> finishedLoadingSuppliersEvent;

    public SupplierFinderModel(SupplierGateway gateway, TokenContainer tokenContainer) {
        this.gateway = gateway;
        this.tokenContainer = tokenContainer;
        this.finishedLoadingSuppliersEvent = new DataEvent<>();
    }

    void addOnSuccessListener(DataEventListener<List<ProduceSupplier>> listener){
        finishedLoadingSuppliersEvent.addListener(listener);
    }

    public void loadSuppliers() {
        gateway.querySuppliers(this, tokenContainer.getToken());
    }

    public void onSuccess(List<ProduceSupplier> suppliers) {
        finishedLoadingSuppliersEvent.dispatch(suppliers);
    }
}
