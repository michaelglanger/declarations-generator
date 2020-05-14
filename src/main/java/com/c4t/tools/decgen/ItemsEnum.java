package com.c4t.tools.decgen;

import java.math.BigDecimal;

public interface ItemsEnum {

    public String getName();

    public String getTaric();

    public String getDescription();

    public BigDecimal getDutyRate();
    public BigDecimal getVat();
}
