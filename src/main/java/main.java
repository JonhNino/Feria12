import com.uptc.fwr.entity.*;
import com.uptc.fwr.feria.PersistenceUtil;
import jakarta.persistence.EntityManager;

import java.sql.SQLOutput;

public class main {

    public static void main(String[] args) {

        testBillPerson();
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class, 12);
        System.out.println(person);
        System.out.println(person.getBooks());
        Book book = entityManager.find(Book.class, 10);
        System.out.println(book.getAutors());

    }

  public static void  testBillPerson(){

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class,12);
        System.out.println(person);
        System.out.println(person.getBills().size());
        Bill bill = entityManager.find(Bill.class,20);
        System.out.println(bill);
        System.out.println(bill.getPerson());

    }
    public static void testBook(){

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Edition edition = entityManager.find(Edition.class,10);
        System.out.println(edition);
        System.out.println(edition.getBook());
        System.out.println();
        Book book =entityManager.find(Book.class,10);
        System.out.println(edition);
        System.out.println(edition.getBook());

    }
    public static void removePerson(){

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class,12);
        System.out.println(person);
        entityManager.getTransaction().begin();
        entityManager.remove(person);
        person.setLastName("Uganda");
        entityManager.persist(person);
        entityManager.getTransaction().commit();

    }
    public static void createPerson(){

        Person person = new Person();
        person.setId(9L);
        person.setName("Juan");
        person.setLastName("Cardenas");
        person.setNationality("Colombiana");
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        System.out.println(person);

    }
    public static void mergePerson(){

        // probarMapeo();
        createPerson();
        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class,9);
        entityManager.getTransaction().begin();
        entityManager.remove(person);
        person.setLastName("Martinez");
        entityManager.persist(person);
        entityManager.getTransaction().commit();

    }

    public static void detachPerson(){

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class,9);
        entityManager.getTransaction().begin();
        person.setLastName("Martinez");
        entityManager.detach(person);
        Person person1 = entityManager.merge(person);
        entityManager.remove(person1);
        entityManager.getTransaction().commit();
    }
    public static void findPersonRefresh(){

        EntityManager entityManager = PersistenceUtil.getEntityManager();
        Person person = entityManager.find(Person.class,12);
        entityManager.getTransaction().begin();
        entityManager.refresh(person);
        person.setLastName("Bayona");
        entityManager.getTransaction().commit();
        System.out.println(person);

    }
     public static void probarMapeo(){

         EntityManager entityManager = PersistenceUtil.getEntityManager();
         Person person = entityManager.find(Person.class,12);
         System.out.println(person);
         Book book = entityManager.find(Book.class,10);
         System.out.println(book);
         Bill bill = entityManager.find(Bill.class,20);
         System.out.println(bill);
         BillDetail billDetail = entityManager.find(BillDetail.class,1);
         System.out.println(billDetail);
         Edition edition = entityManager.find(Edition.class, 10);
         System.out.println(edition);

     }
}
