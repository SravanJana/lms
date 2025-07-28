package Com.Sravan.Controller;

import Com.Sravan.DTO.RegistrationDTO;
import Com.Sravan.Service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    public RegistrationService registrationService;



    @GetMapping(value = "register")
    public String register(@ModelAttribute("regDTO") RegistrationDTO regDTO) {
        return "registerPage";
    }

    @PostMapping(value = "/processRegistration")
    public String processRegistrationPage(@Valid @ModelAttribute("regDTO") RegistrationDTO regDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("regDTO", regDTO);
            return "registerPage";
        }
        registrationService.saveMainUser(regDTO);
        registrationService.saveUserDetails(regDTO);


        return "redirect:/customLogin";
    }
}
