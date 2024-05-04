package br.facens.projeto03.model;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Produto {
    private Long cod;
    private String name;
    private double value;
    private Date valid;
}
