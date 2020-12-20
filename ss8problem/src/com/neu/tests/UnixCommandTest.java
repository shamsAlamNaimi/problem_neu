package com.neu.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.neu.SS8.UnixCommand;

public class UnixCommandTest {

	@Test
	public void testExecuteCommand() {
		UnixCommand uc= new UnixCommand();
		String output= uc.executeCommand("/", "abc");
		assertEquals("/abc",output);
	}
	
	@Test
	public void testAdditionPath() {
		UnixCommand uc= new UnixCommand();
		String output= uc.executeCommand("/abc/def", "ghi");
		assertEquals("/abc/def/ghi",output);
	}
	
	@Test
	public void testPrevDic() {
		UnixCommand uc= new UnixCommand();
		String output= uc.executeCommand("/abc/def", "..");
		assertEquals("/abc",output);
	}
	
	@Test
	public void testMove() {
		UnixCommand uc= new UnixCommand();
		String output= uc.executeCommand("/abc/def", "/abc");
		assertEquals("/abc",output);
	}
	
	@Test
	public void testMove2() {
		UnixCommand uc= new UnixCommand();
		String output= uc.executeCommand("/abc/def", "/ijk/xyz");
		assertEquals("/ijk/xyz",output);
	}
	
	@Test
	public void testGoToTop() {
		UnixCommand uc= new UnixCommand();
		String output= uc.executeCommand("/abc/def", "../..");
		assertEquals("/",output);
	}
	
	@Test
	public void testMultipleUp() {
		UnixCommand uc= new UnixCommand();
		String output= uc.executeCommand("/abc/def", "../../..");
		assertEquals("/",output);
	}
	
	@Test
	public void testDot() {
		UnixCommand uc= new UnixCommand();
		String output= uc.executeCommand("/abc/def", ".");
		assertEquals("/abc/def",output);
	}
	
	
	@Test
	public void toNoDir() {
		UnixCommand uc= new UnixCommand();
		String output= uc.executeCommand("/abc/def", "..klm");
		assertEquals("..klm: No such file or directory",output);
	}
	
	@Test
	public void testMultipleSlash() {
		UnixCommand uc= new UnixCommand();
		String output= uc.executeCommand("/abc/def", "//////");
		assertEquals("/",output);
	}
	
	@Test
	public void testMulDots() {
		UnixCommand uc= new UnixCommand();
		String output= uc.executeCommand("/abc/def", ".....");
		assertEquals(".....: No such file or directory",output);
	}
	
	@Test
	public void testOtherDir() {
		UnixCommand uc= new UnixCommand();
		String output= uc.executeCommand("/abc/def", "../gh///../klm/.");
		assertEquals("/abc/klm",output);
	}
	
	@Test
	public void testOtherloc() {
		UnixCommand uc= new UnixCommand();
		String output= uc.executeCommand("/abc/def", "/gh/../hfe");
		assertEquals("/hfe",output);
	}
	
	
	}


