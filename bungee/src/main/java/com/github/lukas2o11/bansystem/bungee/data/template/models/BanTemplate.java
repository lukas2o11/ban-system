package com.github.lukas2o11.bansystem.bungee.data.template.models;

import com.github.lukas2o11.bansystem.api.BanType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BanTemplate {

    private final String id;
    private final BanType banType;
    private final String reason;
    private final long duration;

}
