package projects.beauty.shop.web.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.beauty.shop.exception.UserAlreadyExistsException;
import projects.beauty.shop.service.UserService;
import projects.beauty.shop.web.command.RegisterUserCommand;

import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;

    @GetMapping
    public String getRegister(Model model){
        model.addAttribute(new RegisterUserCommand());
        return "register/form";
    }

    @PostMapping
    public String processRegister(@Valid RegisterUserCommand registerUserCommand,
                                  BindingResult bindings){
        log.debug("Dane do utworzenia użytkownika: {}", registerUserCommand);
        if(bindings.hasErrors()){
            log.debug("Błędne dane: {}", bindings.getAllErrors());
            return "register/form";
        }
        try{
            Long id = userService.create(registerUserCommand);
            log.debug("Utworzono użytkownika: {}", id);
            return "redirect:/login";
        }
        catch (UserAlreadyExistsException uaee) {
            bindings.rejectValue("username",null,"Użytkownik o podanym adresie już istnieje");
            return "register/form";
        }
        catch (RuntimeException re){
            bindings.rejectValue(null, null, "Wystąpił błąd");
            return "register/form";
        }
    }

}
