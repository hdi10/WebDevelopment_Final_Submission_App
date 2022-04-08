package com.okta.springbootjpa;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.Database;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

	@Bean
	ApplicationRunner init(ProductRepository repository) {



		String[][] data = {

				//Product(id=3, product_nr=2, name=4013034730061, name_manufacturer=Rübensirup, ean=2023-08-18, inhalt=Rüber Rübe, mhd=Rüber Rübe)
				{"3","1312", "Instant Getränk", "King George", "4021155175104"
				,"Zucker","2022-09-01"},
				{"1","344","Effect","BNG International Premium","4025127020997","Zucker","2022-01-15"},
				{"2","4013034730061","Rübensirup","Rüber Rübe","Rüber Rübe","2023-08-18" },
				{"4025", "Mars", "Free", "651432","someInhalt","datumhd"},
				{"502", "Oreo", "Nestle", "651432","someInhalt","datumhd"},
				{"89", "Tee", "Granny", "651432","someInhalt","datumhd"}
		};

		return args -> {
			Stream.of(data).forEach(array -> {
				Product product = new Product(
						array[0],
						array[1],
						array[2],
						array[3],
						array[4],
						array[5]

				);
				repository.save(product);
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
