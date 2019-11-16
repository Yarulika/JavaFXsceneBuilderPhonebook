package tmpForTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TmpTest {

    @Test
    public void returner() {
        Tmp tmp = new Tmp();
        Assert.assertTrue(tmp.returner("la").equals("la"));

    }
}
