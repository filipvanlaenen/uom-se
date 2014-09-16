package tec.uom.se;

import java.math.BigDecimal;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Time;

import org.junit.Assert;
import org.junit.Test;

import tec.uom.se.util.SI;

public class DecimalQuantityTest {


    @Test
    public void divideTest() {
        Quantity<Length> metre = AbstractQuantity.of(BigDecimal.TEN, SI.METRE);
        Quantity<Length> result = metre.divide(10D);
        Assert.assertTrue(result.getValue().intValue() == 1);
        Assert.assertEquals(result.getUnit(), SI.METRE);

        AbstractQuantity<Time> day = AbstractQuantity.of(BigDecimal.TEN, SI.DAY);
        Quantity<Time> dayResult = day.divide(BigDecimal.valueOf(2.5D));
        Assert.assertTrue(dayResult.getValue().intValue() == 4);
        Assert.assertEquals(dayResult.getUnit(), SI.DAY);
    }

    @Test
    public void addTest() {
        Quantity<Length> m = AbstractQuantity.of(BigDecimal.TEN, SI.METRE);
        Quantity<Length> m2 = AbstractQuantity.of(BigDecimal.valueOf(12.5), SI.METRE);
        Quantity<Length> m3 = AbstractQuantity.of(2.5, SI.METRE);
        Quantity<Length> m4 = AbstractQuantity.of(5L, SI.METRE);
        Quantity<Length> result = m.add(m2).add(m3).add(m4);
        Assert.assertTrue(result.getValue().doubleValue() == 30.0);
        Assert.assertEquals(result.getUnit(), SI.METRE);
    }

    @Test
    public void subtractTest() {
        Quantity<Length> m = AbstractQuantity.of(BigDecimal.TEN, SI.METRE);
        Quantity<Length> m2 = AbstractQuantity.of(12.5, SI.METRE);
        Quantity<Length> result = m.subtract(m2);
        Assert.assertTrue(result.getValue().doubleValue() == -2.5);
        Assert.assertEquals(result.getUnit(), SI.METRE);
    }

    @Test
    public void multiplyTest() {
        Quantity<Length> metre = AbstractQuantity.of(BigDecimal.TEN, SI.METRE);
        Quantity<Length> result = metre.multiply(10D);
        Assert.assertTrue(result.getValue().intValue() == 100);
        Assert.assertEquals(result.getUnit(), SI.METRE);
        @SuppressWarnings("unchecked")
        Quantity<Length> result2 = (Quantity<Length>) metre.multiply(AbstractQuantity.of(BigDecimal.TEN, SI.METRE));
        Assert.assertTrue(result2.getValue().intValue() == 100);
    }

    @Test
    public void inverseTest() {
        Quantity<Length> metre = AbstractQuantity.of(BigDecimal.TEN, SI.METRE).inverse();
        Assert.assertTrue(metre.getValue().intValue() == 10);
    }

}