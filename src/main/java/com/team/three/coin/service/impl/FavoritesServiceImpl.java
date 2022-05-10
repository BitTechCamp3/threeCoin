package com.team.three.coin.service.impl;

import com.team.three.coin.entity.Favorites;
import com.team.three.coin.repository.FavoritesRepository;
import com.team.three.coin.service.FavoritesService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FavoritesServiceImpl implements FavoritesService {

    private final FavoritesRepository favoritesRepository;

    public FavoritesServiceImpl(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    @Override
    public Flux<Favorites> getFavoriteCoins(Favorites favorites) {
        String userId = favorites.getUserId();
        return favoritesRepository.findFavoriteCoinsByUserId(userId);
    }

    @Override
    public Mono<Favorites> updateFavoriteCoin(Favorites favorites) {
        String userId  = favorites.getUserId();
        String coinSym = favorites.getCoinSym();
        return favoritesRepository.countFavoriteCoinByUserIdAndCoinSym(userId, coinSym)
                .hasElement()
                .flatMap(existed -> {
                    if(existed)
                        return favoritesRepository.deleteFavoriteCoin(userId, coinSym);
                    else
                        return favoritesRepository.save(favorites);
                }).log();
    }

    @Override
    public Mono<Favorites> deleteFavoriteCoin(String userId, String coinSym) {
        return favoritesRepository.deleteFavoriteCoin(userId, coinSym);
    }
}
