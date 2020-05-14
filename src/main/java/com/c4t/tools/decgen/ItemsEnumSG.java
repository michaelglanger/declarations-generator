package com.c4t.tools.decgen;

import java.math.BigDecimal;

public enum ItemsEnumSG implements ItemsEnum {

    ITEM01("9018908400","ITEM STANDARD", "0", "0.07"),
    ITEM02("9018200000","Ultraviolet apparatus", "0", "0.07"),
    ITEM03("6109100010","Cotton T-shits", "0.12", "0.07"),
    ITEM04("2008111000","Peanut butter", "0.13", "0.07"),
    ITEM05("6211120000","Girl´s Swimwear", "0.12", "0.07"),
    ITEM06("8407211000","Outboard motors", "0.062", "0.07"),
    ITEM07("6402129000","Snowboard boots", "0.17", "0.07"),
    ITEM08("2203000100","Beer made from malt, in bottles", "0", "0.07"),
    ITEM09("6101201000","Cotton overcoat for men", "0.12", "0.07"),
    ITEM010("2204301000","PGrape must beverage, with fermentation arrested otherwise than by the addition of alcohol", "0.32", "0.07");

    private String taric;
    private String desc;
    private BigDecimal dutyRate;
    private BigDecimal vat;

    ItemsEnumSG(String t, String d, String dr, String v) {
        this.taric = t;
        this.desc = d;
        this.dutyRate = new BigDecimal(dr);
        this.vat = new BigDecimal(v);
    }

    public String getName() {
        return name();
    }

    public String getTaric() {
        return taric;
    }

    public String getDescription() {
        return desc;
    }

    public BigDecimal getDutyRate() {
        return dutyRate;
    }

    public BigDecimal getVat() {
        return vat;
    }
}
