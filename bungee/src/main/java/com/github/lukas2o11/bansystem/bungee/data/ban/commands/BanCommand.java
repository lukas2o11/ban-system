package com.github.lukas2o11.bansystem.bungee.data.ban.commands;

import com.github.lukas2o11.bansystem.bungee.BanSystemPlugin;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.UUID;

public class BanCommand extends Command {

    private final BanSystemPlugin plugin;

    public BanCommand(String name, BanSystemPlugin plugin) {
        super(name);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 2) {
            //TODO: usage
            return;
        }

        String playerName = args[0];
        String templateId = args[1];
        ProxiedPlayer player = ProxyServer.getInstance().getPlayer(playerName);

        if (player != null) {
            plugin.getTemplateManager().getTemplate(templateId).thenAccept(template -> {
                template.ifPresent(t -> {
                    plugin.getBanManager().banUser(player.getUniqueId(), t.getBanType()).join();
                    sender.sendMessage("Player " + playerName + " has been banned with template " + templateId);
                });
            });

        } else {
            UUID playerUuid = getPlayerUuid(playerName);
            if (playerUuid == null) {
                sender.sendMessage("Player " + playerName + " could not be found.");
                return;
            }

            plugin.getTemplateManager().getTemplate(templateId).thenAccept(template -> {
                template.ifPresent(t -> {
                    plugin.getBanManager().banUser(playerUuid, t.getBanType()).join();
                    sender.sendMessage("Player " + playerName + " is now banned with template" + templateId);
                });
            });
        }
    }

    private UUID getPlayerUuid(String playerName) {
        //webhook to get players uuid if offline
        //otherwise get uuid from ban database?
        return null;
    }
}
