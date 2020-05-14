package com.c4t.tools.decgen.elements;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class GoodsShipment {

    private String exportCountry;

    private int trxNatCode;

    private Consignment consignment;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CustomsValuation customsValuation;

    private Exporter exporter;

    private TradeTerms tradeTerms;

    private Ucr ucr;

    private List<GovernmentAgencyGoodsItem> governmentAgencyGoodsItems = new ArrayList<GovernmentAgencyGoodsItem>();

}
