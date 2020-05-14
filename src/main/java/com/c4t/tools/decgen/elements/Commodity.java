package com.c4t.tools.decgen.elements;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Commodity {

    private String description;

    private String itemId;

    private List<Classification> classifications = new ArrayList<>();

    private InvoiceLine invoiceLine;

}
