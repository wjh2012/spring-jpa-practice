package practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.query.CountryQuery;

@RestController
@RequiredArgsConstructor
public class CountryController {

    private final CountryQuery countryQuery;

    @GetMapping("/test")
    public void createMember() {
        countryQuery.test();
    }
}
