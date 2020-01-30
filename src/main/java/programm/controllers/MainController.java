package programm.controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import programm.model.Currency;
import programm.model.NeedCurrency;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String allCurrencyString = "http://nbrb.by/API/ExRates/Rates?Periodicity=0";    // адрес возвращает строку-массив json-объектов
        try {
            String arrayForJson = restTemplate.getForObject(allCurrencyString, String.class);
            Type listType = new TypeToken<ArrayList<Currency>>(){}.getType();
            List<Currency> allCurrencyList = new Gson().fromJson(arrayForJson, listType);   // конвертация json-массива из строки в список
            List<String> curShortNamesList = allCurrencyList.stream()
                    .map(Currency::getCur_Abbreviation)
                    .sorted()
                    .collect(Collectors.toList());
            model.addAttribute("shortNames", curShortNamesList);

            String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));
            model.addAttribute("date", date);

            Type listType2 = new TypeToken<ArrayList<NeedCurrency>>(){}.getType();
            List<NeedCurrency> cursesList = new Gson().fromJson(arrayForJson, listType2);
            List<NeedCurrency> sortedCourcesList = cursesList.stream()
                    .sorted(Comparator.comparing(NeedCurrency::getCur_Abbreviation)).collect(Collectors.toList());

            model.addAttribute("curses", sortedCourcesList);
        } catch (Exception ignored) {}
        return "main";
    }
}
