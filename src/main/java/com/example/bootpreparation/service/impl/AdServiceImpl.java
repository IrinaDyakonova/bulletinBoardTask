package com.example.bootpreparation.service.impl;

import com.example.bootpreparation.entity.Advertisement;
import com.example.bootpreparation.entity.User;
import com.example.bootpreparation.repository.AdRepository;
import com.example.bootpreparation.service.AdService;
import com.example.bootpreparation.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl implements AdService {

    private final UserService userService;
    private final AdRepository adRepository;

    public AdServiceImpl(UserService userService, AdRepository adRepository) {
        this.userService = userService;
        this.adRepository = adRepository;
    }

    @Override
    public Advertisement add(Advertisement advertisement) {
        return adRepository.save(advertisement);
    }

    @Override
    public List<Advertisement> findAllAdThisUser() {
        User user = userService.findUser();
        return adRepository
                .findAll()
                .stream()
                .filter(advertisement -> advertisement.getUser().getId().equals(user.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Page<Advertisement> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.adRepository.findAll(pageable);
    }
}
