package com.xiaoji.duan.abl.controller;

import com.xiaoji.duan.abl.service.StoreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setting")
public class SettingController {
    private StoreService storeService;

}
