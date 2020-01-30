package programm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@JsonIgnoreProperties(ignoreUnknown = true)   // игнорировать остальные поля json-объекта
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NeedCurrency {
    String Cur_Abbreviation;
    int Cur_Scale;
    double Cur_OfficialRate;
    String Cur_Name;
}
