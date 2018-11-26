package Hibernate;

import Entities.Department;
import Entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

@Component
public class HibernateUtils  {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    private static EntityManagerFactory entityManagerFactory;
    private SessionFactory _sessionFactory;

    @Bean
    public Session getSessionFactory(){
        if(sessionFactory==null){
            try {
                StandardServiceRegistryBuilder registryBuilder =
                        new StandardServiceRegistryBuilder();
                Map<String,Object> settings =new HashMap();
                settings.put("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
                settings.put("hibernate.connection.url","jdbc:mysql://127.0.0.1:3306/hibernate");
                settings.put("hibernate.connection.username","root");
                settings.put("hibernate.connection.password","");
                settings.put("hibernate.hbm2ddl.auto","update");
                settings.put("hibernate.connection.autocommit",true);
                settings.put("hibernate.show_sql",true);

                registryBuilder.applySettings(settings);
                registry = registryBuilder.build();
                MetadataSources sources = new MetadataSources(registry)
                        .addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Department.class);
                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();


            }catch (Exception e){
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
                e.printStackTrace();
            }
        }
        return  sessionFactory.openSession();
    }

    @Bean
    public EntityManagerFactory getEntityManagerFactory(){
        if(sessionFactory==null){
            try {
                if (entityManagerFactory == null) {
                    EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
                    entityManagerFactory = factory;
                }

            }catch (Exception e){
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
                e.printStackTrace();
            }
        }
        return  entityManagerFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}