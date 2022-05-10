package com.team.three.coin.service;

import com.team.three.coin.entity.Favorites;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FavoritesService {

    // 관심코인 리스트
    Flux<Favorites> getFavoriteCoins(Favorites favorites);

    // 관심코인 등록
    Mono<Favorites> updateFavoriteCoin(Favorites favorites);

    // 관심코인 삭제
    Mono<Favorites> deleteFavoriteCoin(String userId, String coinSym);
}
