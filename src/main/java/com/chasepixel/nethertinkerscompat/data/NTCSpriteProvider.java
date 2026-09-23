package com.chasepixel.nethertinkerscompat.data;

import com.chasepixel.nethertinkerscompat.NetherTinkers;
import slimeknights.tconstruct.library.client.data.material.AbstractPartSpriteProvider;

public class NTCSpriteProvider extends AbstractPartSpriteProvider {


    public NTCSpriteProvider() {
        super(NetherTinkers.MODID);
    }

    @Override
    protected void addAllSpites() {
        buildTool("machete").addBreakableHead("head").addHandle("handle");
    }

    @Override
    public String getName() {
        return "Nether Tinkers' Compat Part Sprite Provider";
    }
}
