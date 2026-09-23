package com.chasepixel.nethertinkerscompat.data;

import com.chasepixel.nethertinkerscompat.NetherTinkers;
import com.chasepixel.nethertinkerscompat.common.item.NTCItems;
import com.google.gson.JsonObject;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.library.data.AbstractToolItemModelProvider;

import java.io.IOException;

import static slimeknights.tconstruct.TConstruct.getResource;

public class NTCItemModelProvider extends AbstractToolItemModelProvider{

    public NTCItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, existingFileHelper, NetherTinkers.MODID);
    }

    @Override
    protected void addModels() throws IOException {
        JsonObject toolBlocking = readJson(getResource("base/tool_blocking"));
        //TODO unknown if needed ? ^
        System.out.println(readJson(NTCItems.machete.getId()));

        tool(NTCItems.machete, toolBlocking, "head");
    }

    @Override
    public String getName() {
        return "Nether Tinkers' Compat Item Model Provider";
    }

}
