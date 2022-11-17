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
        assertEquals(a, a);
    }

    // TODO: write your properties below
    // Put a comment before them explaining what sort of property you're testing
}
