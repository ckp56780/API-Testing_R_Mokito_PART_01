package com.chandan.API_Testing.suit_32;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
//@SelectClasses(ClassATest.class)
//or
//@SelectClasses({ClassATest.class, ClassBTest.class, ClassCTest.class})
//or
//@SelectPackages("com.chandan.API_Testing.forUnitTest.annotations")
//or
@SelectPackages({"com.chandan.API_Testing.forUnitTest.annotations","com.chandan.API_Testing.suit_32"})
public class TestSuit {


}
