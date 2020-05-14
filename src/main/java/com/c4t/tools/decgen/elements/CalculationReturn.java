package com.c4t.tools.decgen.elements;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CalculationReturn {

    private BigDecimal basisValue;

    private String type;

    private Payment payment;
}
