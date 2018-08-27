import com.huh.ssm.domain.Address;
import com.huh.ssm.domain.Customer;
import com.huh.ssm.service.CustomerService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestCurd {

    /**
     * test c3p0 data source in spring configuration is available.
     */
    @Test
    public void getConn() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        ComboPooledDataSource dataSource = (ComboPooledDataSource) ac.getBean("combopooledDataSource");
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testUserService() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService userService = (CustomerService) ac.getBean("customerService");
        Customer u = new Customer();
        u.setFirstName("JACK");
        u.setLastName("FOUST");
        Customer c = userService.selectOne(u.getFirstName());
        if (c == null) {
            System.out.println("查无此人");
        } else {
            System.out.println(c);
        }
    }

    @Test
    public void testSelectPage(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService userService = (CustomerService) ac.getBean("customerService");
        List<Customer> customers = userService.selectPage(590,20);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void testDate() {
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        Customer c = new Customer();
        Address a = new Address();
        String lastUpdate = ft.format(dNow);

        int customerId = 2;
        String firstName = "Bob";
        String lastName = "Mires";
        String email = "321@abc.com";
        int addressId = 1;

        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setEmail(email);
        c.setLastUpdate(lastUpdate);
        a.setAddressId(addressId);
        c.setAddress(a);
        c.setCustomerId(customerId);

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerService = (CustomerService) ac.getBean("customerService");

        System.out.println(customerService.update(c) + "　行受到影响");

    }

    @Test
    public void testInsert() {

        // now
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        Customer c = new Customer();
        Address a = new Address();
        String lastUpdate = ft.format(dNow);

        String firstName = "Bob";
        String lastName = "Mires";
        int storeId = 1;
        String email = "8080@qq.com";
        a.setAddress("1566 Inegl Manor");

        c.setAddress(a);
        c.setFirstName(firstName);
        c.setLastName(lastName);
        c.setEmail(email);
        c.setLastUpdate(lastUpdate);
        c.setStoreId(storeId);
        c.setCreateDate(lastUpdate);
        c.setActive(1);

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerService = (CustomerService) ac.getBean("customerService");

        customerService.insert(c);
        System.out.println("done");

    }

    @Test
    public void testDelete() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerService = (CustomerService) ac.getBean("customerService");

        int customerId = 1;
        try {
            int line = customerService.delete(customerId);
        }catch (Exception e) {
            String ex = e.getClass().toString();
            System.out.println(ex.substring(ex.lastIndexOf('.') + 1, ex.length()));
        }
    }

}
