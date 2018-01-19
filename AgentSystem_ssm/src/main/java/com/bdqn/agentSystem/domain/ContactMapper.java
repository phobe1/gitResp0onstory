package com.bdqn.agentSystem.domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bdqn.agentSystem.pojo.Contact;

@Mapper
public interface ContactMapper {
	/**
	 * getContactList
	 * @param contact
	 * @return
	 */
	public List<Contact> getContactList(Contact contact) throws Exception;
		
	/**
	 * addContact
	 * @param contact
	 * @return
	 */
	public int addContact(Contact contact) throws Exception;
	
	/**
	 * modifyContact
	 * @param contact
	 * @return
	 */
	public int modifyContact(Contact contact) throws Exception;
	
	/**
	 * deleteContact
	 * @param contact
	 * @return
	 */
	public int deleteContact(Contact contact) throws Exception;

}
