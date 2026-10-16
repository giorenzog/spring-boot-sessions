package com.daily.session_two.dto;

public class BatchInsertResponse {

    private int totalRequested;
    private int totalInserted;

    public int getTotalRequested() {
        return totalRequested;
    }

    public void setTotalRequested(int totalRequested) {
        this.totalRequested = totalRequested;
    }

    public int getTotalInserted() {
        return totalInserted;
    }

    public void setTotalInserted(int totalInserted) {
        this.totalInserted = totalInserted;
    }
}
