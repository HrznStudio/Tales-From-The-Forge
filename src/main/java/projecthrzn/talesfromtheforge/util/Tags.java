package projecthrzn.talesfromtheforge.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Tags {
    public static final String MATERIAL = "material";
    public static final String GRIP = "grip";
    public static final String RARITY = "rarity";

    public static final String PARTS = "parts";
    public static final String PARTID = "partid";


    public static NBTTagCompound getTagSafe(ItemStack stack) {
        NBTTagCompound tag = stack.getTagCompound();
        if (tag == null) {
            tag = new NBTTagCompound();
            stack.setTagCompound(tag);
        }
        return tag;
    }
}
