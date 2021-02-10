package com.dreamteam.motywatory.front;

import com.dreamteam.motywatory.model.dto.DemotDTO.CreateDemotRequest;
import com.dreamteam.motywatory.model.dto.DemotDTO.GetAllDemotResponse;
import com.dreamteam.motywatory.model.dto.VoteDTO.CreateVoteRequest;
import com.dreamteam.motywatory.repository.DemotRepo;
import com.dreamteam.motywatory.service.DemotService;
import com.dreamteam.motywatory.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class DemotPageController {

    private final DemotService demotService;
    private final VoteService voteService;
    private final DemotRepo demotRepo;

    @GetMapping("/posts")
    public String getAllDemotsPage(Model model) {
        model.addAttribute("posts", demotService.getAllDemots().getDemots());
        model.addAttribute("vote", demotService.getAllDemots().getDemots());
        return "posts";
    }

    @GetMapping("/addDemot")
    public String addDemot(Model model) {
        model.addAttribute("addDemot", new CreateDemotRequest());
        return "addDemot";
    }

    @PostMapping("/addDemot")
    public String addDemotsPage(@ModelAttribute("submitDemot")CreateDemotRequest newDemotRequest, Errors errors) {
        if(errors.hasErrors()) {
        return "posts";
        }
        demotService.createDemotRequest(CreateDemotRequest.builder()
                        .topText(newDemotRequest.getTopText())
                        .imagePath(newDemotRequest.getImagePath())
                        .bottomText(newDemotRequest.getBottomText())
                        .build());
        return "redirect:posts";
    }

    @PostMapping
    public String addVotePage(@ModelAttribute("submitVote")CreateVoteRequest newVoteRequest, Errors errors) {
        if(errors.hasErrors()) {
            return "posts";
        } return "redirect:posts";
    }

}
