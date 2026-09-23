package com.chasepixel.nethertinkerscompat.common.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.deferred.ItemDeferredRegister;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;

import static com.chasepixel.nethertinkerscompat.NetherTinkers.MODID;

public class NTCItems {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(MODID);

    public static final ItemObject<ModifiableItem> machete = ITEMS.register("machete", MacheteItem::new);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
