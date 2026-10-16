package com.bijliguy.commandmanager;

import com.bijliguy.commandmanager.commands.LocateVillageCommand;
import com.bijliguy.commandmanager.commands.VillageEconomyCommand;
import com.bijliguy.commandmanager.events.VillageEntryEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(CommandManager.MOD_ID)
public class CommandManager {
    public static final String MOD_ID = "commandmanager";
    public static final Logger LOGGER = LogManager.getLogger();

    public CommandManager() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("CommandManager: Common setup initialized");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info("CommandManager: Client setup initialized");
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        VillageEconomyCommand.register(event.getDispatcher());
        LocateVillageCommand.register(event.getDispatcher());
    }
}