package com.bdqn.agentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdqn.agentSystem.domain.FunctionMapper;
import com.bdqn.agentSystem.pojo.Function;

@Service("functionService")
public class FunctionServiceImpl implements FunctionService {
	
	@Autowired
	private FunctionMapper mapper;
	@Override
	public List<Function> getFunctionList()  throws Exception{
		// TODO Auto-generated method stub
		return mapper.getFunctionList();
	}
	@Override
	public Function getFunctionById(Function function) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getFunctionById(function);
	}
	@Override
	public List<Function> getMenuFunction() throws Exception {
		// TODO Auto-generated method stub
		return mapper.getMenuFunction();
	}

}
