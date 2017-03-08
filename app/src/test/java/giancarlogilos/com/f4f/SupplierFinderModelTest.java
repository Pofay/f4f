package giancarlogilos.com.f4f;

import org.junit.Test;

import core.SupplierFinderModel;
import core.SupplierGateway;
import core.TokenContainer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Gilos on 3/8/2017.
 */

public class SupplierFinderModelTest {

    @Test
    public void ItShouldDelegateTheQueryingOfSuppliersToTheGateway() {
        String token = "access-token";
        SupplierGateway gateway = mock(SupplierGateway.class);
        TokenContainer tokenContainer = mock(TokenContainer.class);
        when(tokenContainer.getToken()).thenReturn(token);
        SupplierFinderModel sut = new SupplierFinderModel(gateway, tokenContainer);

        sut.loadSuppliers();

        verify(gateway).querySuppliers(sut, token);
    }

    @Test
    public void ItShouldNotInvokeTheQueryOfGatewayOnConstruction() {
        String token = "access-token";
        SupplierGateway gateway = mock(SupplierGateway.class);
        TokenContainer tokenContainer = mock(TokenContainer.class);
        SupplierFinderModel sut = new SupplierFinderModel(gateway, tokenContainer);


        verify(gateway, never()).querySuppliers(sut, token);
    }

    @Test
    public void TriangulationTestForDifferentAccessToken() {
        String token = "ejb7345";
        SupplierGateway gateway = mock(SupplierGateway.class);
        TokenContainer tokenContainer = mock(TokenContainer.class);
        when(tokenContainer.getToken()).thenReturn(token);
        SupplierFinderModel sut = new SupplierFinderModel(gateway, tokenContainer);

        sut.loadSuppliers();

        verify(gateway).querySuppliers(sut, token);
    }
}
