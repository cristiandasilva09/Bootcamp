package com.cakes;
import java.sql.*;
public class ProxyDemo {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	

		Proxy proxy = new Proxy();
		PostgreProxy postgreProxy = new PostgreProxy();
		postgreProxy.sayHello();

		proxy.sayHello();
		}
	}

