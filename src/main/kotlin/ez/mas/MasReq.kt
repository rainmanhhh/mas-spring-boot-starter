package ez.mas

class MasReq {
  /**
   * 企业名称
   */
  var ecName: String? = null

  /**
   * 接口账号用户名
   */
  var apId: String? = null

  /**
   * 收信手机号码。英文逗号分隔，每批次限5000个号码，例：“13800138000,13800138001,13800138002”
   */
  var mobiles: String? = null

  /**
   * 短信内容
   */
  var content: String? = null

  /**
   * 签名编码。在云MAS平台『管理』→『接口管理』→『短信接入用户管理』获取
   */
  var sign: String? = null

  /**
   * 扩展码。依据申请开户的服务代码匹配类型而定，如为精确匹配，此项填写空字符串（""）；如为模糊匹配，此项可填写空字符串或自定义的扩展码，注：服务代码加扩展码总长度不能超过20位
   */
  var addSerial: String? = null

  /**
   * 参数校验序列，生成方法：将ecName、apId、secretKey、mobiles、content、sign、addSerial按序拼接（无间隔符），通过MD5（32位小写）计算得出值
   */
  var mac: String? = null
}