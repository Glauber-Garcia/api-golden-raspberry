package com.br.glauber.apigoldenraspberry.model;

import java.util.List;

public class PrizesInterval {
    private List<PrizesIntervalData> min;
    private List<PrizesIntervalData> max;

    public List<PrizesIntervalData> getMin() {
        return min;
    }

    public void setMin(List<PrizesIntervalData> min) {
        this.min = min;
    }

    public List<PrizesIntervalData> getMax() {
        return max;
    }

    public void setMax(List<PrizesIntervalData> max) {
        this.max = max;
    }
}
