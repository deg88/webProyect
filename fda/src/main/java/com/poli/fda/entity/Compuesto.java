package com.poli.fda.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Unwrapped;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document("compuestos")
public class Compuesto {

    @Id
    private String name;

    private int rda;

    private String wiki;

    private boolean required;

    private String type;

    @Unwrapped.Nullable
    private int tui;

}
