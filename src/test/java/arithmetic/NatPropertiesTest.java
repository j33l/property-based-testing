package arithmetic;

import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assume.assumeTrue;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class NatPropertiesTest {
    // a == a
    @Property
    public void numberEqualsSelf(@From(NatGenerator.class) @Size(max = 10) final Nat a) {
        assertTrue(a.equals(a));
    }

    @Property
    public void numberIsZero(@From(NatGenerator.class) @Size(max = 10) final Nat a) {
        assumeTrue(a.isZero());
        assertTrue(a.isZero());
        assertFalse(a.isOne());
    }

    // a + b = b + a
    @Property
    public void addNumber(@From(NatGenerator.class) @Size(max = 10) final Nat a,
                          @From(NatGenerator.class) @Size(max = 10) final Nat b) {
        final Nat sum = a.add(b);
        assertEquals(sum, b.add(a));
    }

    // a + 0 = a
    @Property
    public void addZero(@From(NatGenerator.class) @Size(max = 10) final Nat a) {
        final Nat sum = a.add(new Zero());
        assertEquals(sum, a);
    }

    // a - b = 0 if a < b, since neturl numbers are non-negative
    @Property
    public void subtractNumber(@From(NatGenerator.class) @Size(max = 10) final Nat a,
                               @From(NatGenerator.class) @Size(max = 10) final Nat b) {
        assumeTrue(a.lessThan(b));
        final Nat diff = a.subtract(b);
        assertEquals(diff, new Zero());
    }

    // 5 - 4 == (5 - 1) - (4 - 1)
    @Property
    public void subtractNumber2(@From(NatGenerator.class) @Size(max = 10) final Nat a,
                                @From(NatGenerator.class) @Size(max = 10) final Nat b) {
        assumeTrue(a.lessThan(b));
        final Nat diff = a.subtract(b);
        final Nat diff2 = a.subtract(new Succ(b)).subtract(new Succ(a).subtract(new Succ(b)));
        assertEquals(diff, diff2);
    }

    // 5 * 0 == 0
    @Property
    public void multiplyZero(@From(NatGenerator.class) @Size(max = 10) final Nat a) {
        final Nat prod = a.multiply(new Zero());
        assertEquals(prod, new Zero());
    }

    @Property
    public void numberToString(@From(NatGenerator.class) @Size(max = 10) final Nat a) {
        assertEquals(a.toString(), a.toString());
    }

    // 5 < 4 == false
    @Property
    public void lessThan(@From(NatGenerator.class) @Size(max = 10) final Nat a,
                         @From(NatGenerator.class) @Size(max = 10) final Nat b) {

        final Nat five = new Succ(new Succ(new Succ(new Succ(new Succ(new Zero())))));
        final Nat four = new Succ(new Succ(new Succ(new Succ(new Zero()))));
        assertFalse(five.lessThan(four));

        assumeTrue(a.lessThan(b));
        assertFalse(b.lessThan(a));
    }
}
