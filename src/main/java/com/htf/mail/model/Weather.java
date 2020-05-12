package com.htf.mail.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Weather implements Serializable{

	private static final long serialVersionUID = -753800314574993475L;
	private Aqi aqi;//AQI
	private Basic basic;//城市信息
	private List<Daily> daily_forecast;//7日天气预报
	private List<Hourly> hourly_forecast;//小时天气预报
	private Hourly now;//实况天气
	private String status;//返回状态
	private Suggestion suggestion;//生活指数
	
	@Override
	public String toString() {
		String str = basic.getCity() +
		" AQI:"+aqi.getCity().getAqi() +
		" ;<br/> 空气质量："+aqi.getCity().getQlty() + 
		" ;<br/> PM2.5指数："+aqi.getCity().getPm25() + 
		" ;<br/> PM10指数："+aqi.getCity().getPm10() + 
		" ;<br/> 纬度："+basic.getLat() + 
		" ;<br/> 经度："+basic.getLon() + 
		" ;<br/> 天气更新时间："+basic.getUpdate().getUtc() + " ;<br/>";
		//实况天气
		str += "当前天气:<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;天气："+now.getCond().getTxt() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;感冒指数："+now.getFl() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;相对湿度："+now.getHum() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;降水量："+now.getPcpn() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;大气压："+now.getPres() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;温度："+now.getTmp() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;能见度："+now.getVis() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;风向："+now.getWind().getDir() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;风力等级："+now.getWind().getSc() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;风速："+now.getWind().getSpd() + "米/秒 ;<br/>";
		
		Daily daily2 = daily_forecast.get(0);
		//今日天气
		str += "今天天气，时间："+daily2.getDate() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;日出时间："+daily2.getAstro().getSr() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;日落时间："+daily2.getAstro().getSs() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;月升时间："+daily2.getAstro().getMr() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;月落时间："+daily2.getAstro().getMs() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;白天天气："+daily2.getCond().getTxt_d() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;夜间天气："+daily2.getCond().getTxt_n() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;相对湿度："+daily2.getHum() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;降水概率："+daily2.getPop() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;降水量："+daily2.getPcpn() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;大气压："+daily2.getPres() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;最高温度："+daily2.getTmp().getMax() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;最低温度："+daily2.getTmp().getMin() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;紫外线指数："+daily2.getUv() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;能见度："+daily2.getVis() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;风向："+daily2.getWind().getDir() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;风力等级："+daily2.getWind().getSc() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;风速："+daily2.getWind().getSpd() + "米/秒 ;<br/>";
		
		//生活指数
		str += "外出指数:<span style='color:red'>"+suggestion.getAir().getBrf() + ","+suggestion.getAir().getTxt()+"</span><br/>";
		str += "舒适度指数:<span style='color:red'>"+suggestion.getComf().getBrf() + ","+suggestion.getComf().getTxt()+"</span><br/>";
		str += "洗车指数:<span style='color:red'>"+suggestion.getCw().getBrf() + ","+suggestion.getCw().getTxt()+"</span><br/>";
		str += "穿衣指数:<span style='color:red'>"+suggestion.getDrsg().getBrf() + ","+suggestion.getDrsg().getTxt()+"</span><br/>";
		str += "感冒指数:<span style='color:red'>"+suggestion.getFlu().getBrf() + ","+suggestion.getFlu().getTxt()+"</span><br/>";
		str += "运动指数:<span style='color:red'>"+suggestion.getSport().getBrf() + ","+suggestion.getSport().getTxt()+"</span><br/>";
		str += "旅游指数:<span style='color:red'>"+suggestion.getTrav().getBrf() + ","+suggestion.getTrav().getTxt()+"</span><br/>";
		str += "紫外线指数:<span style='color:red'>"+suggestion.getUv().getBrf() + ","+suggestion.getUv().getTxt()+"</span><br/><br/><br/>";
		
		/*
		aqi.getCity().getAqi();//AQI
		aqi.getCity().getQlty();//空气质量
		aqi.getCity().getPm25();//PM2.5
		aqi.getCity().getPm10();//PM10
		aqi.getCity().getNo2();//NO2
		aqi.getCity().getSo2();//SO2
		aqi.getCity().getCo();//CO
		aqi.getCity().getO3();//O3
		basic.getCnty();//国家
		basic.getCity();//城市名
		basic.getId();//城市ID
		basic.getLat();//纬度
		basic.getLon();//经度
		basic.getUpdate().getLoc();//当前时间
		basic.getUpdate().getUtc();//天气更新时间
		*/
		//5天天气预报
		str += "未来4天天气预报:<br/>";
		for (Daily daily : daily_forecast) {
			if(daily.getDate().equals(daily2.getDate())) {
				continue;
			}
			str += "&nbsp;&nbsp;&nbsp;&nbsp;时间："+daily.getDate() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日出时间："+daily.getAstro().getSr() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日落时间："+daily.getAstro().getSs() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月升时间："+daily.getAstro().getMr() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月落时间："+daily.getAstro().getMs() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;白天天气："+daily.getCond().getTxt_d() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;夜间天气："+daily.getCond().getTxt_n() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;相对湿度："+daily.getHum() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;降水概率："+daily.getPop() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;降水量："+daily.getPcpn() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;大气压："+daily.getPres() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;最高温度："+daily.getTmp().getMax() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;最低温度："+daily.getTmp().getMin() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;紫外线指数："+daily.getUv() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;能见度："+daily.getVis() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;风向："+daily.getWind().getDir() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;风力等级："+daily.getWind().getSc() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;风速："+daily.getWind().getSpd() + "米/秒 ;<br/>";
			/*
			daily.getAstro().getMr();//月升时间
			daily.getAstro().getMs();//月落时间
			daily.getAstro().getSr();//日出时间
			daily.getAstro().getSs();//日落时间
			daily.getCond().getCode_d();//白天天气状况代码
			daily.getCond().getCode_n();//夜间天气状况代码
			daily.getCond().getTxt_d();//白天天气状况描述
			daily.getCond().getTxt_n();//夜间天气状况描述
			daily.getDate();//日期
			daily.getHum();//相对湿度
			daily.getPcpn();//降水量
			daily.getPop();//降水概率
			daily.getPres();//大气压
			daily.getTmp().getMax();//最高温度
			daily.getTmp().getMin();//最低温度
			daily.getUv();//紫外线指数
			daily.getVis();//能见度
			daily.getWind().getDeg();// 风向（360度）
			daily.getWind().getDir();//风向
			daily.getWind().getSc(); //风力等级
			daily.getWind().getSpd();//风速
			*/
		}
		//24小时天气预报
		str += "未来24小时天气预报:<br/>";
		for (Hourly hourly : hourly_forecast) {
			str += "&nbsp;&nbsp;&nbsp;&nbsp;时间："+hourly.getDate() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;天气："+hourly.getCond().getTxt() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;相对湿度："+hourly.getHum() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;降水概率："+hourly.getPop() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;大气压："+hourly.getPres() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;温度："+hourly.getTmp() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;风向："+hourly.getWind().getDir() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;风力等级："+hourly.getWind().getSc() + " ;<br/>";
			str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;风速："+hourly.getWind().getSpd() + "米/秒 ;<br/>";
			/*
			hourly.getCond().getCode();//天气状况代码
			hourly.getCond().getTxt();//天气状况描述
			hourly.getDate();//时间
			hourly.getHum();//相对湿度
			hourly.getPop();//降水概率
			hourly.getPres();//大气压
			hourly.getTmp();//温度
			hourly.getWind().getDeg();    // 风向（360度）
			hourly.getWind().getDir();    //风向       
			hourly.getWind().getSc();     //风力等级     
			hourly.getWind().getSpd();    //风速    
			*/   
			
		}
		//实况天气
		/*
		str += "当前天气:<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;天气："+now.getCond().getTxt() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;感冒指数："+now.getFl() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;相对湿度："+now.getHum() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;降水量："+now.getPcpn() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;大气压："+now.getPres() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;温度："+now.getTmp() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;能见度："+now.getVis() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;风向："+now.getWind().getDir() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;风力等级："+now.getWind().getSc() + " ;<br/>";
		str += "&nbsp;&nbsp;&nbsp;&nbsp;风速："+now.getWind().getSpd() + "米/秒 ;<br/>";
		
		
		now.getCond().getCode();//天气状况代码
		now.getCond().getTxt();//天气状况描述
		now.getFl();//感冒指数
		now.getHum();//相对湿度
		now.getPcpn();//降水量
		now.getPres();//大气压
		now.getTmp();//温度
		now.getVis();//能见度
		now.getWind().getDeg();    // 风向（360度）     
		now.getWind().getDir();    //风向            
		now.getWind().getSc();     //风力等级          
		now.getWind().getSpd();    //风速            
		
		//status;
		str += "外出指数:<span style='color:red'>"+suggestion.getAir().getBrf() + ","+suggestion.getAir().getTxt()+"</span><br/>";
		str += "舒适度指数:<span style='color:red'>"+suggestion.getComf().getBrf() + ","+suggestion.getComf().getTxt()+"</span><br/>";
		str += "洗车指数:<span style='color:red'>"+suggestion.getCw().getBrf() + ","+suggestion.getCw().getTxt()+"</span><br/>";
		str += "穿衣指数:<span style='color:red'>"+suggestion.getDrsg().getBrf() + ","+suggestion.getDrsg().getTxt()+"</span><br/>";
		str += "感冒指数:<span style='color:red'>"+suggestion.getFlu().getBrf() + ","+suggestion.getFlu().getTxt()+"</span><br/>";
		str += "运动指数:<span style='color:red'>"+suggestion.getSport().getBrf() + ","+suggestion.getSport().getTxt()+"</span><br/>";
		str += "旅游指数:<span style='color:red'>"+suggestion.getTrav().getBrf() + ","+suggestion.getTrav().getTxt()+"</span><br/>";
		str += "紫外线指数:<span style='color:red'>"+suggestion.getUv().getBrf() + ","+suggestion.getUv().getTxt()+"</span><br/>";
		
		suggestion.getAir().getBrf();  	//外出指数  
		suggestion.getAir().getTxt();            
		suggestion.getComf().getBrf();  //舒适度指数          
		suggestion.getComf().getTxt();             
		suggestion.getCw().getBrf();    //洗车指数          
		suggestion.getCw().getTxt();             
		suggestion.getDrsg().getBrf();  //穿衣指数         
		suggestion.getDrsg().getTxt();           
		suggestion.getFlu().getBrf();	//感冒指数  
		suggestion.getFlu().getTxt();
		suggestion.getSport().getBrf();	//运动指数  
		suggestion.getSport().getTxt();
		suggestion.getTrav().getBrf();	//旅游指数  
		suggestion.getTrav().getTxt();
		suggestion.getUv().getBrf();	//紫外线指数 
		suggestion.getUv().getTxt();
		*/
		return str;
	}
	
	
}

