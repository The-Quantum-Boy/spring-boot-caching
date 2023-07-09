package com.cache.config;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.EntryUnit;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.core.EhcacheManager;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EhCacheConfiguration {

    @Bean
    public CacheManager cacheManager(){
        return ehCacheManager();
    }

    private CacheManager ehCacheManager() {
        return (CacheManager) CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("exampleCache",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(
                                        String.class, String.class,
                                        ResourcePoolsBuilder.newResourcePoolsBuilder()
                                                .heap(100, EntryUnit.ENTRIES)
                                                .offheap(1, MemoryUnit.MB))
                                .build())
                .build(true);
    }
}
