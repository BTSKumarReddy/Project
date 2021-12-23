package com.project.tharun.SectorServiceApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Document(collection = "Sector")
public class Sector {
    @Id
    @JsonProperty("Id")
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String brief;

    @DBRef
    private List<Company> companies=new ArrayList<>();

    public Sector(String id, @NonNull String name, @NonNull String brief) {
        this.id = id;
        this.name = name;
        this.brief = brief;
    }
}
