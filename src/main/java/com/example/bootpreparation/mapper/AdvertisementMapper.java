package com.example.bootpreparation.mapper;

import com.example.bootpreparation.dto.AdvertisementResponseDto;
import com.example.bootpreparation.entity.Advertisement;
import com.example.bootpreparation.service.UserService;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class AdvertisementMapper {

    private final UserService userService;

    public AdvertisementMapper(UserService userService) {
        this.userService = userService;
    }

    public Advertisement toEntity(AdvertisementResponseDto advertisementResponseDto) {
        Advertisement advertisement = new Advertisement();
        advertisement.setAddTime(LocalDate.now());
        advertisement.setUser(userService.findUser());
        advertisement.setTextDescription(advertisementResponseDto.getTextDescription());
        advertisement.setTitle(advertisementResponseDto.getTitle());
        advertisement.setFilename(advertisementResponseDto.getFilename());
        return advertisement;
    }
}
