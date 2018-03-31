package projecthrzn.talesfromtheforge.common.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import projecthrzn.talesfromtheforge.TalesFromTheForge;
import projecthrzn.talesfromtheforge.common.Material;
import projecthrzn.talesfromtheforge.util.TFTFConstants;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ItemMaterial extends Item {
    private final String name;

    public ItemMaterial(String name) {
        this.name = name;
        setHasSubtypes(true);
        setUnlocalizedName(TFTFConstants.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(TalesFromTheForge.TAB);
    }

    @Override
    public int getMetadata(ItemStack stack) {
        return getMaterial(stack).meta();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add("Material: " + getMaterial(stack).getDisplayName());
        tooltip.add(" - Melting Point: 9999\u00B0");
        tooltip.add(" - Quality: " + (getQuality(stack) * 100) + "%");
        tooltip.add(" - Purity: " + (getPurity(stack) * 100) + "%");
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (isInCreativeTab(tab)) {
            for (Material material : Material.ENABLED) {
                items.add(createStack(
                        material,
                        1,
                        1,
                        1
                ));
            }
        }
    }

    private double getPurity(ItemStack stack) {
        NBTTagCompound tag = getStackTag(stack);
        if (!tag.hasKey("purity", Constants.NBT.TAG_DOUBLE)) {
            tag.setDouble("purity", 0);
        }
        return tag.getDouble("purity");
    }

    private double getQuality(ItemStack stack) {
        NBTTagCompound tag = getStackTag(stack);
        if (!tag.hasKey("quality", Constants.NBT.TAG_DOUBLE)) {
            tag.setDouble("quality", 0);
        }
        return tag.getDouble("quality");
    }

    private ItemStack createStack(Material material, int amount, double quality, double purity) {
        ItemStack stack = new ItemStack(this, amount);
        NBTTagCompound compound = getStackTag(stack);
        compound.setInteger("material", material.meta());
        compound.setDouble("quality", quality);
        compound.setDouble("purity", purity);
        return stack;
    }

    private Material getMaterial(ItemStack stack) {
        NBTTagCompound tag = getStackTag(stack);
        if (!tag.hasKey("material", Constants.NBT.TAG_INT)) {
            tag.setInteger("material", 0);
        }
        return Material.ofKey(tag.getInteger("material"));
    }

    @Nonnull
    private NBTTagCompound getStackTag(ItemStack stack) {
        NBTTagCompound tag = stack.getTagCompound();
        if (tag == null) {
            tag = new NBTTagCompound();
            stack.setTagCompound(tag);
        }
        return tag;
    }
}