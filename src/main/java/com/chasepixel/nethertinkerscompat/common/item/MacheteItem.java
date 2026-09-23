package com.chasepixel.nethertinkerscompat.common.item;

import net.minecraft.world.item.Item;
import slimeknights.tconstruct.tools.item.ModifiableSwordItem;

public class MacheteItem extends ModifiableSwordItem {

    public MacheteItem() {
        super(new Item.Properties().stacksTo(1), ToolDefinitions.MACHETE);
    }
}
