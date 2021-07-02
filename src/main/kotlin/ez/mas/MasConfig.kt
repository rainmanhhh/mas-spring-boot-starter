package ez.mas

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.stereotype.Component

@EnableFeignClients("ez.mas")
@ConfigurationProperties("ez.mas")
@Component
class MasConfig {
  /**
   * mas平台服务器地址
   */
  lateinit var url: String

  /**
   * 企业名称
   */
  lateinit var ecname: String

  /**
   * 接口账号用户名
   */
  lateinit var apid: String

  /**
   * 密钥
   */
  lateinit var secretKey: String

  /**
   * 签名编码。在云MAS平台『管理』→『接口管理』→『短信接入用户管理』获取
   */
  lateinit var sign: String

  /**
   * 扩展码。依据申请开户的服务代码匹配类型而定，如为精确匹配，此项填写空字符串（""）；如为模糊匹配，此项可填写空字符串或自定义的扩展码，注：服务代码加扩展码总长度不能超过20位
   */
  lateinit var addSerial: String
}