package com.tesco.helloprotobufs;

import com.tesco.helloprotobufs.model.MovieDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import protos.MovieDetailsProto;

import java.util.List;

@SpringBootApplication
@Configuration
public class HelloprotobufsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloprotobufsApplication.class, args);
	}


	@Bean
	public List<MovieDetailsProto.MovieDetails> getMovieDetailsProto() {

		MovieDetailsProto.Cast cast1 = MovieDetailsProto.Cast.newBuilder()
				.setActorName("Frank Darabont")
				.build();
		MovieDetailsProto.Cast cast2 = MovieDetailsProto.Cast.newBuilder()
				.setActorName("Alfred Hitchcock")
				.build();

		MovieDetailsProto.MovieDetails movieDetails = MovieDetailsProto.MovieDetails.newBuilder()
				.setTitle("The Shawshank Redemption")
				.setDescription("Two imprisoned men bond over a dystopian society")
				.setDirector("Francis Ford Coppola")
				.setReleaseYear(1994)
				.setRating("9.3")
				.addCast(cast1)
				.addCast(cast2)
				.build();

		return List.of(movieDetails);
    }

	@Bean
	public List<MovieDetails> getMovieDetailsModel() {
		MovieDetails.Cast cast1 = MovieDetails.Cast
				.builder()
				.actorName("Frank Darabont")
				.build();
		MovieDetails.Cast cast2 = MovieDetails.Cast
				.builder()
				.actorName("Alfred Hitchcock")
				.build();

		return List.of(MovieDetails.builder()
				.movieId(1L)
				.title("The Shawshank Redemption")
				.genre(new String[]{"Crime", "Drama"})
				.description("Two imprisoned men bond over a dystopian society")
				.director("Francis Ford Coppola")
				.releaseYear(1994)
				.cast(List.of(cast1, cast2))
				.build());
	}
}
