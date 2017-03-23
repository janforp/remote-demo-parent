package com.janita.remote.rmi.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author cai x d
 * created on 2017/3/4
 * 选项表
 */
@SuppressWarnings("serial")
public class QuestionItem implements Serializable{
	
	/**
	 * 序号,如：1,2...
	 */
	private Integer index;
	
	/**
	 * 选项,如：A,B...
	 */
	private String item;
	
	/**
	 * 内容,每一项的内容,若是图片则存url
	 */

	/**
	 * 选项关联知识点
	 */
	private List<Knowledge> itemRelativeKnowledge;


	private String content;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public QuestionItem() {
		
	}

	public List<Knowledge> getItemRelativeKnowledge() {
		return itemRelativeKnowledge;
	}

	public void setItemRelativeKnowledge(List<Knowledge> itemRelativeKnowledge) {
		this.itemRelativeKnowledge = itemRelativeKnowledge;
	}

	@Override
	public String toString() {
		return "QuestionItem{" +
				"index=" + index +
				", item='" + item + '\'' +
				", itemRelativeKnowledge=" + itemRelativeKnowledge +
				", content='" + content + '\'' +
				'}';
	}

	public QuestionItem(Integer index, String item, List<Knowledge> itemRelativeKnowledge, String content) {
		this.index = index;
		this.item = item;
		this.itemRelativeKnowledge = itemRelativeKnowledge;
		this.content = content;
	}
}
