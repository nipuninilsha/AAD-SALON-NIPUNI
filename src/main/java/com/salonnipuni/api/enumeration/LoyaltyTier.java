package com.salonnipuni.api.enumeration;


public enum LoyaltyTier {
    SILVER(0, 0.0),
    GOLD(500, 0.05),
    DIAMOND(1500, 0.10);

    private final int minPoints;
    private final double discountRate;

    LoyaltyTier(int minPoints, double discountRate) {
        this.minPoints = minPoints;
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public static LoyaltyTier fromPoints(int points) {
        if (points >= DIAMOND.minPoints) return DIAMOND;
        if (points >= GOLD.minPoints) return GOLD;
        return SILVER;
    }
}
