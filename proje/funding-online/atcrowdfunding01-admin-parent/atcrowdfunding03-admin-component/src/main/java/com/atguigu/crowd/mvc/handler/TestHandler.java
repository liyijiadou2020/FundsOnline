// package com.atguigu.crowd.mvc.handler;
// import java.util.List;
// import javax.servlet.http.HttpServletRequest;
//
// import com.atguigu.crowd.util.CrowdUtil;
// import com.atguigu.crowd.util.ResultEntity;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.ModelMap;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// import com.atguigu.crowd.entity.Admin;
// import com.atguigu.crowd.service.api.AdminService;
//
//
// @Controller
// public class TestHandler {
//
//     @Autowired
//     private AdminService adminService;
//
//     private Logger logger = LoggerFactory.getLogger(TestHandler.class);
//
//
//     /**
//      * 使用 JSON 接受/发送数据
//      * @param array
//      * @return
//      */
//     @ResponseBody
//     @RequestMapping("/send/array/three.html")
//     public String testReceiveArrayThree(@RequestBody List<Integer> array) {
//         for (Integer number : array) {
//             logger.info("number="+number);
//         }
//         return "success";
//     }
//
//
//     /**
//      * 测试 Ajax 接收数组
//      * 【 缺陷：Handler方法中接收数据时需要在请求参数名字后面加一组[] - 服务器抽风】
//      * @param array
//      * @return
//      */
//     @ResponseBody
//     @RequestMapping("/send/array/one.html")
//     public String testReceiveArrayOne(@RequestParam("array[]") List<Integer> array) {
//         for (Integer number : array) {
//             System.out.println("number="+number);
//         }
//         return "success";
//     }
//
//     @RequestMapping("/test/ssm.html")
//     public String testSsm(ModelMap modelMap, HttpServletRequest request) {
//         boolean judgeResult = CrowdUtil.judgeRequestType(request);
//         logger.info("judgeResult="+judgeResult);
//         List<Admin> adminList = adminService.getAll();
//         modelMap.addAttribute("adminList", adminList);
//         System.out.println("[DEBUG]" + adminList);
//         return "target";
//     }
//
// }
