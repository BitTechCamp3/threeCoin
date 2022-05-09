package com.team.three.coin.router;

import com.team.three.coin.handler.CoinHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@EnableWebFlux
@Configuration
public class CoinRouter {

    @Bean
    public RouterFunction<ServerResponse> route(CoinHandler coinHandler) {
        return RouterFunctions
                .route()
                .GET("/coin/list", coinHandler::getCoinList)
                .POST("/coin/hide", coinHandler::updateCoinVisibleStatus)
                .POST("/coin/favorites", coinHandler::getFavoriteCoins)
                .POST("/coin/favorite", coinHandler::updateFavoriteCoin)
                .build();
    }
}
