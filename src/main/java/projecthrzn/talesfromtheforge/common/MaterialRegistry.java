package projecthrzn.talesfromtheforge.common;

public class MaterialRegistry {
    //TODO: make this an actual registry
    public static Material[] getAllMaterials() {
        return Material.ENABLED;
    }

    public static Material getMaterial(String string) {
        if(string.isEmpty())
            return Material.COPPER;
        return Material.valueOf(string.toUpperCase());
    }
}
