package com.itpro.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class JavaScriptResponse {
	
	public void jsResponse(HttpServletResponse response,String msg,String url) throws IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script type='text/javascript'>");
		out.print("alert('"+msg+"');");
		out.print("location.href='"+url+"';");
		out.print("</script>");
		
	}
	
	
}
