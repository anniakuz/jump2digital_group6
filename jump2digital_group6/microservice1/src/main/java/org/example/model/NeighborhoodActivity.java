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
@Document(collection="sectorperbarri")
public class NeighborhoodActivity {
    @Id
    @JsonIgnore
    private String id;

    private String Nom_Barri;

    private String Nom_Grup_Activitat;

    private int counts;



}
