package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection="barrisdata")
public class NeighborhoodData {

    @Id
    @JsonIgnore
    private String id;

    private String Barri;
    private Integer Hab;
    private Integer hab_Muj;
    private Double Hab_Muj_perc;
    private Integer Hab_Hom;
    private Double Hab_Hom_Perc;
    private Integer Hab_00_01_Reg;
    private Double Hab_00_01_Reg_Perc;
    private Integer Hab_01_05_Reg;
    private Double Hab_01_05_Reg_Perc;
    private Integer Hab_06_15_Reg;
    private Double Hab_06_15_Reg_Perc;
    private Integer Hab_15_nn_Reg;
    private Double Hab_15_nn_Reg_perc;
    private Integer Hab_00_15_Age;
    private Double Hab_00_15_Age_Perc;
    private Integer Hab_16_24_Age;
    private Double Hab_16_24_Age_Perc;
    private Integer Hab_25_39_Age;
    private Double Hab_25_39_Age_Perc;
    private Integer Hab_40_64_Age;
    private Double Hab_40_64_Age_Perc;
}
