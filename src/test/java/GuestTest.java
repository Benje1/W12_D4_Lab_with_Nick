import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    Guest guest;

    @Before
    public void setUp() throws Exception {
        guest = new Guest("Bob", 800.00);
    }

    @Test
    public void guestHasName() {
        assertEquals("Bob", guest.getName());
    }

    @Test
    public void guestHasCash(){
        assertEquals(800.00, guest.getWallet(), 0.0);
    }
}
