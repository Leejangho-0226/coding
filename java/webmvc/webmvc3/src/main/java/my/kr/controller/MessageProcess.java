package my.kr.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MessageProcess implements CommandInter{
@Override
public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String message = "1강 만세";
     
     request.setAttribute("data", message);
     return "view1.jsp";
}
   
   
}