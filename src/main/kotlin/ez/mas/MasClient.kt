package ez.mas

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(name = "ez.mas.client", url = "\${ez.mas.url}")
interface MasClient {
  @PostMapping(value = ["/sms/norsubmit"], consumes = ["text/plain"])
  fun sendSms(body: String): ResponseEntity<MasResp>
}