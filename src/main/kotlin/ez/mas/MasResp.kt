package ez.mas

class MasResp {
  /**
   * 响应状态，详见下表
   * IllegalMac	mac校验不通过。
   * IllegalSignId	无效的签名编码。
   * InvalidMessage	非法消息，请求数据解析失败。
   * InvalidUsrOrPwd	非法用户名/密码。
   * NoSignId	未匹配到对应的签名信息。
   * success	数据验证通过。
   * TooManyMobiles	手机号数量超限（>5000），应≤5000。
   */
  var rspcod: String = "success"

  /**
   * 消息批次号，由云MAS平台生成，用于关联短信发送请求与状态报告，注：若数据验证不通过，该参数值为空。成功例子：0927152506001000833076
   */
  var msgGroup: String? = null

  /**
   * 是否成功
   */
  var success = false
}