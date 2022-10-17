package top.kingdon.reggie.intercaptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.kingdon.reggie.utils.BaseContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Slf4j
public class AdminLoginInterceptor implements HandlerInterceptor {

    @Override       //处理请求前执行的方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Long empId = (Long) request.getSession().getAttribute("employee");
        if(request.getSession().getAttribute("user")!=null)return true;
        if(empId==null){

            request.setAttribute("msg","用户未登录");
            response.sendRedirect("/backend/page/login/login.html");
            return false;
        }
        BaseContext.setCurrentId(empId);

        return true;
    }

    @Override   //处理请求后执行的方法
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("用户"+BaseContext.getCurrentId()+"在"+LocalDateTime.now()+"尝试以管理员身份登录");
    }
}
