package com.fan.mvcStudy.controller;

import com.fan.mvcStudy.domain.User;
import com.fan.mvcStudy.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/show")
    public String show() {
        System.out.println("UserController ---> show()");
        //return "/jsp/success.jsp";

        //在spring-mvc.xml里配置了视图资源解析器参数后可以这样写
        return "success";
        //return "redirect:/index.jsp";
    }

    @RequestMapping("/show2")
    public ModelAndView show2() {
        ModelAndView modelAndView = new ModelAndView();
        //设置数据模型
        modelAndView.addObject("username", "Alvin");

        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/show3")
    public ModelAndView show3(ModelAndView modelAndView) {
        modelAndView.addObject("username", "Amy");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/show4")
    public String show4(Model model) {
        model.addAttribute("username", "张安");
        return "success";
    }


    //基本不用
    @RequestMapping("/show5")
    public String show5(HttpServletRequest request) {
        request.setAttribute("username", "HAhA");
        return "success";
    }

    //基本不用
    @RequestMapping("/show6")
    public void show6(HttpServletResponse response) throws IOException {
        response.getWriter().print("I am show6");
    }

    @RequestMapping("/show7")
    @ResponseBody  //告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String show7() {
        return "I am coming";
    }

    @RequestMapping("/show8")
    @ResponseBody
    //在spring-mvc.xml里配置处理器映射器, 让spring帮我们把对象转成json串
    public User show8() {
        User user = new User("Kim", 12);
        return user;
    }

    //Controller中的业务方法的参数名称与请求参数的名称一直时, 参数会自动映射匹配
    //http://localhost:8080/spring_mvc/user/show9?name=alex&age=15
    @RequestMapping("/show9")
    @ResponseBody
    public void show9(String name, int age) {
        System.out.println(name + ":" + age);
    }

    //Controller中的业务方法的POJO参数的属性名与请求参数的name一致, 参数会自动映射匹配
    @RequestMapping("/show10")
    @ResponseBody
    //http://localhost:8080/spring_mvc/user/show10?name=bob&age=12
    public void show10(User user) {
        System.out.println(user);
    }

    //Controller中的业务方法数组名称与请求参数的name一致, 参数会自动映射匹配
    @RequestMapping("/show11")
    @ResponseBody
    //http://localhost:8080/spring_mvc/user/show11?strs=111&strs=222&strs=333
    public void show11(String[] strs) {
        System.out.println(Arrays.asList(strs));
    }


    @RequestMapping("/show12")
    @ResponseBody
    public void show12(VO vo) {
        System.out.println(vo);
    }

    @RequestMapping("/show13")
    @ResponseBody
    public void show13(@RequestBody List<User> userList) {
        System.out.println(userList);
    }


    //参数绑定注解@RequestParam
    //http://localhost:8080/spring_mvc/user/show14?username=alex&age=15
    @RequestMapping("/show14")
    @ResponseBody
    public void show14(@RequestParam("username") String name, int age) {
        System.out.println(name + ":" + age);
    }

    //获得Restful风格的参数
    //http://localhost:8080/spring_mvc/user/show15/alex
    @RequestMapping("/show15/{username}")
    @ResponseBody
    public void show15(@PathVariable("username") String name) {
        System.out.println(name);
    }


    //测试自定义转换器
    //http://localhost:8080/spring_mvc/user/show16?date=2021-6-7
    @RequestMapping("/show16")
    @ResponseBody
    public void show16(Date date) {
        System.out.println(date);
    }


    //http://localhost:8080/spring_mvc/user/show17
    @RequestMapping("/show17")
    @ResponseBody
    public void show17(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    //获取请求头信息
    //http://localhost:8080/spring_mvc/user/show18
    @RequestMapping("/show18")
    @ResponseBody
    public void show18(@RequestHeader(value = "User-Agent", required = false) String user_agent) {
        System.out.println(user_agent);
    }

    //获取cookie
    //http://localhost:8080/spring_mvc/user/show19
    @RequestMapping("/show19")
    @ResponseBody
    public void show19(@CookieValue("JSESSIONID") String jsessionId) {
        System.out.println(jsessionId);
    }

    //http://localhost:8080/spring_mvc/user/show20
    @RequestMapping("/show20")
    @ResponseBody
    public void show20(String username, MultipartFile myFile) throws IOException {  //参数名要和传过来一一对应
        System.out.println(username);
        //获取文件名称
        String filename = myFile.getOriginalFilename();
        myFile.transferTo(new File("D:\\"+filename));
    }
}
