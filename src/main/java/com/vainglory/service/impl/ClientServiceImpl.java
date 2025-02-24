package com.vainglory.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vainglory.domain.Client;
import com.vainglory.mapper.ClientMapper;
import com.vainglory.service.IClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements IClientService {
}
