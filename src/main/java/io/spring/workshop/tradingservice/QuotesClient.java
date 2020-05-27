package io.spring.workshop.tradingservice;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class QuotesClient {

    private final WebClient webClient;

    public QuotesClient(WebClient.Builder webclientBuilder) {
        this.webClient = webclientBuilder.build();
    }

    public Flux<Quote> quoteFeed(){
        return this.webClient.get().uri("http://localhost:8081/quotes")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToFlux(Quote.class);
    }
}
