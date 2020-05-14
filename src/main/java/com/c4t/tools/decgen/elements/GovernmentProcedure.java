package com.c4t.tools.decgen.elements;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class GovernmentProcedure {

    private String proc;

    private String prevProc;

    private String declProcType;

    private String procNat2;

}
