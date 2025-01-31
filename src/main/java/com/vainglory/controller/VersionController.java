package com.vainglory.controller;

import com.vainglory.pojo.Version;
import com.vainglory.pojo.dto.CreateVersionReq;
import com.vainglory.service.IVersionService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/version")
public class VersionController {

  @Autowired
  private IVersionService versionService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping
  public void create(@Validated @RequestBody CreateVersionReq req) {
    Version version = modelMapper.map(req, Version.class);
    boolean result = versionService.save(version);
    if (!result) {
      log.debug("创建版本描述失败");
    }
  }
}
