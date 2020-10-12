package com.example.bootpreparation.controller;

import com.example.bootpreparation.dto.AdvertisementResponseDto;
import com.example.bootpreparation.entity.Advertisement;
import com.example.bootpreparation.entity.User;
import com.example.bootpreparation.mapper.AdvertisementMapper;
import com.example.bootpreparation.service.AdService;
import com.example.bootpreparation.service.UserService;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping()
public class UserController {

    @Value("${upload.path}")
    private String uploadPath;
    private final UserService userService;
    private final AdService adService;
    private final AdvertisementMapper advertisementMapper;
    private final int pageSize = 10;

    public UserController(UserService userService,
                          AdService adService,
                          AdvertisementMapper advertisementMapper) {
        this.userService = userService;
        this.adService = adService;
        this.advertisementMapper = advertisementMapper;
    }

    @PostMapping("/users/ad-advertisement")
    public String userAddAd(AdvertisementResponseDto advertisementResponseDto,
                            @RequestParam("file") MultipartFile file)
            throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFilename));
            advertisementResponseDto.setFilename(resultFilename);
        }
        adService.add(advertisementMapper.toEntity(advertisementResponseDto));
        return "redirect:/personal-area";
    }

    @GetMapping("/users/ad-advertisement")
    public String adGet(Model model) {
        AdvertisementResponseDto advertisementResponseDto = new AdvertisementResponseDto();
        model.addAttribute("advertisementResponseDto", advertisementResponseDto);
        return "ad";
    }

    @PostMapping("/users/update")
    public String updateUser(User user) {
        userService.update(user);
        return "home";
    }

    @GetMapping("/users/update")
    public String updateGet(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "update";
    }

    @GetMapping("/home-page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                Model model) {
        Page<Advertisement> page = adService.findPaginated(pageNo, pageSize);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("advertisements", page.getContent());
        return "homePage";
    }

    @GetMapping("/home-page")
    public String viewHomePage(Model model) {
        Page<Advertisement> page = adService.findPaginated(1, pageSize);
        model.addAttribute("currentPage", 1);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("advertisements", page.getContent());
        return "homePage";
    }
}
