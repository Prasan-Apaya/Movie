package com.prasan.movie.config;

import com.prasan.movie.models.Countries;
import com.prasan.movie.repository.CountryRepository;
import com.prasan.movie.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MovieConfig {

    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    CommandLineRunner commandLineRunner(CountryRepository countryRepository) {
        return args -> {
            List<String> countriesName = List.of("aU", "bR", "cA", "cAQC", "dE", "eS", "fR", "gB", "hU", "kR", "lT", "nL", "pH", "pT", "rU", "sK", "tH", "uS", "iT", "fI", "mY", "nZ", "nO", "bG", "mX", "iN", "dK", "sE", "iD", "tR", "aR", "pL", "mA", "gR", "iL", "tW", "zA", "sG", "pR", "vI");
            List<Countries> countries = new ArrayList<>();
            for (String country : countriesName) {
                countries.add(new Countries(country));
            }
            countryRepository.saveAll(countries);
        };
    }
}
