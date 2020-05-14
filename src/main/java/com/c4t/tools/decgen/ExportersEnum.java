package com.c4t.tools.decgen;

public enum ExportersEnum {

    EXPORTER01("JP"),
    EXPORTER02("BR"),
    EXPORTER03("US"),
    EXPORTER04("CN"),
    EXPORTER05("RU");

    private String alpha2;

    private ExportersEnum(String code) {
        alpha2 = code;
    }

    public String getAlpha2() {
        return alpha2;
    }

}
