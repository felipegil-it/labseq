package com.altice.labseq.service;

import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service
public class LabSeqServiceImpl implements LabSeqService{

    private final TreeMap<Integer, Long> cache = new TreeMap<>();

    public LabSeqServiceImpl() {
        cache.put(0, 0L);
        cache.put(1, 1L);
        cache.put(2, 0L);
        cache.put(3, 1L);
    }

    @Override
    public long getValueLabSeq(int n){
        if (!cache.containsKey(n)) {
            cache.put(n, calcValFromLabSeq(n));
        }
        return cache.get(n);
    }

    private long calcValFromLabSeq(int n){
        if (!cache.containsKey(n-4)) {
            cache.put(n-4, calcValFromLabSeq(n-4));
        }
        if (!cache.containsKey(n-3)) {
            cache.put(n-3, calcValFromLabSeq(n-3));
        }
        return  cache.get(n-4) + cache.get(n-3);
    }

}
