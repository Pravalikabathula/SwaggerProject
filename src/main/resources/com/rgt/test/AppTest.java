package com.rgt.test;

import or.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.api.methodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TsetMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class AppTest {
	@Test
	public void testSave() {
		System.out.println("save-hello");
	}

	@Test
	public void testUpdate() {
		System.out.println("save-hello");
	}

	@Test
	public void testDelete() {
		System.out.println("save-hello");
	}
}
