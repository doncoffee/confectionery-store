package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.AddressExtractor;
import by.academy.service.AddressService;
import by.academy.service.dto.AddressDTO;
import by.academy.service.impl.AddressServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class GoToEditAddressCommand implements Command {
    private final AddressService service = new AddressServiceImpl();
    private final Extractor<AddressDTO> extractor = new AddressExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        int id = Integer.parseInt(request.getParameter("id"));
        AddressDTO addressDTO = service.selectAddressById(id);
        request.setAttribute("address", addressDTO);
        return "/jsp/edit/editAddress.jsp";
    }
}
