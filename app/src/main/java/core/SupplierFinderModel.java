package core;

/**
 * Created by Gilos on 3/8/2017.
 */
public class SupplierFinderModel {
    private final SupplierGateway gateway;
    private final TokenContainer tokenContainer;

    public SupplierFinderModel(SupplierGateway gateway, TokenContainer tokenContainer) {
        this.gateway = gateway;
        this.tokenContainer = tokenContainer;
    }

    public void loadSuppliers() {
        gateway.getSuppliers(this, tokenContainer.getToken());
    }
}
