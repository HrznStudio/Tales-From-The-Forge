package projecthrzn.talesfromtheforge.common.tool;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import projecthrzn.talesfromtheforge.TalesFromTheForge;
import projecthrzn.talesfromtheforge.common.Material;
import projecthrzn.talesfromtheforge.common.MaterialRegistry;
import projecthrzn.talesfromtheforge.util.TFTFConstants;
import projecthrzn.talesfromtheforge.util.Tags;

import javax.annotation.Nullable;
import java.util.List;

public class MaterialItem extends Item implements IMaterialItem {
    protected String name;

    public MaterialItem(String name) {
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
    public String getItemStackDisplayName(ItemStack stack) {
        Material material = getMaterial(stack);
        return I18n.translateToLocal("material." + material.getName() + ".name") + " " + I18n.translateToLocal("type." + name + ".name");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        Material material = getMaterial(stack);
        tooltip.add("Material: "+material.getDisplayName());
    }

    public ItemStack getStack(Material material) {
        ItemStack stack = new ItemStack(this);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString(Tags.MATERIAL, material.name());
        stack.setTagCompound(tag);
        return stack;
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (isInCreativeTab(tab)) {
            for (Material mt : MaterialRegistry.getAllMaterials()) {
                if (canBeMaterial(mt)) {
                    items.add(getStack(mt));
                }
            }
        }
    }

    @Override
    public boolean canBeMaterial(Material material) {
        return true;
    }

    public Material getMaterial(ItemStack stack) {
        NBTTagCompound tag = Tags.getTagSafe(stack);
        return MaterialRegistry.getMaterial(tag.getString(Tags.MATERIAL));
    }
}