package com.percentile.serviceImpl;

import com.percentile.entities.Percentile;
import com.percentile.service.PercentileService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PercentileServiceImpl implements PercentileService {
    @Override
    public Integer getPercentile(Percentile percentile) {

        List<Integer> arrList = percentile.getArrList();

        Optional<Integer> max = arrList.stream().max(Comparator.comparing(Integer::intValue));

        int finalValue = (percentile.getPercentile()*100) / max.get();

        if (arrList.contains(finalValue)) {
            return finalValue;
        }
        return finalValue;
    }
}
