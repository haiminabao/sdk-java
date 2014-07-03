package com.baocheng.net;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;

import com.baocheng.callback.BCApiCallBack;
import com.baocheng.callback.BCIBuyCallBack;

public class BCApi {
	private static String header = "http://api.test.baoxiandr.com";

	/**
	 * 大都会人寿
	 * 
	 * @param callBack
	 */
	public static void daDuHui(final BCIBuyCallBack callBack) {
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					Date date = new Date();
					date.setTime(System.currentTimeMillis() + (24 * 60 * 60 * 1000));
					String string = new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA).format(date);
					callBack.buyDaDuHuiCallBack("恭喜您获赠保额55万大都会航空意外险!\n保单号:FP0023545920\n生效日期：" + string);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	/**
	 * <strong><center>2014-07-02 11:42</center> <center><font
	 * size=4>------------
	 * --------------获取保险详细信息--------------------------</font></center>
	 * 返回结果(json): <br>
	 * { "result_code": "10000", "reason": "请求成功", "result": { "plan_name":
	 * "交通综合意外保障计划", "ages": "18-60周岁", "duration": "90天", "plan_range": "
	 * <table>
	 * <tbody>
	 * <tr>
	 * <td>水陆公交意外身故</td>
	 * <td>10万</td>
	 * </tr>
	 * <tr>
	 * <td>水陆公交意外残疾</td>
	 * <td>1万</td>
	 * </tr>
	 * <tr>
	 * <td>航空意外身故</td>
	 * <td>10万</td>
	 * </tr>
	 * <tr>
	 * <td>航空意外残疾</td>
	 * <td>1万</td>
	 * </tr>
	 * <tr>
	 * <td>自驾（驾驶+乘坐）意外身故</td>
	 * <td>10万</td>
	 * </tr>
	 * <tr>
	 * <td>自驾（驾驶+乘坐）意外残疾</td>
	 * <td>1万</td>
	 * </tr>
	 * <tr>
	 * <td>意外住院医疗保险金</td>
	 * <td>1000元</td>
	 * </tr>
	 * </tbody>
	 * </table>
	 * ", "note": "
	 * <ul>
	 * <li>仅能为自己投保</li>
	 * <li>有效地区：北京市、上海市、深圳市、重庆市、辽宁省、江苏省、浙江省、福建省、四川省、湖北省</li>
	 * </ul>
	 * ", "files": [ { "file": "TPA210水陆公共交通意外", "url":
	 * "http://bc-metlife.qiniudn.com/TPA210.pdf" }, { "file": "APA202航空意外伤害",
	 * "url": "http://bc-metlife.qiniudn.com/APA202.pdf" }, { "file":
	 * "SPA209自驾车意外伤害", "url": "http://bc-metlife.qiniudn.com/SPA209.pdf" }, {
	 * "file": "AHR201意外伤害住院医疗", "url":
	 * "http://bc-metlife.qiniudn.com/AHR201.pdf" } ], "responsibility": "
	 * <p>
	 * 一、水陆空公共交通意外身故保险金
	 * </p>
	 * 
	 * <p>
	 * 若被保险人作为乘客持有效客票乘坐从事合法客运的火车、高铁，地铁、轻轨、汽车、出租车、轮船、飞机等公共交通工具时发生意外伤害事故，
	 * 且自该意外伤害事故发生之日起一百八十日内因该意外伤害事故单独且直接导致身故的
	 * ，我们将按10万保险金额扣除累计已给付的水陆空公共交通意外伤残保险金后的金额给付水陆空公共交通意外身故保险金。
	 * </p>
	 * 
	 * <p>
	 * 二、水陆空公共交通意外伤残保险金
	 * </p>
	 * 
	 * <p>
	 * 若被保险人作为乘客持有效客票乘坐从事合法客运的火车、高铁，地铁、轻轨、汽车、出租车、轮船、飞机等公共交通工具时发生意外伤害事故，
	 * 且自该意外伤害事故发生之日起一百八十日内因该意外伤害事故单独且直接导致身体伤残的
	 * ，且该伤残属于中国保险行业协会、中国法医学会联合发布的《人身保险伤残评定标准
	 * （行业标准）》（中保协发[2013]88号，见附表）中所列的伤残项目的，
	 * 我们将根据该伤残项目所对应的给付比例乘以1万的保险金额给付水陆空公共交通意外伤残保险金。
	 * </p>
	 * 
	 * <p>
	 * 我们向同一被保险人给付的水陆空公共交通意外伤残保险金的累计金额最高为1万。
	 * </p>
	 * 
	 * <p>
	 * 三、自驾车意外身故保险金
	 * </p>
	 * 
	 * <p>
	 * 若被保险人自进入自驾车车厢至抵达目的地走出车厢时止，在驾驶或乘坐的状态中发生意外伤害事故，
	 * 且自该意外伤害事故发生之日起一百八十日内因该意外伤害事故单独且直接导致身故的
	 * ，我们将按10万的保险金额扣除累计已给付的自驾车意外伤残保险金后的金额给付自驾车意外身故保险金。
	 * </p>
	 * 
	 * <p>
	 * 四、自驾车意外伤残保险金
	 * </p>
	 * 
	 * <p>
	 * 若被保险人自进入自驾车车厢至抵达目的地走出车厢时止，在驾驶或乘坐的状态中发生意外伤害事故，
	 * 且自该意外伤害事故发生之日起一百八十日内因该意外伤害事故单独且直接导致身体伤残的
	 * ，且该伤残属于中国保险行业协会、中国法医学会联合发布的《人身保险伤残评定标准
	 * （行业标准）》（中保协发[2013]88号，见附表）中所列的伤残项目的，
	 * 我们将根据该伤残项目所对应的给付比例乘以1万的保险金额给付自驾车意外伤残保险金。
	 * </p>
	 * 
	 * <p>
	 * 我们向同一被保险人给付的自驾车意外伤残保险金的累计金额最高为1万。
	 * </p>
	 * 
	 * <p>
	 * 五、意外伤害住院医疗保险金
	 * </p>
	 * 
	 * <p>
	 * 若被保险人发生意外伤害事故，且自该意外伤害事故发生之日起一百八十日内因该意外伤害事故单独且直接导致伤害，
	 * 并经国家卫生行政部门认定的医疗机构的医生诊断必须住院治疗的，则我们将按如下规则给付意外伤害住院医疗保险金：
	 * </p>
	 * 
	 * <p>
	 * 1）若被保险人已从公费医疗、社会医疗保险取得医疗费用补偿，我们将按如下公式给付意外伤害住院医疗保险金：
	 * </p>
	 * 
	 * <p>
	 * 意外伤害住院医疗保险金 = 该意外伤害事故发生之日起一百八十日内已支出的、必要且合理的住院医疗费用- 任何已获得的住院医疗费用补偿
	 * </p>
	 * 
	 * <p>
	 * 2）若被保险人未从公费医疗、社会医疗保险取得医疗费用补偿，我们将按如下公式给付意外伤害住院医疗保险金：
	 * </p>
	 * 
	 * <p>
	 * 意外伤害住院医疗保险金 = （该意外伤害事故发生之日起一百八十日内已支出的、必要且合理的住院医疗费用- 任何已获得的住院医疗费用补偿）×90%
	 * </p>
	 * 
	 * <p>
	 * 3）我们对被保险人所承担的给付意外伤害住院医疗保险金的责任以1000元的保险金额为限。
	 * </p>
	 * 
	 * <p>
	 * 以上概述仅供参考，详细内容请参照保险合同，并以保险合同规定为准。
	 * </p>
	 * ", "responsibility_exclude": "
	 * <p>
	 * 因下列情形之一导致被保险人身故、伤残的，我们不承担给付本合同约定的各项保险金的责任：
	 * </p>
	 * 
	 * <p>
	 * 一、投保人对被保险人的故意杀害、故意伤害；
	 * </p>
	 * 
	 * <p>
	 * 二、被保险人故意犯罪或者抗拒依法采取的刑事强制措施；
	 * </p>
	 * 
	 * <p>
	 * 三、被保险人自本合同成立之日起自杀，但被保险人自杀时为无民事行为能力人的除外；
	 * </p>
	 * 
	 * <p>
	 * 四、被保险人故意自伤；
	 * </p>
	 * 
	 * <p>
	 * 五、被保险人主动吸食或注射毒品；
	 * </p>
	 * 
	 * <p>
	 * 六、被保险人酒后驾驶，无合法有效驾驶证驾驶，或驾驶无有效行驶证的机动车；
	 * </p>
	 * 
	 * <p>
	 * 七、战争、军事冲突、暴乱或武装叛乱；
	 * </p>
	 * 
	 * <p>
	 * 八、核爆炸、核辐射或核污染；
	 * </p>
	 * 
	 * <p>
	 * 九、被保险人从事潜水、滑水、跳伞、攀岩、蹦极跳、赛马、赛车、摔跤、探险活动及特技表演等高风险运动；被保险人猝死；
	 * 被保险人非乘客或被保险人乘坐非正在营运的公共交通工具；
	 * </p>
	 * 
	 * <p>
	 * 十、被保险人猝死；被保险人因细菌性食物中毒、矫形整容手术（但因意外伤害事故所致者，不在此列）、医疗事故、药物不良反应导致的伤害；
	 * </p>
	 * 
	 * <p>
	 * 十一、不孕症、人工受孕或非以治疗为目的之避孕及计划生育手术；怀孕（含宫外孕）、流产和分娩以及由其引起的并发症；
	 * </p>
	 * 
	 * <p>
	 * 十二、健康检查、疗养、静养或康复治疗；
	 * </p>
	 * 
	 * <p>
	 * 十三、因疾病或接受治疗引起的并发症、药物不良反应；
	 * </p>
	 * 
	 * <p>
	 * 十四、因精神疾病或受酒精、毒品、管制药物的影响而导致的情况；
	 * </p>
	 * 
	 * <p>
	 * 十五、职业病、美容手术或任何先天性疾病、先天性畸形或缺陷导致的住院和手术；
	 * </p>
	 * 
	 * <p>
	 * 十六、被保险人患腰椎间盘突出、肩周炎、颈椎病、腰肌劳损；
	 * </p>
	 * 
	 * <p>
	 * 十七、被保险人感染艾滋病病毒或患艾滋病；
	 * </p>
	 * 
	 * <p>
	 * 十八、被保险人未在国家卫生行政部门认定的医疗机构就医。
	 * </p>
	 * 
	 * <p>
	 * 十九、法院宣告被保险人死亡，但无法证明被保险人的失踪为意外伤害事故直接导致。
	 * </p>
	 * 
	 * <p>
	 * 发生上述情形导致被保险人身故的，本合同终止。
	 * </p>
	 * 
	 * <p>
	 * 发生上述情形导致被保险人伤残的，本合同继续有效。
	 * </p>
	 * ", "implementation": "
	 * <p>
	 * 保险事故发生后，投保人、被保险人或受益人应及时通过大都会人寿客服热线通知保险公司；
	 * </p>
	 * 
	 * <p>
	 * 客服热线：400-818-8168
	 * </p>
	 * 
	 * <p>
	 * 工作时间：周一至周五9点至20点，周六9点至18点
	 * </p>
	 * 
	 * <p>
	 * 报案内容：出险人的姓名、身份证号码、保险单号码、联系方式，事故经过（包括事故发生时间、地点、经过、原因，经治医院、治疗情况、目前状况等）；
	 * </p>
	 * 
	 * <p>
	 * 公司理赔人员在接到理赔报案时，将了解保险事故详情，解答咨询并指导您理赔申请。
	 * </p>
	 * " } }
	 * 
	 * @param code
	 *            险种代码
	 * @param callBack
	 *            结果回调
	 */
	public static void getInsuranceDetail(String code, BCApiCallBack callBack) {
		AddParams addParams = new AddParams();
		addParams.add("code", code);
		BCNet.getInstance().get(header + "/api/insurance/detail", addParams, 1000 * 10, callBack);
	}

	/**
	 * <strong><center>2014-07-02 11:35</center> <center><font
	 * size=4>------------
	 * --------------获取保险简要信息--------------------------</font></center>
	 * 返回结果(json): <br>
	 * { "result_code": "10000", "reason": "请求成功", "result": { "plan_name":
	 * "交通综合意外保障计划", "url":
	 * "http://metlife.test.baoxiandr.com/insurance/B604FA6F/info" } }
	 * 
	 * @param code
	 *            险种代码
	 * @param callBack
	 *            结果回调
	 */
	public static void getInsuranceInfo(String code, BCApiCallBack callBack) {
		AddParams addParams = new AddParams();
		addParams.add("code", code);
		BCNet.getInstance().get(header + "/api/insurance/info", addParams, 1000 * 10, callBack);
	}

	/**
	 * <strong><center>2014-07-02 15:26</center> <center><font
	 * size=4>------------
	 * --------------获取支持城市--------------------------</font></center>
	 * 返回结果(json): <br>
	 * { "result_code": "10000", "reason": "请求成功", "result": [ { "province":
	 * "北京市", "cities": [ "北京市" ] }, { "province": "福建省", "cities": [ "福州市",
	 * "厦门市", "莆田市", "三明市", "泉州市", "漳州市", "南平市", "龙岩市", "宁德市" ] }, { "province":
	 * "广东省", "cities": [ "深圳市" ] }, { "province": "湖北省", "cities": [ "武汉市",
	 * "黄石市", "十堰市", "宜昌市", "襄樊市", "鄂州市", "荆门市", "孝感市", "荆州市", "黄冈市", "咸宁市",
	 * "随州市", "恩施土家族苗族自治州", "仙桃市", "天门市", "潜江市", "神农架林区" ] }, { "province":
	 * "江苏省", "cities": [ "南京市", "无锡市", "徐州市", "常州市", "苏州市", "南通市", "连云港市",
	 * "淮安市", "盐城市", "扬州市", "镇江市", "泰州市", "宿迁市" ] }, { "province": "辽宁省",
	 * "cities": [ "大连市", "鞍山市", "抚顺市", "本溪市", "丹东市", "锦州市", "营口市", "阜新市",
	 * "辽阳市", "盘锦市", "铁岭市", "朝阳市", "葫芦岛市", "沈阳市", "北票市", "凌源市" ] }, {
	 * "province": "上海市", "cities": [ "上海市" ] }, { "province": "四川省", "cities":
	 * [ "成都市", "自贡市", "攀枝花市", "泸州市", "德阳市", "绵阳市", "广元市", "遂宁市", "内江市", "乐山市",
	 * "南充市", "眉山市", "宜宾市", "广安市", "达州市", "雅安市", "巴中市", "资阳市", "阿坝藏族羌族自治州",
	 * "甘孜藏族自治州", "凉山彝族自治州" ] }, { "province": "浙江省", "cities": [ "杭州市", "宁波市",
	 * "温州市", "嘉兴市", "湖州市", "绍兴市", "金华市", "衢州市", "舟山市", "台州市", "丽水市" ] }, {
	 * "province": "重庆市", "cities": [ "重庆市" ] } ] }
	 * 
	 * @param code
	 *            险种代码
	 * @param callBack
	 *            结果回调
	 */
	public static void getRegion(String code, BCApiCallBack callBack) {
		AddParams addParams = new AddParams();
		addParams.add("code", code);
		BCNet.getInstance().get(header + "/api/region", addParams, 1000 * 10, callBack);
	}

	/**
	 * <strong><center>2014-07-02 14:39</center> <center><font
	 * size=4>------------
	 * --------------保险购买--------------------------</font></center> 返回结果(json): <br>
	 * { "result_code": "10000", "reason": "购买成功", "result": null }
	 * 
	 * @param customer_name
	 *            客户名称
	 * @param customer_id
	 *            客户身份证
	 * @param customer_mobile
	 *            客户手机
	 * @param customer_contact_state
	 *            联系省份
	 * @param customer_contact_city
	 *            联系城市
	 * @param customer_verify
	 *            手机验证码
	 * @param code
	 *            保险代码
	 * @param dealer_id
	 *            代理人ID
	 * @param callBack
	 *            结果回调
	 */
	public static void buyInsurance(String customer_name, String customer_id, String customer_mobile,
			String customer_contact_state, String customer_contact_city, String customer_verify, String code,
			String dealer_id, BCApiCallBack callBack) {
		AddParams addParams = new AddParams();
		JSONObject js = new JSONObject();
		try {
			JSONObject js1 = new JSONObject();
			js1.put("name", customer_name);
			js1.put("id", customer_id);
			js1.put("mobile", customer_mobile);
			js1.put("contact_state", customer_contact_state);
			js1.put("contact_city", customer_contact_city);
			js1.put("verify", customer_verify);
			JSONObject js2 = new JSONObject();
			js2.put("code", code);
			JSONObject js3 = new JSONObject();
			js3.put("id", dealer_id);
			js.put("customer", js1);
			js.put("insurance", js2);
			js.put("dealer", js3);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		BCNet.getInstance().post(header + "/api/insurance/buy", addParams, 1000 * 10, callBack,"application/json",js.toString());
	}

	/**
	 * <strong><center>2014-07-02 15:19</center> <center><font
	 * size=4>------------
	 * --------------发送手机验证码--------------------------</font></center>
	 * 返回结果(json): <br>
	 * { "result_code": "10000", "reason": "请求成功", "result": null }
	 * 
	 * @param mobile
	 *            手机号
	 * @param callBack
	 *            结果回调
	 */
	public static void sendVerifyCode(String mobile, BCApiCallBack callBack) {
		AddParams addParams = new AddParams();
		addParams.add("mobile", mobile);
		BCNet.getInstance().post(header + "/api/verify-code", addParams, 1000 * 10, callBack);
	}

}
