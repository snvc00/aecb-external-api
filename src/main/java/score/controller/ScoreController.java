package score.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

import java.util.HashMap;

@Controller("/score")
public class ScoreController {
    @Get
    public HttpResponse score(@QueryValue Integer income, @QueryValue Boolean has_credit) {
        Double score = has_credit ? 50.0 : 0;
        Double highIncomePenalty = Math.min(income / 100000, 0.75);
        score += (income * (0.8 - highIncomePenalty)) / 100;

        HashMap<String, Double> body = new HashMap<String, Double>();

        body.put("score", score);

        return HttpResponse.ok().body(body);
    }
}