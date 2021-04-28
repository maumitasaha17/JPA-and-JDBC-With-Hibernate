package com.cg.insurance.test.dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BasicTest {
	
		@BeforeEach
		void setUp() throws Exception {
			System.out.println("setUp");
		}
		@AfterEach
		void tearDown() throws Exception {
			System.out.println("tearDown");
		}
		@Test
		void testA() {
			System.out.println("Test A");
		}
		@Test
		void testB() {
			System.out.println("Test B");
		}
	}