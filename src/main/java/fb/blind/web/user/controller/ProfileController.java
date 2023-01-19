package fb.blind.web.user.controller;

import fb.blind.common.argumentresolver.Login;
import fb.blind.domain.profile.Profile;
import fb.blind.domain.profile.repository.ProfileRepository;
import fb.blind.domain.user.User;
import fb.blind.web.user.form.ProfileForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileRepository pr;

    @GetMapping
    public void show(@Login User loginUser, Model model){

        Profile profile = pr.findByUserId(loginUser.getId());

        model.addAttribute("user", loginUser);
        model.addAttribute("profile", profile);
    }

}
