package com.chasepixel.nethertinkerscompat.data;

import com.chasepixel.nethertinkerscompat.common.item.NTCItems;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.tinkering.AbstractStationSlotLayoutProvider;
import slimeknights.tconstruct.tools.TinkerToolParts;
import slimeknights.tconstruct.tools.TinkerTools;

public class NTCSlotLayoutProvider extends AbstractStationSlotLayoutProvider {


    public NTCSlotLayoutProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void addLayouts() {
        defineModifiable(NTCItems.machete)
                .sortIndex(SORT_WEAPON)
                .addInputItem(TinkerToolParts.broadBlade, 39, 35)
                .addInputItem(TinkerToolParts.toolHandle, 21, 53)
                .build();
    }

    @Override
    public String getName() {
        return "Nether Tinkers' Compat Slot Layout Provider";
    }
}
