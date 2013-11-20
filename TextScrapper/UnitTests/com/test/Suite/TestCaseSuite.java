package com.test.Suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.test.Business.Test.TextScraperQuery1Test;
import com.test.Business.Test.TextScraperQuery2Test;
import com.test.UtilityTest.UtilityTest;

@RunWith(Suite.class)
@SuiteClasses({
		UtilityTest.class,
		TextScraperQuery1Test.class,
		TextScraperQuery2Test.class
})
public class TestCaseSuite {
	
}
