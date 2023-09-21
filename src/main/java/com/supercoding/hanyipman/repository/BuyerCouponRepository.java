package com.supercoding.hanyipman.repository;

import com.supercoding.hanyipman.entity.Buyer;
import com.supercoding.hanyipman.entity.BuyerCoupon;
import com.supercoding.hanyipman.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyerCouponRepository extends JpaRepository<BuyerCoupon, Long> {

    boolean existsBuyerCouponByCouponAndBuyer(Coupon coupon, Buyer buyer);

    List<BuyerCoupon> findBuyerCouponsByBuyer(Buyer buyer);
}
