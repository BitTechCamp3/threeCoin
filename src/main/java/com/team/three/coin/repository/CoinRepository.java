package com.team.three.coin.repository;

import com.team.three.coin.entity.Coin;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public interface CoinRepository extends ReactiveCrudRepository<Coin, Integer> {

    @Query("select * from coin where coinSym = :coinSym")
    Mono<Coin> findByCoinSym(String coinSym);

    @Query("delete from coin where coinSym = :coinSym")
    Mono<Coin> deleteVisibleCoin(String coinSym);

}
