package com.c4t.tools.decgen.elements;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GovernmentAgencyGoodsItem {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String containerIdentification;

    private List<AdditionalDocument> additionalDocuments = new ArrayList<>();

    private Commodity commodity;

    private GoodsMeasure goodsMeasure;

    private GovernmentProcedure governmentProcedure;

    private List<AdditionalDocument> previousDocuments = new ArrayList<>();

    private List<Packaging> packagings = new ArrayList<>();

    private Ucr ucr;

}
