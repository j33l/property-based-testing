package arithmetic;

public interface Nat {
    public boolean isZero();
    public boolean isOne();
    public Nat add(Nat other);
    public Nat subtract(Nat other);
    public Nat multiply(Nat other);
    public boolean lessThan(Nat other);
}


