package com.team.three.coin.handler;

import com.team.three.coin.entity.Coin;
import com.team.three.coin.entity.Favorites;
import com.team.three.coin.service.CoinService;
import com.team.three.coin.service.FavoritesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CoinHandler {

    private final CoinService coinService;

    private final FavoritesService favoritesService;

    Mono<ServerResponse> notFound = ServerResponse.notFound().build();

    // 제외 코인 조회
    public Mono<ServerResponse> getCoinList(ServerRequest request) {

        Flux<Coin> coinMono = coinService.getCoinLists();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(coinMono, Coin.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                ;
    }

    // 코인 노출 ON/OFF
    public Mono<ServerResponse> updateCoinVisibleStatus(ServerRequest request) {
        Mono<Coin> coinMono = request.bodyToMono(Coin.class)
                .flatMap(coin -> {
                    if (coin.getCoinName() == null) return coinService.deleteVisibleCoin(coin);
                    else  return coinService.createVisibleCoin(coin);
                }).log();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(coinMono, Coin.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                ;
    }

    // 관심 코인 조회
    public Mono<ServerResponse> getFavoriteCoins(ServerRequest request) {

        Mono<Favorites> favoritesMono = favoritesService.getFavoriteCoins(request.queryParam("userId").toString());

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(favoritesMono, Favorites.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                ;
    }

    // 관심 코인 등록
    public Mono<ServerResponse> updateFavoriteCoin(ServerRequest request) {

        Mono<Favorites> favoritesMono = request.bodyToMono(Favorites.class)
                .flatMap(favoritesService::updateFavoriteCoin)
                .log()
                ;
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(favoritesMono, Favorites.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                ;
    }
}
