package projecthrzn.talesfromtheforge.common.items;

import projecthrzn.talesfromtheforge.common.Material;
import projecthrzn.talesfromtheforge.common.tool.Part;

public class PartGrip extends Part {
    public PartGrip(String name, int cost) {
        super(name, cost);
    }

    @Override
    public boolean canBeMaterial(Material material) {
        return material==Material.WOOD;
    }
}