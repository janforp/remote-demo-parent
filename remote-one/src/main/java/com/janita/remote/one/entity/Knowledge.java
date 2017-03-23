package com.janita.remote.one.entity;

import java.io.Serializable;

/**
 * 
 * @author cai x d
 * created on 2017/3/4
 * 知识点表,此表在mysql中，由其他项目维护
 *
 */
@SuppressWarnings("serial")
public class Knowledge implements Serializable{

	/**
	 * 知识点id
	 */

	private Long knowledgeId;
	/**
	 * 知识点名称
	 */
	private String name;

	public Knowledge() {
	}
	public Knowledge(Long knowledgeId, String name) {
		super();
		this.knowledgeId = knowledgeId;
		this.name = name;
	}

	public Long getKnowledgeId() {
		return knowledgeId;
	}
	public void setKnowledgeId(Long knowledgeId) {
		this.knowledgeId = knowledgeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "Knowledge [knowledgeId=" + knowledgeId + ", name=" + name + "]";
	}
	
}
