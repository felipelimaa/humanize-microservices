package br.com.humanize.payrollapi.service

import br.com.humanize.payrollapi.domain.Payrolls
import br.com.humanize.payrollapi.feignClients.UserFeign
import br.com.humanize.payrollapi.service.exception.EntityNotFoundException
import feign.FeignException
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service

@Slf4j
@Service
class PayrollsService {

    @Autowired
    private final Environment env

    @Autowired
    private final UserFeign userFeign

    Payrolls getPayment(Long workerId, Payrolls payrolls) {
        log.info("PAYROLL_SERVICE ::: Get Request on " + env.getProperty("local.server.port") + " port.")
        try {
            def user = userFeign.findById(workerId).body

            if (Objects.nonNull(user)) {
                return new Payrolls(
                    workerName: user.name,
                    description: payrolls.description,
                    hourlyPrice: user.hourlyPrice,
                    workedHours: payrolls.workedHours,
                    totalPayment: payrolls.workedHours * user.hourlyPrice
                )
            }

        } catch (FeignException.NotFound ex) {
            throw new EntityNotFoundException()
        } catch (Exception ex) {
            throw new IllegalArgumentException("Illegal Argument Exception")
        }
        return null

    }

}
