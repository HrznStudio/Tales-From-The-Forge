package projecthrzn.talesfromtheforge.util;

public enum Amounts {
    INGOT(144),
    NUGGET(INGOT.getAmount() / 9),
    GEM(666),
    BLOCK(INGOT.getAmount() * 9)
    ;

    int amount;

    Amounts(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getAmount(int multiplication) {
        return amount * multiplication;
    }
}