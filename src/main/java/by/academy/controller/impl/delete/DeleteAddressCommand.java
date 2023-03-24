package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.AddressExtractor;
import by.academy.service.AddressService;
import by.academy.service.dto.AddressDTO;
import by.academy.service.impl.AddressServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class DeleteAddressCommand implements Command {
    private final AddressService service = new AddressServiceImpl();
    private final Extractor<AddressDTO> extractor = new AddressExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteAddress(id);
        extractor.extract(request);
        return "/jsp/lists/addresses.jsp";
    }
}
