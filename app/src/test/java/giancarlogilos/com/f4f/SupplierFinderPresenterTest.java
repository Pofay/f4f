package giancarlogilos.com.f4f;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import core.FilledGateway;
import core.ProduceSupplier;
import core.SupplierFinderModel;
import core.SupplierFinderPresenter;
import core.SupplierFinderView;
import core.SupplierGateway;
import core.TokenContainer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Gilos on 3/8/2017.
 */

public class SupplierFinderPresenterTest {

    @Test
    public void ItShouldDisplayTheSuppliersOnInitialize(){
        List<ProduceSupplier> expected = new ArrayList<>();
        SupplierGateway stubGateway = new FilledGateway(expected);
        TokenContainer stubTokenContainer = mock(TokenContainer.class);
        SupplierFinderModel model = new SupplierFinderModel(stubGateway, stubTokenContainer);
        SupplierFinderView view = mock(SupplierFinderView.class);
        SupplierFinderPresenter sut = new SupplierFinderPresenter(view, model);

        sut.onInitialize();

        verify(view).loadSuppliers(expected);
    }


}
