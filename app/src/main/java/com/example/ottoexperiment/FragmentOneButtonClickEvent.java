package com.example.ottoexperiment;

import lombok.Getter;

/**
 * Created by rupam.ghosh on 09/01/16.
 */
public class FragmentOneButtonClickEvent {
    @Getter
    private int count;

    public FragmentOneButtonClickEvent(int count) {
        this.count = count;
    }
}
