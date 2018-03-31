package projecthrzn.talesfromtheforge.common;

public enum ToolType {
    PICKAXE(GripType.ONE_HANDED, GripType.TWO_HANDED);

    private GripType[] grips;

    ToolType(GripType... grips) {
        this.grips = grips;
    }
}