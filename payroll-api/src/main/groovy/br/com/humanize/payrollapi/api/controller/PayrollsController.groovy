package br.com.humanize.payrollapi.api.controller

import br.com.humanize.payrollapi.domain.Payrolls
import br.com.humanize.payrollapi.service.PayrollsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/payments")
class PayrollsController {

    @Autowired
    PayrollsService payrollsService

    @GetMapping("/{workerId}")
    ResponseEntity<Payrolls> getPayment(@PathVariable Long workerId, @RequestBody Payrolls payment) {

        return ResponseEntity.ok().body(
            payrollsService.getPayment(workerId, payment)
        )
    }
}
