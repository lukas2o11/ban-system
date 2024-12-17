package com.github.lukas2o11.bansystem.bungee.data.ban.tasks;


import com.github.lukas2o11.bansystem.bungee.data.database.MySQL;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ExpiredBanReaper {

    private static final String REAP_EXPIRED_BANS_QUERY = "UPDATE bansystem_bans " +
            "SET active = false " +
            "WHERE expiresAt < ? AND active = true;";

    private @NotNull final MySQL mySQL;

    public ExpiredBanReaper(@NotNull MySQL mySQL) {
        this.mySQL = mySQL;
    }

    public CompletableFuture<Void> reapExpireBans() {
        long currentTime = System.currentTimeMillis();

        return mySQL.executeTransaction(connection -> {
            return mySQL.update(connection, REAP_EXPIRED_BANS_QUERY, currentTime);
        }).thenAccept(v -> System.out.println("Expired bans successfully reapplied"));
    }
}
