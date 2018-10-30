package com.bruce121.chapter3.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: Bruce121
 * Date: 2018-10-11
 */
@Setter
@Getter
public class Bruce121{
    private String name;
    private String website;

    public Bruce121() {
    }

    public Bruce121(String name, String website) {
        this.name = name;
        this.website = website;
    }
}
