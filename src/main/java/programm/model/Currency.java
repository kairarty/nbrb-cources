package programm.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Currency {   // поля модели для json-объекта должны быть с ними одноимённы!
    // над полем можно указанть аннотацию @JsonProperty("jsonParameterName"), если не хочешь, чтобы имя поля совпадала с именем ключа json
    int Cur_ID;
    String Date;
    String Cur_Abbreviation;
    int Cur_Scale;
    String Cur_Name;
    double Cur_OfficialRate;
}
