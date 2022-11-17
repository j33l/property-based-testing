package arithmetic;

public class Succ implements Nat {
    // begin instance variables
    public final Nat around;
    // end instance variables

    public Succ(final Nat around) {
        this.around = around;
    }

    public boolean isZero() {
        return false;
    }

    public boolean isOne() {
        return around.isZero();
    }
    
    public Nat add(final Nat other) {
        // 5 + 4 == 1 + (5 - 1) + 4
        Nat retval = other;
        Nat cur = this;

        while (!cur.isZero()) {
            retval = new Succ(retval);
            cur = ((Succ)cur).around;
        }

        return retval;
    }

    public Nat subtract(final Nat other) {
        if (other.isZero()) {
            // 5 - 0 == 5
            return this;
        } else {
            // 5 - 4 == (5 - 1) - (4 - 1)
            final Succ otherSucc = (Succ)other;
            return around.subtract(otherSucc.around);
        }
    }

    public Nat multiply(final Nat other) {
        if (other.isZero()) {
            // 5 * 0 == 0
            return other;
        } else {
            Nat cur = other;
            Nat retval = this;
            while (!cur.isOne()) {
                retval = retval.add(this);
                cur = ((Succ)cur).around;
            }
            return retval;
        }
    }

    public boolean equals(final Object other) {
        if (other instanceof Nat) {
            Nat cur = this;
            Nat otherNat = (Nat)other;

            while (!cur.isZero() && !otherNat.isZero()) {
                cur = ((Succ)cur).around;
                otherNat = ((Succ)otherNat).around;
            }

            return cur.isZero() && otherNat.isZero();
        } else {
            return false;
        }
    }

    public String toString() {
        int numRightParens = 0;
        final StringBuffer buffer = new StringBuffer();
        Nat cur = this;

        while (!cur.isZero()) {
            buffer.append("S(");
            cur = ((Succ)cur).around;
            numRightParens++;
        }

        buffer.append("0");
        for (int x = 0; x < numRightParens; x++) {
            buffer.append(")");
        }
        return buffer.toString();
    }

    public boolean lessThan(Nat other) {
        Nat cur = this;

        // decrement until one hits zero
        while (!cur.isZero() && !other.isZero()) {
            cur = ((Succ)cur).around;
            other = ((Succ)other).around;
        }

        // if left is zero, but not right, then it's less than
        return cur.isZero() && !other.isZero();
    }
}

