package com.example.lesson2;

public class CountingDoneEvent {
    private boolean workDone = false;

    public CountingDoneEvent(boolean isWorkDone) {
        workDone = isWorkDone;
    }

    public boolean isWorkDone() {
        return workDone;
    }
}
