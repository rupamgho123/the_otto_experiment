package com.example.ottoexperiment;

import lombok.Getter;

/**
 * Created by rupam.ghosh on 09/01/16.
 */
public class FragmentTwoButtonClickEvent {

    @Getter
    private int count;

    public FragmentTwoButtonClickEvent(int count) {
        this.count = count;
    }
}
