package com.xiaoji.duan.abl.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiaoji.duan.abl.util.MessageResult;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PMInterceptor implements HandlerInterceptor {
    final Log logger = LogFactory.getLog(this.getClass());
    @Override
    public synchronized boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("PMInterceptor ********* 启动拦截器");
        String servletPath = request.getServletPath();
        logger.info("servletPath ********* : " + servletPath);
//        if ("/mici/login".equals(servletPath)) {
//            //登录时不拦截
//            logger.info("登入操作中");
//            return true;
//        } else {
//            logger.info("执行token验证：");
//            String token = "";
//            token = request.getHeader("Token");
//            String userId = request.getHeader("TokenUserid");
//            int tokenState = Jwt.validIsToken(token);
//            switch (tokenState) {
//                case 1:
//                    //如果校验通过重置token时间
//                    String new_token = ConstantWebUtils.getToken(userId);
//                    response.setHeader("new_token",new_token);
//                    response.setHeader("Access-Control-Expose-Headers", "new_token");
//                    response.setHeader("Access-Control-Allow-Origin", "*");
//                    logger.info("token验证成功*************");
//                    return true;
//                default:
//                    response.setStatus(999);
//                    response.setHeader("Access-Control-Allow-Origin", "*");
//                    logger.info("成功拦截************* servletPath：" + servletPath + " token:"+token);
//                    MessageResult<Object> result =new MessageResult<>();
//                    result.setCode(ResultCode.UNAUTHORIZED).setMsg("签名认证失败");
//                    responseResult(response, result);
//                    return false;
//            }

//        }
        return true;
    }

}
