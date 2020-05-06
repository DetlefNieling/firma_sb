package info.nieling.firma;

import info.nieling.firma.model.Book;
import info.nieling.firma.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public
class FirmaApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(FirmaApplication.class);

	@Autowired
	private BookRepository repository;

	public static
	void main ( String[] args ) {
		SpringApplication.run(FirmaApplication.class, args);
	}

	@Override
	public
	void run ( String... args ) {

		log.info("StartApplication...");

		repository.save(new Book("Java"));
		repository.save(new Book("Node"));
		repository.save(new Book("Python"));

		log.info("\nfindAll()");
		repository.findAll().forEach(x -> log.info(String.valueOf(x)));

		log.info("\nfindById(1L)");
		// repository.findById(1).ifPresent(x -> log.info(String.valueOf(x)));

		log.info("\nfindByName('Node')");
		repository.findByName("Node").forEach(x -> log.info(String.valueOf(x)));

	}

}
