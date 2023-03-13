package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;

import javax.servlet.http.HttpServletRequest;

public class GoToAddPhoneNumberCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/jsp/add/addPhoneNumber.jsp";
    }
}
