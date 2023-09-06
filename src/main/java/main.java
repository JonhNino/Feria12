import com.uptc.fwr.entity.*;
import com.uptc.fwr.feria.PersistenceUtil;
import jakarta.persistence.EntityManager;

public class main {

    public static void main(String[] args){
       // probarMapeo();
            Person person = new Person();
            person.setId(5L);
            person.setName("Juan");
            person.setLastName("Cardenas");
            person.setNationality("Colombiana");
            EntityManager entityManager = PersistenceUtil.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(person);
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
