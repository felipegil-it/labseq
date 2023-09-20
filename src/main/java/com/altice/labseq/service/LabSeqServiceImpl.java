package com.altice.labseq.service;

import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Service;

@Service
public class LabSeqServiceImpl implements LabSeqService{

    private final static String CACHEABLE_NAME = "labseq";
    private Cache cache;
    public LabSeqServiceImpl() {
        cache = new ConcurrentMapCacheManager(CACHEABLE_NAME).getCache(CACHEABLE_NAME);
        cache.put(0, 0L);
        cache.put(1, 1L);
        cache.put(2, 0L);
        cache.put(3, 1L);
    }

    private boolean containsKey(int i){
        return cache.get(i) != null;
    }

    @Cacheable(CACHEABLE_NAME)
    @Override
    public long calcValFromLabSeq(int n){
        if (!containsKey(n))
            cache.put(n, calcValFromLabSeq(n - 4) + calcValFromLabSeq(n - 3));
        return (Long)cache.get(n).get();
    }

}
