package ez.mas

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.ResponseEntity
import org.springframework.util.DigestUtils
import java.io.UnsupportedEncodingException
import java.nio.charset.StandardCharsets
import java.util.*

class Mas(
  private val config: MasConfig,
  private val client: MasClient
) {
  private val objectMapper = ObjectMapper()

  private fun buildReq(mobiles: String, content: String): MasReq {
    return try {
      MasReq().apply {
        ecName = config.ecname
        apId = config.apid
        sign = config.sign
        addSerial = config.addSerial
        this.mobiles = mobiles
        this.content = content
        mac = DigestUtils.md5DigestAsHex(
          (ecName + apId + config.secretKey + mobiles + content + sign + addSerial).toByteArray()
        )
      }
    } catch (e: UnsupportedEncodingException) {
      throw RuntimeException(e)
    }
  }

  private fun buildBase64(mobiles: String, content: String): String {
    val request: MasReq = buildReq(mobiles, content)
    return try {
      val jsonStr = objectMapper.writeValueAsString(request)
      val bytes = jsonStr.toByteArray(StandardCharsets.UTF_8)
      Base64.getEncoder().encodeToString(bytes)
    } catch (e: JsonProcessingException) {
      throw RuntimeException(e)
    }
  }

  private fun buildBase64(mobiles: Iterable<String>, content: String): String {
    val mobileStr = mobiles.joinToString()
    return buildBase64(mobileStr, content)
  }

  fun sendSms(mobiles: Iterable<String>, content: String): MasResp {
    val reqStr = buildBase64(mobiles, content)
    return client.sendSms(reqStr).body!!
  }
}