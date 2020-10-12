package com.example.bootpreparation.service;

import com.example.bootpreparation.entity.Advertisement;
import java.util.List;
import org.springframework.data.domain.Page;

public interface AdService {

    Advertisement add(Advertisement advertisement);

    List<Advertisement> findAllAdThisUser();

    Page<Advertisement> findPaginated(int pageNo, int pageSize);
}
