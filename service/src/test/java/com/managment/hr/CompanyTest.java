package com.managment.hr;

import com.managment.hr.Service.IhrService;
import com.managment.hr.domain.Company;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: mabraha
 * Date: 12/2/14
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class CompanyTest extends BaseTestCase {

@Autowired
private IhrService ihrService;

@Test
public void companyTest()
{
 Company company=ihrService.getCompany(2);
 Assert.assertNotNull(company);


}
}
