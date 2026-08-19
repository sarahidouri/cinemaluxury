package cinema.movies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cinema.movies.repository.FilmRepository;
import cinema.movies.repository.SalleRepository;
import cinema.movies.repository.SeanceRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final FilmRepository filmRepository;
    private final SalleRepository salleRepository;
    private final SeanceRepository seanceRepository;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("username", "Admin");

        model.addAttribute("filmCount", filmRepository.count());
        model.addAttribute("salleCount", salleRepository.count());
        model.addAttribute("seanceCount", seanceRepository.count());

        model.addAttribute("userCount", 0);

        return "index";
    }

    @GetMapping("/index")
    public String dashboard(Model model) {
        return home(model);
    }
}