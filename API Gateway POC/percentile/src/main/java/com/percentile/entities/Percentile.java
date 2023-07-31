package com.percentile.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Percentile {

    private List<Integer> arrList;

    private Integer percentile;
}
