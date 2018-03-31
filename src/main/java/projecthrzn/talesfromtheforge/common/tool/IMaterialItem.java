package projecthrzn.talesfromtheforge.common.tool;

import net.minecraft.item.ItemStack;
import projecthrzn.talesfromtheforge.common.Material;

public interface IMaterialItem {

    boolean canBeMaterial(Material material);
    ItemStack getStack(Material material);
}
