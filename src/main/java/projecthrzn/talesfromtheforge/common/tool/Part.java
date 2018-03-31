package projecthrzn.talesfromtheforge.common.tool;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import projecthrzn.talesfromtheforge.common.IPart;
import projecthrzn.talesfromtheforge.common.Material;

import javax.annotation.Nullable;
import java.util.List;

public class Part extends MaterialItem implements IPart {
    protected int cost;

    public Part(String name, int cost) {
        super(name);
        this.cost = cost;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public boolean canBeMaterial(Material material) {
        return true;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
