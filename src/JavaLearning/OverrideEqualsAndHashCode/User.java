package JavaLearning.OverrideEqualsAndHashCode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String IdCard;

    public User(String name, int age, String IdCard) {
        this.name = name;
        this.age = age;
        this.IdCard = IdCard;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User user = (User) obj;
            if (user.getAge() == this.age && user.getIdCard().equals(this.IdCard) &&
                    user.getName().equals(this.name)) {
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + IdCard.hashCode();
        result = 31 * result + age;
        return result;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getIdCard() {
        return IdCard;
    }

    public static void main(String[] args) {
        User user1=new User("alex",18,"430");
        User user2=new User("alex",18,"430");

        Set<User> set = new HashSet<>();
        Map<User, Integer> map = new HashMap<>();
        set.add(user1);
        set.add(user2);
        map.put(user1, 1);
        map.put(user2, 2);
        System.out.println("user1.equals(user2)="+user1.equals(user2));
        System.out.println("set 长度"+set.size());
        System.out.println("map 长度"+map.keySet().size());;
        /**
         * 没有改写hashCode方法，就会出现set和map的长度都是2
         * 这是因为哈希值不一样
         */
        System.out.println("User1 has hashcode: " + user1.hashCode());
        System.out.println("User2 has hashcode: " + user2.hashCode());

        /**
         * 改写了hashCode方法之后，set和map的长度都是1
         * 哈希值也相同
         */
    }

}
