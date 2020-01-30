package programm;


import org.springframework.web.client.RestTemplate;
import programm.model.Currency;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl1 = "http://nbrb.by/API/ExRates/Rates/USD?ParamMode=2";    // адрес возвращает 1 json-объект
        String fooResourceUrl2 = "http://nbrb.by/API/ExRates/Rates?Periodicity=0";  // адрес возвращает массив json-объектов
        String currAndDate = "http://nbrb.by/API/ExRates/Rates/USD?OnDate=2019-01-01&ParamMode=2";  // возвращает объект с выбранной валютой и датой

        String currDate = restTemplate.getForObject(currAndDate, String.class);
        String objectForJson = restTemplate.getForObject(fooResourceUrl1, String.class);    // запрос на сервер за json
        String arrayForJson = restTemplate.getForObject(fooResourceUrl2, String.class);

        //Currency curr1 = new Gson().fromJson(currDate, Currency.class);
        //Currency curr = new Gson().fromJson(objectForJson, Currency.class); // конвертация json-строки в объект
        //System.out.println(curr);
        //System.out.println(curr1);


        //Type listType = new TypeToken<ArrayList<Currency>>(){}.getType(); // конвертация строки с массивом json-объектов в
        //List<Currency> yourClassList = new Gson().fromJson(arrayForJson, listType);  // список объектов java/yourClassList.forEach(System.out::println);
        //yourClassList.forEach(System.out::println);
    }
}
