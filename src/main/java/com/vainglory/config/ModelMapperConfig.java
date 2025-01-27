package com.vainglory.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();

//    // 添加自定义映射规则
//    modelMapper.addMappings(new PropertyMap<SourceObject, DestinationObject>() {
//      @Override
//      protected void configure() {
//        // 添加映射规则
//        map().setSomeProperty(source.getSomeOtherProperty());
//      }
//    });
    // 完全匹配
    modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
    modelMapper.getConfiguration().setSkipNullEnabled(true);

    // 匹配策略使用严格模式
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    return modelMapper;
  }

}
