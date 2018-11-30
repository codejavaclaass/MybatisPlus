package MPtest;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mybatis.beans.Employee;
import com.mybatis.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMp {

    private ApplicationContext iocContext = new
            ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test2() throws Exception{
        EmployeeMapper mapper = iocContext.getBean(EmployeeMapper.class);
        List<Employee> list = mapper.selectList(new EntityWrapper<Employee>().between("id", 1, 5).eq("gender", 1));

        System.out.println(list);
    }

    @Test
    public void testEnvironment() throws Exception{
        EmployeeMapper mapper = iocContext.getBean(EmployeeMapper.class);

        Employee employee = new Employee();
        employee.setAge(23);
        employee.setEmail("tom@atguigu.com");
        employee.setGender(1);
        employee.setLastName("haha");
        mapper.insert(employee);

    }
}
