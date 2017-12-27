package com.bdqn.agentSystem.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.agentSystem.domain.SystemConfigMapper;
import com.bdqn.agentSystem.pojo.SystemConfig;

@Service("systemConfigService")
public class SystemConfigServiceImpl implements SystemConfigService {

	@Resource
	private SystemConfigMapper systemConfigMapper;
	
	@Override
	public List<SystemConfig> getSystomConfigs(SystemConfig systemConfig)  throws Exception{
		System.out.println("---------getSystomConfigs----------");
		System.out.println(systemConfigMapper);
		System.out.println(systemConfig);
		return systemConfigMapper.getSystomConfigs(systemConfig);
	}

	@Override
	public int addSystemConfig(SystemConfig systemConfig)  throws Exception{
		// TODO Auto-generated method stub
		return systemConfigMapper.addSystemConfig(systemConfig);
	}

	@Override
	public int modifySystemConfig(SystemConfig systemConfig)  throws Exception{
		// TODO Auto-generated method stub
		return systemConfigMapper.modifySystemConfig(systemConfig);
	}

	@Override
	public int deleteSystemConfig(SystemConfig systemConfig)  throws Exception{
		// TODO Auto-generated method stub
		return systemConfigMapper.deleteSystemConfig(systemConfig);
	}

	@Override
	public int maxTypeValueByType(int type)  throws Exception{
		// TODO Auto-generated method stub
		return systemConfigMapper.maxTypeValueByType(type);
	}

	@Override
	public List<SystemConfig> getSystomConfigsIsStart(SystemConfig systemConfig)
			throws Exception {
		// TODO Auto-generated method stub
		return systemConfigMapper.getSystomConfigsIsStart(systemConfig);
	}

	@Override
	public int isPeatConfig(SystemConfig systemConfig) throws Exception {
		// TODO Auto-generated method stub
		return systemConfigMapper.isPeatConfig(systemConfig);
	}

}
