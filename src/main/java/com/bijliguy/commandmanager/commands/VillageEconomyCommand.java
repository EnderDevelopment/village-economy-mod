package com.bijliguy.commandmanager.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public class VillageEconomyCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("villageeconomy")
            .then(Commands.argument("level", IntegerArgumentType.integer(1, 5))
                .executes(VillageEconomyCommand::execute)));
    }

    private static int execute(CommandContext<CommandSourceStack> context) {
        int level = IntegerArgumentType.getInteger(context, "level");
        CommandSourceStack source = context.getSource();
        Player player = source.getPlayer();

        if (player != null) {
            String message = getVillageEconomyMessage(level);
            player.sendSystemMessage(Component.literal(message));
        }

        return 1;
    }

    private static String getVillageEconomyMessage(int level) {
        switch (level) {
            case 1:
                return "Level 1: Very poor, small, and few resources.";
            case 2:
                return "Level 2: Poor, small, and limited resources.";
            case 3:
                return "Level 3: Moderate, average size, and moderate resources.";
            case 4:
                return "Level 4: Wealthy, large, and abundant resources.";
            case 5:
                return "Level 5: Very wealthy, very large, and high-value loot.";
            default:
                return "Invalid level.";
        }
    }
}