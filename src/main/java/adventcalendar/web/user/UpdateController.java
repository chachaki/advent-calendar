package adventcalendar.web.user;

import adventcalendar.model.user.User;
import adventcalendar.model.user.UserId;
import adventcalendar.model.user.validation.OnUpdate;
import adventcalendar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("user/update")
@SessionAttributes("user")
class UpdateController {

    @Autowired
    UserService userService;

    @ModelAttribute
    User user(@RequestParam(required = false, value = "userId") UserId userId) {
        if (userId == null) return new User();
        return userService.findById(userId).orElseThrow(RuntimeException::new);
    }

    @RequestMapping(method = RequestMethod.GET)
    String start() {
        return "user/update/register";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    String confirm(@Validated(OnUpdate.class) @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) return "user/update/register";
        return "user/update/confirm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    String register(@Validated(OnUpdate.class) @ModelAttribute User user, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) return "user/update/register";
        userService.update(user);
        attributes.addFlashAttribute("userId", user.getId().getValue());
        return "redirect:/user/update/complete";
    }

    @RequestMapping(value = "/complete", method = RequestMethod.GET)
    String complete(SessionStatus status) {
        status.setComplete();
        return "user/update/complete";
    }
}
