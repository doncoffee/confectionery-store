package by.academy.controller.impl.delete;

import by.academy.controller.Command;
import by.academy.controller.extractor.Extractor;
import by.academy.controller.extractor.impl.PhoneNumberExtractor;
import by.academy.service.PhoneNumberService;
import by.academy.service.dto.PhoneNumberDTO;
import by.academy.service.impl.PhoneNumberServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class DeletePhoneNumberCommand implements Command {
    private final PhoneNumberService service = new PhoneNumberServiceImpl();
    private final Extractor<PhoneNumberDTO> extractor = new PhoneNumberExtractor();
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deletePhoneNumber(id);
        extractor.extract(request);
        return "/jsp/lists/phoneNumbers.jsp";
    }
}
