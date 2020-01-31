package programm.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import programm.model.Currency;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String allCurrencyString = "http://nbrb.by/API/ExRates/Rates?Periodicity=0";

        ResponseEntity<Currency[]> response = restTemplate.getForEntity(allCurrencyString, Currency[].class);
        Currency[] currencies = response.getBody();
        List<Currency> currencyList = Arrays.asList(currencies);
        model.addAttribute("curses", currencyList);

        List<String> curShortNamesList = currencyList.stream()
                .map(Currency::getAbbreviation)
                .sorted()
                .collect(Collectors.toList());
        model.addAttribute("shortNames", curShortNamesList);

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));
        model.addAttribute("date", date);
        return "main";
    }
}
