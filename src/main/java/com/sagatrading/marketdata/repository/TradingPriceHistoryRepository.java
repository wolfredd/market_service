package com.sagatrading.marketdata.repository;

import com.sagatrading.marketdata.model.TradingPriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface TradingPriceHistoryRepository extends JpaRepository<TradingPriceHistory, Integer> {
}
