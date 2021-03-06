package com.atom.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author atom
 */
@SpringBootApplication
@EnableCaching
public class AtomWeChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtomWeChatApplication.class, args);
    }

}
