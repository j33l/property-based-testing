package arithmetic;

import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class NatGenerator extends Generator<Nat> {
    // begin instance variables
    private Size configSize;
    // end instance variables

    public NatGenerator() {
        super(Nat.class);
        configSize = null;
    }

    public void configure(Size configSize) {
        this.configSize = configSize;
    }

    private int size(SourceOfRandomness random, GenerationStatus status) {
        if (configSize == null) {
            return status.size();
        } else {
            return random.nextInt(configSize.min(), configSize.max());
        }
    }
    
    public Nat generate(final SourceOfRandomness random,
                        final GenerationStatus status) {
        final int size = size(random, status);
        Nat retval = new Zero();

        for (int curNum = 0; curNum < size; curNum++) {
            retval = new Succ(retval);
        }

        return retval;
    }
}
