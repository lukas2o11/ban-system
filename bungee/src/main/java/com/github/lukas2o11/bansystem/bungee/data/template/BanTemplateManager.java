package com.github.lukas2o11.bansystem.bungee.data.template;

import com.github.lukas2o11.bansystem.api.BanType;
import com.github.lukas2o11.bansystem.bungee.data.template.models.BanTemplate;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface BanTemplateManager {

    @NotNull CompletableFuture<Optional<BanTemplate>> getTemplate(@NotNull String templateId);

    @NotNull CompletableFuture<List<BanTemplate>> getAllTemplates();

    void createTemplate(@NotNull String templateId, @NotNull BanType banType, @NotNull String reason, long duration);

    void deleteTemplate(@NotNull String templateId);
}
