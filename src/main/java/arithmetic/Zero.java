package arithmetic;

public class Zero implements Nat {
    public Zero() {}

    public boolean isZero() {
        return true;
    }

    public boolean isOne() {
        return false;
    }

    public Nat add(final Nat other) {
        // 0 + 4 == 4
        return other;
    }

    public Nat subtract(final Nat other) {
        // For natural numbers, 0 - 5 == 0
        // (we don't have negative values)
        return this;
    }

    public Nat multiply(final Nat other) {
        // 0 * 5 == 0
        return this;
    }

    public boolean equals(final Object other) {
        return other instanceof Zero;
    }

    public String toString() {
        return "0";
    }

    public boolean lessThan(final Nat other) {
        // 0 < 0 == false
        // 0 < non-zero == true
        return !other.isZero();
    }
}
