package br.com.humanize.payrollapi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class PayrollApiApplication {

	static void main(String[] args) {
		SpringApplication.run(PayrollApiApplication, args)
	}

}
