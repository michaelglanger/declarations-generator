package com.c4t.tools.decgen.elements;

import com.c4t.tools.decgen.MoneySerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class InvoiceLine {

    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal itemAmount;
}
