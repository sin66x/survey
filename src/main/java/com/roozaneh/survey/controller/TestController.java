package com.roozaneh.survey.controller;

import com.roozaneh.survey.domain.User;
import com.roozaneh.survey.model.TestModel;
import com.roozaneh.survey.repository.UserRepository;
import com.roozaneh.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String loadPage(Model model) {
        List<TestModel> testModelList = new ArrayList<TestModel>();
        TestModel a = new TestModel();
        a.setMyName("A");
        testModelList.add(a);
        a = new TestModel();
        a.setMyName("B");
        testModelList.add(a);
        model.addAttribute("name","Behnam");
        model.addAttribute("testMod",new TestModel());
        model.addAttribute("testModels",testModelList);
        System.out.println("ABC");
        User u = new User("behnam","123","ROLE_USER","true");
        userService.save(u);
        return "tt";
    }


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String postTest(@ModelAttribute(name = "testMod") TestModel testMod) {
//        model.addAttribute("name","Behnam");
        System.out.println(testMod.getMyName());

        return "tt";
    }

}
