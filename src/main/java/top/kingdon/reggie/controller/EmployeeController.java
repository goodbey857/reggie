package top.kingdon.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import top.kingdon.reggie.entity.Employee;
import top.kingdon.reggie.entity.R;
import top.kingdon.reggie.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee){

        QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>();
        queryWrapper.eq("username",employee.getUsername());
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes()); //md5加密

        Employee emp = employeeService.getOne(queryWrapper);

        if(emp==null){
            return R.error("该用户不存在");
        }

        if(emp.getPassword()==null || !emp.getPassword().equals(password)){
            return R.error("密码错误");
        }

        if(emp.getStatus()==0){
            return R.error("该用户已被禁用");
        }

        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);
    }
    @PostMapping("/logout")
    public R<Employee> logout(HttpServletRequest request) throws IOException {
        request.getSession().removeAttribute("employee");
        return R.error("已退出登录");
    }

    @PostMapping
    public R<String> save(HttpServletRequest request,@RequestBody Employee employee){
        String password = "123456";
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        employee.setPassword(password);
//        employee.setCreateTime(LocalDateTime.now());
//        employee.setUpdateTime(LocalDateTime.now());
//        Long empid = (Long) request.getSession().getAttribute("employee");
//        employee.setCreateUser(empid);
//        employee.setUpdateUser(empid);
        employeeService.save(employee);
        System.out.println("创建成功");
        return R.success("创建用户成功");
    }

    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        Page pageInfo = new Page(page,pageSize);
        LambdaQueryWrapper<Employee> queryWrapper = new <Employee>LambdaQueryWrapper();
        queryWrapper.like(name!=null,Employee::getName,name);
        queryWrapper.orderByDesc(Employee::getUpdateTime);
        employeeService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }

    @PutMapping
    public R<String> update(HttpServletRequest request,@RequestBody Employee employee){
        Long empid = (Long) request.getSession().getAttribute("employee");
        employee.setUpdateTime(LocalDateTime.now());
        employee.setUpdateUser(empid);
        employeeService.updateById(employee);
        return R.success("修改成功");
    }

    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable Long id){
        Employee employee = employeeService.getById(id);
        if(employee!=null){
            return R.success(employee);
        }

        return R.error("该用户不存在");
    }





}
