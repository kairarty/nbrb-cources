package programm.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import programm.model.Currency;

@RestController
public class Rest {
    @GetMapping("getFormInfo/{moneyType},{date}")
    public String transferMouseContract(@PathVariable String moneyType, @PathVariable String date) {
        RestTemplate restTemplate = new RestTemplate();
        String currAndDateString = "http://nbrb.by/API/ExRates/Rates/" + moneyType + "?OnDate=" + date + "&ParamMode=2";  // возвращает 1 объект с выбранной валютой и датой
        Currency currency = restTemplate.getForObject(currAndDateString, Currency.class); // преобразование json в java-объект
        return currency.getOfficialRate() + " за " + currency.getScale() + " " + currency.getName();
    }
}
