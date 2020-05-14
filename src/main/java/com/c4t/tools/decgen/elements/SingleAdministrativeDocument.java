package com.c4t.tools.decgen.elements;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class SingleAdministrativeDocument {

    private String accDateCode;

    private String addDeclType1;

    private List<AdditionalInformation> additionalInformations = new ArrayList<>();

    private String agentStatus;

    private String declarationOfficeCode;

    private String declType;

    private String docRefNum;

    private String invoiceCurrency;

    private List<CalculationReturn> calculationReturns = new ArrayList<>();

    private Declarant declarant;

    private GoodsShipment goodsShipment;

    private Importer importer;

}
