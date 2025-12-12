package com.gexingw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = "com.gexingw")
public class MapStructApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(MapStructApplication.class, args);
    }

}
