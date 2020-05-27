package io.spring.workshop.tradingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

@Controller
public class QuotesController {

    @Autowired
    private QuotesClient quotesClient;

    @GetMapping(path = "/quotes/feed", produces = TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Quote> quotesFeed() {
        return this.quotesClient.quoteFeed();
    }
}
