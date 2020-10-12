package com.example.bootpreparation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdvertisementResponseDto {

    private String title;
    private String filename;
    private String textDescription;

    public AdvertisementResponseDto(String title, String textDescription) {
        this.title = title;
        this.textDescription = textDescription;
    }
}
