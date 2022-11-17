package arithmetic;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class NatUnitTest {
    @Test
    public void testToStringZero() {
        assertEquals("0", (new Zero()).toString());
    }

    @Test
    public void testToStringOne() {
        // the successor to zero
        final Nat one = new Succ(new Zero());
        assertEquals("S(0)", one.toString());
    }

    @Test
    public void testEqualsSame() {
        final Nat two1 = new Succ(new Succ(new Zero()));
        final Nat two2 = new Succ(new Succ(new Zero()));
        assertEquals(two1, two2);
    }

    @Test
    public void testEqualsDifferent() {
        final Nat one = new Succ(new Zero());
        final Nat two = new Succ(new Succ(new Zero()));
        assertFalse(one.equals(two));
        assertFalse(two.equals(one));
    }

    @Test
    public void testEqualsNonNat() {
        final Nat one = new Succ(new Zero());
        assertFalse(one.equals(new Object()));
    }
    
    @Test
    public void testZeroIsZero() {
        final Nat zero = new Zero();
        assertTrue(zero.isZero());
        assertFalse(zero.isOne());
    }

    @Test
    public void testOneIsOne() {
        // the successor to zero
        final Nat one = new Succ(new Zero());
        assertFalse(one.isZero());
        assertTrue(one.isOne());
    }

    @Test
    public void testAdd() {
        // 2 + 3
        final Nat zero = new Zero();
        final Nat two = new Succ(new Succ(zero));
        final Nat three = new Succ(two);
        final Nat five = new Succ(new Succ(three));
        assertEquals(five, two.add(three));
    }

    @Test
    public void testSubtract() {
        // 3 - 2
        final Nat zero = new Zero();
        final Nat one = new Succ(zero);
        final Nat two = new Succ(one);
        final Nat three = new Succ(two);
        assertEquals(one, three.subtract(two));
    }

    @Test
    public void testMultiply() {
        // 3 * 2
        final Nat zero = new Zero();
        final Nat two = new Succ(new Succ(zero));
        final Nat three = new Succ(two);
        final Nat six = new Succ(new Succ(new Succ(three)));
        assertEquals(six, three.multiply(two));
    }        
}

