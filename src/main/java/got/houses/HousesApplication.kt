package got.houses

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
class HousesApplication

fun main(args: Array<String>) {
	SpringApplication.run(HousesApplication::class.java, *args)
}


