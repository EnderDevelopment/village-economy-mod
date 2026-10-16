package com.bijliguy.commandmanager.events;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "commandmanager")
public class VillageEntryEvent {
    @SubscribeEvent
    public static void onPlayerEnterVillage(PlayerEvent.PlayerChangedDimensionEvent event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (level.dimension() == Level.OVERWORLD) {
            // Logic to detect village entry
            player.sendSystemMessage(Component.literal("You have entered a village.")));
        }
    }
}