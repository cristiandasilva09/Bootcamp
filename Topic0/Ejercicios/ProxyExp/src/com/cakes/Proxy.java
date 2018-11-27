package com.cakes;

import java.sql.*;
import java.util.Date;

public class Proxy {
	MysqlProxy mysqlProxy;

	public Proxy() {
		System.out.println("Creating proxy at " + new Date());
	}

	public void sayHello() throws ClassNotFoundException {
		if (mysqlProxy == null)
		{
			mysqlProxy = new MysqlProxy();
		}
		mysqlProxy.sayHello();
	}

}
