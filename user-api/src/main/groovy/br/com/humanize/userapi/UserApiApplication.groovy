package br.com.humanize.userapi

import br.com.humanize.userapi.domain.Users
import br.com.humanize.userapi.repository.UsersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient

@SpringBootApplication
@EnableEurekaClient
class UserApiApplication implements CommandLineRunner {

	@Autowired
	private UsersRepository userRepository

	static void main(String[] args) {
		SpringApplication.run(UserApiApplication, args)
	}

	@Override
	void run(String... args) throws Exception {

		userRepository.saveAll(List.of(
			new Users(id: null, name: "Felipe", email: "felipe@email.com", password: "123", hourlyPrice: 20.0),
			new Users(id: null, name: "Marina", email: "marina@email.com", password: "456", hourlyPrice: 18.5)
		))

	}
}
