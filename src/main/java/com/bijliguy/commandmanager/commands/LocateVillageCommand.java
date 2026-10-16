package com.bijliguy.commandmanager.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class LocateVillageCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("locatevillage")
            .then(Commands.argument("level", IntegerArgumentType.integer(1, 5))
                .executes(LocateVillageCommand::execute)));
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        int level = IntegerArgumentType.getInteger(context, "level");
        CommandSourceStack source = context.getSource();
        Player player = source.getPlayer();

        if (player != null) {
            String message = getLocateVillageMessage(level);
            player.sendSystemMessage(Component.literal(message));
        }

        return 1;
    }

    private static String getLocateVillageMessage(int level) {
        switch (level) {
            case 1:
                return "Locating Level 1 village...";
            case 2:
                return "Locating Level 2 village...";
            case 3:
                return "Locating Level 3 village...";
            case 4:
                return "Locating Level 4 village...";
            case 5:
                return "Locating Level 5 village...";
            default:
                return "Invalid level.";
        }
    }
}