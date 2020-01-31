package programm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
    @JsonProperty("Date")
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
