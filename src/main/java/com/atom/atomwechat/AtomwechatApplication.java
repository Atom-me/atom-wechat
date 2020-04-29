package com.atom.atomwechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author atom
 */
@SpringBootApplication
@EnableCaching
public class AtomwechatApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtomwechatApplication.class, args);
    }

}
