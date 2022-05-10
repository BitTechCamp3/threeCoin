package com.team.three.coin.service.impl;

import com.team.three.coin.entity.Coin;
import com.team.three.coin.entity.Favorites;
import com.team.three.coin.repository.CoinRepository;
import com.team.three.coin.repository.FavoritesRepository;
import com.team.three.coin.service.CoinService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoinServiceImpl implements CoinService {

    private final CoinRepository coinRepository;
    private final FavoritesRepository favoritesRepository;

    public CoinServiceImpl(CoinRepository coinRepository,
                           FavoritesRepository favoritesRepository) {
        this.coinRepository = coinRepository;
        this.favoritesRepository = favoritesRepository;
    }

    @Override
    public Flux<Coin> getCoinLists() {
        return coinRepository.findAll();
    }

    @Override
    public Mono<Coin> updateVisibleCoin(Coin coin) {
        String coinSym = coin.getCoinSym();

        return coinRepository.findByCoinSym(coinSym)
                .hasElement()
                .flatMap(existed -> {
                    if(existed)
                        return coinRepository.deleteVisibleCoin( coinSym);
                    else
                        return coinRepository.save(coin);
                }).log();
    }

    @Override
    public Mono<Coin> createVisibleCoin(Coin coin) {
        return coinRepository.save(coin);
    }

    @Override
    public Mono<Coin> deleteVisibleCoin(Coin coin) {
        String coinSym = coin.getCoinSym();
        return coinRepository.deleteVisibleCoin(coinSym);
    }
}
