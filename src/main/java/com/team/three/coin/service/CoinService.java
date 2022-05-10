package com.team.three.coin.service;

import com.team.three.coin.entity.Coin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CoinService {

    // 제외 코인 리스트
    Flux<Coin> getCoinLists();

    // 제외 코인 저장, 삭제
    Mono<Coin> updateVisibleCoin(Coin coin);

    // 제외 코인 저장
    Mono<Coin> createVisibleCoin(Coin coin);

    // 제외 코인 삭제
    Mono<Coin> deleteVisibleCoin(Coin coin);
}
