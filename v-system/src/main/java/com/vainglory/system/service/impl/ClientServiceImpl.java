package com.vainglory.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vainglory.system.domain.Client;
import com.vainglory.system.mapper.ClientMapper;
import com.vainglory.system.service.IClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements IClientService {
}
