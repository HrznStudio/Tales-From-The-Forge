package projecthrzn.talesfromtheforge.common;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public enum Material implements IStringSerializable {
    COPPER,
    BRONZE,
    IRON,
    SILVER,
    GOLD,;

    public static final Material[] ENABLED = values();

    public static Material ofKey(int meta) {
        return ENABLED[meta % ENABLED.length];
    }

    @SideOnly(Side.CLIENT)
    public String getDisplayName() {
        return I18n.format("material." + getName() + ".name");
    }

    @Override
    public String getName() {
        return name().toLowerCase();
    }

    public int meta() {
        return ordinal();
    }
}
