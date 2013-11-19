package com.test.Suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.test.UtilityTest.UtilityTest;

@RunWith(Suite.class)
@SuiteClasses({
		UtilityTest.class
})
public class TestCaseSuite {
	
}
