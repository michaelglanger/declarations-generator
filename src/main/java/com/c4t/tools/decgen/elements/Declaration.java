package com.c4t.tools.decgen.elements;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
public class Declaration {

    private String version;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String customsFlow; // TODO do we need this?

    private String direction;

    private String externalReference;

    private String messageType;

    private String storageLocationReference;

    private SingleAdministrativeDocument singleAdministrativeDocument;

}
