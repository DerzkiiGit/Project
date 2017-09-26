package net.myProject.controller;


import net.myProject.model.User;
import net.myProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyController {

    private UserService userService;

    @Autowired
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = {"/users", "/usersPage"},  method = RequestMethod.GET)
    public String getUsers(@RequestParam(value = "userName", defaultValue = "")String userName,@RequestParam(value = "page", defaultValue = "0")int page, Model model){



            model.addAttribute("user", new User());

        List<User>usersList;

        if (!userName.equals("")){
            usersList=userService.getUserByName(userName);
        }else{
            usersList=userService.getAllUsers();
        }


            PagedListHolder<User> holder = new PagedListHolder<User>(usersList);

            holder.setPageSize(5);
            if(holder.getPageCount()<=page){
                holder.setPage(holder.getPageCount()-1);
            }else{
                holder.setPage(page);
            }

            model.addAttribute("usersList",holder.getPageList());
            model.addAttribute("userName", userName);
            model.addAttribute("pageCount", holder.getPageCount());
            model.addAttribute("currentPage",page);
        return "usersPage";

    }
    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute(value = "user")User user){

        if (user.getId()==0){
            userService.createUser(user);
        }else{
            userService.updateUser(user);
        }

        return "redirect:/usersPage";
    }
    @RequestMapping(value = "/users/getForm")
    public String getFormToAddUser(Model model){

        model.addAttribute("user", new User());
        return "userView";
    }

    @RequestMapping(value = "users/delete/{id}")
    public String deleteUser(@PathVariable(value = "id")int id,@RequestParam(value = "page")int page, RedirectAttributes ra){

        userService.removeUser(id);
        ra.addAttribute("page",page);
        return "redirect:/usersPage";
    }

    @RequestMapping(value = "users/delete/{id}/{name}")
    public String deleteUserWithName(@PathVariable(value = "id")int id,@PathVariable(value = "name")String name,@RequestParam(value = "page")int page ,RedirectAttributes ra){

        userService.removeUser(id);

        if(name!=null){
            ra.addAttribute("userName",name);
        }
        ra.addAttribute("page",page);
        return "redirect:/usersPage";
    }

    @RequestMapping(value = "users/find")
    public String findUsers(@RequestParam(value = "userName")String name, Model model, RedirectAttributes ra){

        ra.addAttribute("userName", name);

        return "redirect:/usersPage";

    }

    @RequestMapping(value = "users/edit/{id}")
    public String editUser(@PathVariable(value = "id") int id, Model model){

        model.addAttribute("user", userService.getById(id));


        return "userView";
    }









}
