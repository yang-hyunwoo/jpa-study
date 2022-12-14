package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
//            List<Member> result = em.createQuery("select m from Member as m",Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            /*insert */
            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            //영속
//            em.persist(member);

            //준영속 상태
            /* update */
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloC");

//            em.remove(findMember); deleted

//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//            Member findMember = em.find(Member.class, member.getId());
//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam = " + findTeam.getName());
//
//            Team newTeam = em.find(Team.class, 100L);
//            findMember.setTeam(newTeam);

//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//
//            for(Member m : members) {
//                System.out.println("m = "+ m.getUsername() );
//            }


//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
////            member.changeTeam(team);
//            em.persist(member);
//
//            team.addMember(member);
//            em.flush();
//            em.clear();
//
//            Team findTeam = em.find(Team.class, team.getId());
//            List<Member> members = findTeam.getMembers();
//
//            for(Member m : members) {
//                System.out.println("m = " + m.getUsername());
//            }

//            Movie movie = new Movie();
//            movie.setDirector("aaaa");
//            movie.setActor("bbbb");
//            movie.setName("바람과함께사라지다");
//            movie.setPrice(10000);
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
////            Movie findMovie = em.find(Movie.class, movie.getId());
//            Item item = em.find(Item.class, movie.getId());
//            System.out.println("findMovie = " + item);

//            Member member = new Member();
//            member.setUsername("user1");
//            member.setCreatedBy("kim");
//            member.setCreatedDate(LocalDateTime.now());
//
//            em.persist(member);
//            em.flush();
//            em.clear();

//            Member member1 = new Member();
//            member1.setUsername("hello1");
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("hello2");
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.getReference(Member.class, member2.getId());
//
//            logic(m1 , m2);
//            System.out.println("m1 == m2 " +  );

//            Member member1 = new Member();
//            member1.setUsername("hello1");
//            em.persist(member1);
//
//            em.flush();
//            em.clear();

//            Member reference = em.getReference(Member.class, member1.getId());
//            System.out.println("reference = " + reference.getClass());
//
//            Member m1 = em.find(Member.class, member1.getId());
//            System.out.println("m1 = " + m1.getClass());
//
//            System.out.println("a == a: " + (m1 == reference));

//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("reference = " + refMember.getClass());
//            Hibernate.initialize(refMember); //강제 초기화
//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member1 = new Member();
//            member1.setUsername("hello1");
//            member1.setTeam(team);
//
//            em.persist(member1);
//
//
//            em.flush();
//            em.clear();
//
//
//            Member member = em.find(Member.class, member1.getId());
//            System.out.println(member.getTeam().getClass());
//
//            System.out.println("==========");
//            System.out.println("teaName = "+ member.getTeam().getName());
//            System.out.println("=========");

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Team teamB = new Team();
//            teamB.setName("teamB");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("hello1");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("hello1");
//            member2.setTeam(teamB);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            List<Member> members = em.createQuery("select m from Member m", Member.class)
//                    .getResultList();



//            Member findMember = em.find(Member.class, 1L);
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("findMember = " + findMember.getClass() );
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getUsername() = " + findMember.getUsername());

//            Member member = em.find(Member.class, 1L);
//            printMember(member);
//            printMemberAndTeam(member);


//            Child child1 = new Child();
//            Child child2 = new Child();
//            Parent parent = new Parent();
//
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(0);

//            Address homeAddress = new Address("city", "street", "10");
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(homeAddress);
//            em.persist(member);
//
//            Address newAddress = new Address("NewCity", homeAddress.getStreet(), homeAddress.getZipcode());
//            member.setHomeAddress(newAddress);

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(new Address("homeCity","street","10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new Address("old1", "street", "10000"));
            member.getAddressHistory().add(new Address("old2", "street", "10000"));

            em.persist(member);

            em.flush();
            em.clear();
            System.out.println("============== START =============");
            Member findMember = em.find(Member.class, member.getId());
            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("newCity",a.getStreet(),a.getZipcode()));

            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            findMember.getAddressHistory().remove(new Address("old1", "street", "10000"));
            findMember.getAddressHistory().add(new Address("newCity1", "street", "10000"));


            tx.commit();
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();



    }

    private static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2: "+(m1 instanceof Member));
        System.out.println("m1 == m2: "+(m2 instanceof Member));
    }

//    private static void printMember(Member member) {
//        System.out.println(member.getUsername());
//
//    }
//
//    private static void printMemberAndTeam(Member member) {
//        String username = member.getUsername();
//        System.out.println("username = " + username);
//        Team team = member.getTeam();
//        System.out.println("team = " + team.getName());
//    }
}
