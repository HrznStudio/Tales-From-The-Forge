package projecthrzn.talesfromtheforge.common.tool;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import projecthrzn.talesfromtheforge.TalesFromTheForge;
import projecthrzn.talesfromtheforge.common.IPart;
import projecthrzn.talesfromtheforge.common.Material;
import projecthrzn.talesfromtheforge.common.MaterialRegistry;
import projecthrzn.talesfromtheforge.util.TFTFConstants;
import projecthrzn.talesfromtheforge.util.Tags;

import javax.annotation.Nullable;
import java.util.List;

public class Tool extends Item {
    protected String name;
    protected IPart[] parts;

    public Tool(String name, IPart... parts) {
        this.name = name;
        this.parts = parts;
        setHasSubtypes(true);
        setUnlocalizedName(TFTFConstants.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(TalesFromTheForge.TAB);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        NBTTagCompound compound = Tags.getTagSafe(stack);
        if (compound.hasKey(Tags.PARTS, Constants.NBT.TAG_LIST)) {
            for (NBTBase base : compound.getTagList(Tags.PARTS, Constants.NBT.TAG_COMPOUND)) {
                if (base instanceof NBTTagCompound) {
                    ItemStack part = new ItemStack((NBTTagCompound) base);
                    tooltip.add("Part: " + part.getItem().getItemStackDisplayName(part));
                    tooltip.add(" - Material: " + ((IPart) part.getItem()).getMaterial(part).getDisplayName());
                }
            }
        }
    }

    public void addPart(ItemStack tool, ItemStack part) {
        if (part.getTagCompound() == null)
            return;
        NBTTagCompound compound = Tags.getTagSafe(tool);
        if (!compound.hasKey(Tags.PARTS, Constants.NBT.TAG_LIST)) {
            compound.setTag(Tags.PARTS, new NBTTagList());
        }
        NBTTagList list = compound.getTagList(Tags.PARTS, Constants.NBT.TAG_COMPOUND);
        list.appendTag(part.writeToNBT(new NBTTagCompound()));
    }

    public ItemStack getStack(ItemStack... parts) {
        ItemStack stack = new ItemStack(this);
        for (ItemStack part : parts) {
            addPart(stack, part);
        }
        return stack;
    }


    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (isInCreativeTab(tab)) {
            for (Material material : MaterialRegistry.getAllMaterials()) {
                ItemStack stack = new ItemStack(this);
                for (IPart part : parts) {
                    if (!part.canBeMaterial(material))
                        continue;
                    addPart(stack, part.getStack(material));
                }
                items.add(stack);
            }
        }
    }
}