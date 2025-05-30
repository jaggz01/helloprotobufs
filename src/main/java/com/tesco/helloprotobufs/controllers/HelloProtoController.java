package com.tesco.helloprotobufs.controllers;

import com.google.protobuf.InvalidProtocolBufferException;
import com.tesco.helloprotobufs.model.MovieDetails;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.google.protobuf.util.JsonFormat;
import protos.MovieDetailsProto;

import java.util.List;
import java.util.logging.Logger;

@RestController
@AllArgsConstructor
public class HelloProtoController {

    private final List<MovieDetailsProto.MovieDetails> movieDetails;
    private final List<MovieDetails> movieDetailsModel;

    private static final Logger logger = Logger.getLogger(HelloProtoController.class.getName());

    @GetMapping(value = "/movieDetails/{title}", consumes = {MediaType.APPLICATION_PROTOBUF_VALUE} )
    public String getMovieDetailsProto(@PathVariable String title) throws InvalidProtocolBufferException {
        logger.info("ProtoBuf: Fetching movie details for title: " + title);
        MovieDetailsProto.MovieDetails movieDetailsResp = movieDetails
                .stream()
                .filter(movie -> movie.getTitle().trim().equals(title.trim()))
                .findFirst()
                .orElse(null);
            return JsonFormat.printer().print(movieDetailsResp); // Convert Protobuf object to JSON

    }

    @GetMapping(value = "/movieDetails/{title}", consumes = {MediaType.APPLICATION_JSON_VALUE} )
    public MovieDetails getMovieDetailsModel(@PathVariable String title) {
        logger.info("Model: Fetching movie details for title: " + title);
        return movieDetailsModel.stream()
                .filter(movie -> movie.getTitle().trim().equals(title.trim()))
                .findFirst()
                .orElse(null);
    }
}
