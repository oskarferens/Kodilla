package com.kodilla.patterns2.patterns.strategy.predictors;

import com.kodilla.patterns2.patterns.strategy.BuyPredictor;

public class ConservativePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Conservative predictor] Buy debentures of XYZ";
    }
}