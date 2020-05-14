package com.c4t.tools.decgen.elements;

import com.c4t.tools.decgen.MoneySerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class Payment {

    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal assessed;

    private String methodCode;
}
