package com.cakes;

import java.util.Date;

public class PruebaProxy {
	public void sayHello() {
		System.out.println(this.getClass().getSimpleName() + " probando Proxy a las  " + new Date());
	}
}

