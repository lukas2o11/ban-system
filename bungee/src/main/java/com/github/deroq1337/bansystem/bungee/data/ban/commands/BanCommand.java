package com.github.deroq1337.bansystem.bungee.data.ban.commands;

import com.github.deroq1337.bansystem.api.BanType;
import com.github.deroq1337.bansystem.bungee.BanSystemPlugin;
import com.github.deroq1337.bansystem.bungee.data.ban.command.BaseBanCommand;
import org.jetbrains.annotations.NotNull;

public class BanCommand extends BaseBanCommand {

    public BanCommand(@NotNull String name, @NotNull BanSystemPlugin plugin) {
        super(name, plugin, BanType.BAN);
    }
}
