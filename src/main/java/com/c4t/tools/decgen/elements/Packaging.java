package com.c4t.tools.decgen.elements;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Packaging {

    private int quantity;

    private String shippingMarks;

    private String type;

}
