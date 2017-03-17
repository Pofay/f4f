package giancarlogilos.com.f4f;

import org.junit.Test;

import core.ProduceSupplierViewModel;
import core.SupplierProfilePresenter;
import core.SupplierProfileView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Gilos on 3/17/2017.
 */

public class SupplierProfilePresenterTest {


    @Test
    public void ItShouldTellViewToDisplayAvailableItems(){
        ProduceSupplierViewModel supplier = new ProduceSupplierViewModel("Pofire", "Carrots");

        SupplierProfileView view = mock(SupplierProfileView.class);
        SupplierProfilePresenter presenter = new SupplierProfilePresenter(view);

        presenter.onDisplayAvailableItemsFor(supplier);

        verify(view).displayAvailableItemsFor(supplier);
    }
}
