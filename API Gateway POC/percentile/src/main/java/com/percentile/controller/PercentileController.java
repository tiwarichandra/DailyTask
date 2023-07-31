package com.percentile.controller;


import com.percentile.entities.Percentile;
import com.percentile.service.PercentileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/percentile")
@RequiredArgsConstructor
public class PercentileController {

    private final PercentileService percentileService;

    @PostMapping("/getPerncetile")
    public Integer getPercentile(@RequestBody Percentile percentile) {

        return percentileService.getPercentile(percentile);

    }


}
