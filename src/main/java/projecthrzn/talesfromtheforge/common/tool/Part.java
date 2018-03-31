package projecthrzn.talesfromtheforge.common.tool;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import projecthrzn.talesfromtheforge.common.IPart;
import projecthrzn.talesfromtheforge.common.Material;
import projecthrzn.talesfromtheforge.util.Tags;

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
    public ItemStack getStack(Material material) {
        ItemStack stack = new ItemStack(this);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString(Tags.MATERIAL, material.name());
        tag.setString(Tags.PARTID, getRegistryName().toString());
        stack.setTagCompound(tag);
        return stack;
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