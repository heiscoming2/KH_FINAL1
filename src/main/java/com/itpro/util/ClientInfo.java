package com.itpro.util;

import javax.servlet.http.HttpServletRequest;

public class ClientInfo {
	
	public String getClientIp(HttpServletRequest request) {
		
		//X-FORWARDED-FOR
		//XFF는 HTTP Header 중 하나로 HTTP Server에 요청한 Client의 IP를 식별하기 위한 표준이다. 
		//(XFF 헤더는 HTTP 프록시나 로드 밸런서를 통해 웹 서버에 접속하는 클라이언트의 원 IP 주소를 식별하는 사실상의 표준 헤더이다.)
		//웹 서버나 WAS 앞에 L4 같은 Load balancers 나 Proxy server, caching server 등의 장비가 있을 경우 
		//웹서버는 Proxy server 나 장비IP에서 접속한 것으로 인식한다. 그렇기 때문에 웹서버는 실제 클라이언트 IP가 아닌 앞단에 있는 Proxy서버 IP를 요청한 IP로 인식하고, 
		//Proxy장비 IP 로 웹로그를 남기게 된다.
		//즉, 클라이언트 IP ⟶ Proxy 서버 및 장비 ⟶ 웹 서버
		//이 때 웹프로그램에서는 XFF HTTP 해더에 있는 클라이언트 IP를 찾아 실제 요청한 클라이언트 IP를 알 수 있고, 웹로그에도 실제 요청한 클라이언트 IP를 남길 수 있다. 
		//그러므로 XFF 해더를 사용할 때에는 사용자의 프라이버시를 주의해야한다.
		String ip = request.getHeader("X-FORWARDED-FOR");
		
		if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip) ) {
			ip=request.getHeader("Proxy-Client-IP");
		} //equalsIgnoreCase() : 대소문자 관계없이 equals 검사
		
		//웹로직 서버일 경우
		if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)) {
			ip=request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)) {
			ip=request.getHeader("HTTP_CLIENT_IP");
		}
		if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)) {
			ip=request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)) {
			ip=request.getRemoteAddr();
		}
		return ip;
	}

}
