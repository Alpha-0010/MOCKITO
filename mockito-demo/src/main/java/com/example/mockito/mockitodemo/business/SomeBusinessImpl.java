package com.example.mockito.mockitodemo.business;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class SomeBusinessImpl {

    private final DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData() {
        int[] data = dataService.retrieveAllData();
        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
        Arrays.
                stream(data).
                forEach((elem) -> {
                    max.set(Math.max(max.get(), elem));
                });

        return max.intValue();
    }
}

interface DataService {
    int[] retrieveAllData();
}
