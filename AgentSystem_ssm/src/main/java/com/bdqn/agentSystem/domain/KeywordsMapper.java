package com.bdqn.agentSystem.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bdqn.agentSystem.pojo.Keywords;


@Mapper
public interface KeywordsMapper {
	/**
	 * getList
	 * @return
	 */
	public List<Keywords> getList() throws Exception;
	/**
	 * 
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	public Integer count(Keywords keywords) throws Exception;
	/**
	 * getKeywordsById
	 * @param keywords
	 * @return
	 */
	public Keywords getKeywordsById(Keywords keywords) throws Exception;
	/**
	 * getKeywordsByKeyword
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	public Keywords getKeywordsByKeyword(Keywords keywords) throws Exception;
	/**
	 * getKeywordsBySearch
	 * @param keywords
	 * @return
	 */
	public List<Keywords> getKeywordsBySearch(Keywords keywords) throws Exception;
	/**
	 * modifyKeywords
	 * @param keywords
	 * @return
	 */
	public int modifyKeywords(Keywords keywords) throws Exception;
	/**
	 * addKeywords
	 * @param keywords
	 * @return
	 */
	public int addKeywords(Keywords keywords) throws Exception;
	/**
	 * deleteKeywords
	 * @param keywords
	 * @return
	 */
	public int deleteKeywords(Keywords keywords) throws Exception;
	
	/**
	 * portalcount
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	public int portalcount(Keywords keywords) throws Exception;
	
	/**
	 * getPortalBySearch
	 * @param keywords
	 * @return
	 * @throws Exception
	 */
	public List<Keywords> getPortalBySearch(Keywords keywords) throws Exception;
}
