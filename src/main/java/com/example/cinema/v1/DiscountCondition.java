package com.example.cinema.v1;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
