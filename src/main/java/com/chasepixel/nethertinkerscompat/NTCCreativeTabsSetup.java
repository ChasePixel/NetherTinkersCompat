package com.chasepixel.nethertinkerscompat;


import com.chasepixel.nethertinkerscompat.common.item.NTCItems;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.tools.helper.ToolBuildHandler;
import slimeknights.tconstruct.tools.TinkerTools;

@Mod.EventBusSubscriber(modid = NetherTinkers.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NTCCreativeTabsSetup {
    public NTCCreativeTabsSetup() {}

    @SubscribeEvent
    public static void addCreativeItems(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(TinkerTools.tabTools.getKey())) {
            ToolBuildHandler.addVariants(
                    event::accept,
                    NTCItems.machete.get(),
                    ""
            );
        }
    }
}
