package com.team.three.coin.repository;

import com.team.three.coin.entity.Favorites;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public interface FavoritesRepository extends ReactiveCrudRepository<Favorites, Integer> {

    @Query("select * from favorites where userId = :userId")
    Flux<Favorites> findFavoriteCoinsByUserId(String userId);

    @Query("select * from favorites where userId = :userId and coinSym = :coinSym")
    Mono<Favorites> countFavoriteCoinByUserIdAndCoinSym(String userId, String coinSym);

    @Query("delete from favorites where userId = :userId and coinSym = :coinSym")
    Mono<Favorites> deleteFavoriteCoin(String userId, String coinSym);
}
