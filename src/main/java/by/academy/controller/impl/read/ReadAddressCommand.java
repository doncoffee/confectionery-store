package by.academy.controller.impl.read;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.AddressExtractor;
import by.academy.service.dto.AddressDTO;

import javax.servlet.http.HttpServletRequest;

public class ReadAddressCommand implements Command {
    private final Extractor<AddressDTO> extractor = new AddressExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        extractor.extract(request);
        return "/jsp/lists/addresses.jsp";
    }
}
