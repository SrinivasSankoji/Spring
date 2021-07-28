package com.jio.ngo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class DatabaseLoginInfo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String domainId;
	private String userName;
	private String password;
	private String hostName;
	private String sid;
	private BigDecimal port;
	private BigDecimal status;
	private String loginTime;
	private String default1;
	private String default2;

}

