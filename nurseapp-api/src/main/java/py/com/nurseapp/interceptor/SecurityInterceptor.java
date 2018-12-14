package py.com.nurseapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import py.com.nurseapp.constants.NurseAppConstans;
import py.com.nurseapp.exception.SecurityNurseAppException;

@Component
public class SecurityInterceptor  extends HandlerInterceptorAdapter{

	private static Logger logger = LogManager.getLogger(SecurityInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("Running security interceptor");
		String apiKey = request.getHeader(NurseAppConstans.HEADER_API_KEY);
		if(apiKey==null){
			logger.info("Missing Api Key");
			throw new SecurityNurseAppException("s1000","Missing Api Key");
		}
		return true;
	}
	
}
