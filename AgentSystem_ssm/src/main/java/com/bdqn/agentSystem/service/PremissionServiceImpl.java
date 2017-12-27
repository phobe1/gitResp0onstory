package com.bdqn.agentSystem.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.agentSystem.domain.PremissionMapper;
import com.bdqn.agentSystem.pojo.Premission;

@Service("premissionService")
public class PremissionServiceImpl implements PremissionService {

	@Resource
	private PremissionMapper premissionMapper;
	
	@Override
	public List<Premission> getList(Premission premission)  throws Exception{
		// TODO Auto-generated method stub
		return premissionMapper.getList(premission);
	}

	@Override
	public int addPremission(Premission premission)  throws Exception{
		// TODO Auto-generated method stub
		return premissionMapper.addPremission(premission);
	}

	@Override
	public int modifyPremission(Premission premission)  throws Exception{
		// TODO Auto-generated method stub
		return premissionMapper.modifyPremission(premission);
	}

	@Override
	public int deletePremission(Premission premission)  throws Exception{
		// TODO Auto-generated method stub
		return premissionMapper.deletePremission(premission);
	}

	@Override
	public boolean hl_delAddPremission(Premission premission,String checkFuncList) throws Exception{
		// TODO Auto-generated method stub
		String[] funcList = null;
		if(!checkFuncList.equals("") && null != checkFuncList){
			funcList = checkFuncList.split(",");
		}
		premissionMapper.deletePremission(premission);
		if(null != funcList && !funcList.equals("")){
			for(int i = 0; i < funcList.length; i++){
				premission.setFunctionId(Integer.valueOf(funcList[i]));
				premissionMapper.addPremission(premission);
			}
		}
		return true;
	}

}
