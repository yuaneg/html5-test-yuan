package com.html5.yuan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Html5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int a = 0;
    public Html5Servlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer =response.getWriter();
		a++;
		String data1 = "data: "+ "第"+a +"次请求";
		
		for(int i=0;i<10;i++){
			String data2 = "第"+i+"次循环\n\n";
			//刷新response 内容
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				writer.close();
				response.flushBuffer();
				e.printStackTrace();
			}
			writer.write(data1 + data2);
			response.flushBuffer();
		}
		writer.flush();
		writer.close();
	}
}
