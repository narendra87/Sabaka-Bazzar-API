package com.sap.spring.mongodb.controller.sabakabazzar;

import com.sap.spring.mongodb.modal.Banner;
import com.sap.spring.mongodb.repository.sabakabazzar.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BannerController {
    @Autowired
    BannerRepository bannerRepository;

    @GetMapping("/sabakabazzar/banners")
    public List<Banner> getBanners() {
        return bannerRepository.findAll();
    }
}
