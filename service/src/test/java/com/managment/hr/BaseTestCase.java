package com.managment.hr;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created with IntelliJ IDEA.
 * User: mabraha
 * Date: 12/2/14
 * Time: 11:31 AM
 * To change this template use File | Settings | File Templates.
 */

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:spring-confing.xml","classpath:spring.xml"})
@TransactionConfiguration(defaultRollback=false,transactionManager ="txManager")
public class BaseTestCase {

}
