package com.team.three.coin.service.impl;

import com.team.three.coin.entity.Favorites;
import com.team.three.coin.repository.FavoritesRepository;
import com.team.three.coin.service.FavoritesService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FavoritesServiceImpl implements FavoritesService {

    private final FavoritesRepository favoritesRepository;

    public FavoritesServiceImpl(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    @Override
    public Mono<Favorites> getFavoriteCoins(String userId) {
        return favoritesRepository.findFavoriteCoinsByUserId(userId);
    }

    @Override
    public Mono<Favorites> updateFavoriteCoin(Favorites favorites) {
        String userId = favorites.getUserId();
        String coinSym = favorites.getCoinSym();
        System.out.println(favorites);
        return favoritesRepository.countFavoriteCoinByUserIdAndCoinSym(userId, coinSym)
                .doOnNext(data -> System.out.println("sout : " + data))
                .flatMap(favoritesMono -> {
                    System.out.println(favoritesMono);
                    System.out.println("getCoinSym() : " + favoritesMono.getCoinSym());
                    if (favoritesMono.getCoinSym() == null) return favoritesRepository.save(favorites);
                    else return favoritesRepository.deleteFavoriteCoin(userId, coinSym);
                }).log();
    }

    @Override
    public Mono<Favorites> deleteFavoriteCoin(String userId, String coinSym) {
        return favoritesRepository.deleteFavoriteCoin(userId, coinSym);
    }
}
