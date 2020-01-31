package programm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {   // поля модели для json-объекта должны быть с ними одноимённы!
    @JsonProperty("Date")   // если не хочешь, чтобы имя поля совпадала с именем ключа json. Имена полей с больших букв не работают
    String date;
    @JsonProperty("Cur_Abbreviation")
    String abbreviation;
    @JsonProperty("Cur_Scale")
    int scale;
    @JsonProperty("Cur_Name")
    String name;
    @JsonProperty("Cur_OfficialRate")
    double officialRate;
}
