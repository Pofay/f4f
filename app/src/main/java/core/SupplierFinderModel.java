package core;

/**
 * Created by Gilos on 3/8/2017.
 */
public class SupplierFinderModel {
    private final SupplierGateway gateway;

    public SupplierFinderModel(SupplierGateway gateway, TokenContainer tokenContainer) {
        this.gateway = gateway;
    }

    public void loadSuppliers() {
        gateway.getSuppliers(this, "access-token");
    }
}
