package programm.controllers;

import com.google.gson.Gson;
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
        String jsonCurrency = restTemplate.getForObject(currAndDateString, String.class);   // запрос на сервер за json
        Currency currency = new Gson().fromJson(jsonCurrency, Currency.class); // преобразование json в java-объект
        return currency.getCur_OfficialRate() + " за " + currency.getCur_Scale() + " " + currency.getCur_Name();
    }
}
