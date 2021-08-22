package com.kodilla.patterns2.patterns.strategy.predictors;

import com.kodilla.patterns2.patterns.strategy.BuyPredictor;

public class AggressivePredictor implements BuyPredictor {
    @Override
    public String predictWhatToBuy() {
        return "[Aggressive predictor] Buy stock of XYZ";
    }
}