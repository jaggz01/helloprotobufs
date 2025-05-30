package com.tesco.helloprotobufs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieDetails {

    public long movieId;
    public String title;
    public String director;
    public long releaseYear;
    public String[] genre;
    public String rating;
    public String description;
    public List<Cast> cast;

    @Builder
    public static class Cast {
        public String actorName;
        public String characterName;
    }

}
