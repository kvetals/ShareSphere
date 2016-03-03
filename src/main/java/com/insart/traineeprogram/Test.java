package com.insart.traineeprogram;

import com.insart.traineeprogram.dao.FileSystemObjectsDAO;
import com.insart.traineeprogram.dao.FileSystemObjectsDAOImpl;
import com.insart.traineeprogram.dao.InitDestroyDAO;
import com.insart.traineeprogram.dao.InitDestroyDAOImpl;
import com.insart.traineeprogram.dao.InitDestroyDAOSpringJDBCImpl;
import com.insart.traineeprogram.dao.PrivilegesDAO;
import com.insart.traineeprogram.dao.PrivilegesDAOSpringJDBCImpl;
import com.insart.traineeprogram.dao.RolesDAO;
import com.insart.traineeprogram.dao.RolesDAOHibernateImpl;
import com.insart.traineeprogram.dao.RolesDAOSpringJDBCImpl;
import com.insart.traineeprogram.dao.UsersDAO;
import com.insart.traineeprogram.dao.UsersDAOHibernateImpl;
import com.insart.traineeprogram.dao.UsersDAOSpringJDBCImpl;
import com.insart.traineeprogram.model.Role;
import com.insart.traineeprogram.model.User;
import com.insart.traineeprogram.service.UserService;
import com.insart.traineeprogram.utils.DaoHibernateUtils;
import com.insart.traineeprogram.utils.SpringUtils;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Семья on 13.02.2016.
 */
public class Test {
    public static void main(String[] args) {
        FileSystemObjectsDAO fsDAO = new FileSystemObjectsDAOImpl();
//        MyDbConnection.checkConnection();
//        System.out.println(fsDAO.getFsObjects());
//        MyDbConnection.checkConnection();
//        System.out.println(fsDAO.getFsObjectById(8));
//        MyDbConnection.checkConnection();
//        System.out.println(fsDAO.getFsObjectsByName("name"));
//        InitDestroyDAO initDestroy = new InitDestroyDAOImpl();
//        initDestroyDAO.initDb();
//        initDestroy.destroyDb();
        
//        UserService userService = new UserService();
//        boolean result = userService.registerNewUser("kvetal", "1111", "kvetal@gmail.com", 2);
//        System.out.println("User успешно зарегистрирован на сайте :" + result);
//        result = userService.registerNewUser("kvetal", "2222", "kvetals@yahoo.com", 2);
//        System.out.println("User успешно зарегистрирован на сайте :" + result);
//        User user = userService.authenticateUser("kvetal", "06041986");
//        System.out.println("User успешно авторизован на сайте :" + result);
//        user = userService.authenticateUser("kvetals", "2222");
//        System.out.println("User успешно авторизован на сайте :" + result);
//        System.out.println(UserService.resetUserPassword("kvetals@gmail.com"));
//        user = userService.authenticateUser("kvetals", "06041986");
//        System.out.println(user);
//        System.out.println("Trim equals = " + " ".trim() == "");
//        if (user != null)
//        	userService.changeUserPassword(user.getUserId(), "06041986");
        
//        RolesDAO rolesDao = new RolesDAOHibernateImpl();
//        UsersDAO userDao = new UsersDAOHibernateImpl();
//        UsersDAO userDaoSpringImpl = new UsersDAOSpringJDBCImpl();
//        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
//        context.load("classpath:spring.settings.xml");
//        context.refresh();
        UserService userService = SpringUtils.getContext().getBean("userService", UserService.class);
        System.out.println(userService.authenticateUser("kvetals", "06041986"));
//        InitDestroyDAO initDestroyDaoSpringImpl = context.getBean("initDestroyDAO", InitDestroyDAOSpringJDBCImpl.class);
//        UsersDAO userDaoSpringImpl = context.getBean("usersDAO", UsersDAOSpringJDBCImpl.class);
//        RolesDAO rolesDaoSpringImpl = context.getBean("rolesDAO", RolesDAOSpringJDBCImpl.class);
//        PrivilegesDAO privilegesDaoSpringImpl = context.getBean("privilegesDAO", PrivilegesDAOSpringJDBCImpl.class);
        
//        initDestroyDaoSpringImpl.destroyDb();
//        User userFromDB = userDaoSpringImpl.getUserById(50);
//        System.out.println(userFromDB);
//        System.out.println(userDaoSpringImpl.getAllUsers());
//        System.out.println(userDaoSpringImpl.getUserByEmail("leftEmail@mail"));
//        System.out.println(userDaoSpringImpl.getUserByEmail("test@email2"));
//        System.out.println(userDaoSpringImpl.getUserByLoginAndPassword("kvetals", "06041986"));
//        System.out.println(userDaoSpringImpl.getUsersByRoleCaption("admin"));
//        System.out.println(userDaoSpringImpl.getUsersByRoleCaption("user"));
//        System.out.println(userDaoSpringImpl.isExist("test"));
//        System.out.println(userDaoSpringImpl.isExist("testUser2"));
        
//        System.out.println(userDaoSpringImpl.getAllUsers());
//        List<Role> list = rolesDao.getRoles();
//        System.out.println(list);
//        Role role = rolesDao.getRoleById(2);
//        System.out.println(role);
//        role = rolesDao.getRoleByCaption("admin");
//        System.out.println(role);
//        rolesDao.addRole("testRoleToDelete");
//        rolesDao.deleteRoleById(3);
//        rolesDao.deleteRoleByCaption("testRoleToDelete");
        
//        System.out.println(userDao.isExist("kvetals"));
//        User userToSave = new User("SpringUser", "springTestPassword", "springTest@email", 2);
//        userDaoSpringImpl.addUser(userToSave);
//        userDao.addUser(userToSave);
//        userToSave = new User("kvetals", "06041986", "kvetals@gmail.com", 2);
//        userDao.addUser(userToSave);
//        userToSave = new User("test", "test", "test@test", 2);
//        userDao.addUser(userToSave);
//        userToSave = new User("testUser2", "testPassword2", "test@email2", 2);
//        userDao.addUser(userToSave);
//        userToSave = new User("testUser3", "testPassword3", "test@email3", 2);
//        userDao.addUser(userToSave);
//        userToSave = new User("testUser4", "testPassword4", "test@email4", 2);
//        userDao.addUser(userToSave);
//        userToSave = new User("testUser5", "testPassword5", "test@email5", 2);
//        userDao.addUser(userToSave);
//        userToSave = new User("testUser6", "testPassword6", "test@email6", 2);
//        userDao.addUser(userToSave);
//        userDao.changePasswordByUserId("ChangedPassword", 7);
//        System.out.println(userDao.getAllUsers());
//        System.out.println(userDao.getUserById(5));
//        System.out.println(userDao.getUserByEmail("kvetals@gmail.com"));
//        System.out.println(userDao.getUserByLoginAndPassword("kvetals", "06041986"));
//        userDao.deleteUserByLogin("testUser");
//        userDao.deleteUserById(47);
//        System.out.println(userDao.getAllUsers());
        
        
//        Session s = DaoHibernateUtils.getHibernateSession();
//        Criteria criteria = s.createCriteria(User.class);
//		user = (User)criteria.add(Restrictions.eq("userLogin", "test")).uniqueResult();
//		System.out.println(user);
//		if (user != null){
//			System.out.println("Deleting user = " + user);
//			s.delete(user);
//			s.flush();
//		}
        
//        Session ses = DaoHibernateUtils.getHibernateSession(); 
//        ses.beginTransaction();
//        ses.createCriteria(Role.class).list();
//        Role roleUser = (Role) ses.load(Role.class, 2);
//        System.out.println(roleUser);
//        User jim = new User("Jim2","password2", "email@email2");
//        jim.setRole(roleUser);
//        roleUser.getUserSet().add(jim);
//        ses.saveOrUpdate(jim);
//        ses.getTransaction().commit();
    }
}
