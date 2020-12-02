import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class PersonTest {
    Person person1;
    Person person2;
    Person person3;
    List<Person> people;
    @Before
    public void setup(){
        people = new ArrayList<>();
        person1 = new Person("Bob", LocalDate.of(1980, 1, 25), Person.Sex.MALE, "bob@bob.com");
        person2 = new Person("Sally", LocalDate.of(2000, 10, 5), Person.Sex.FEMALE, "sally@sally.com");
        person3 = new Person("Guy", LocalDate.of(1995, 6, 13), Person.Sex.MALE, "guy@guy.com");
        people.add(person1);
        people.add(person2);
        people.add(person3);
    }
    @Test
    public void testConstructor(){
     //   Person person1 = new Person("Bob", LocalDate.now(), Person.Sex.MALE, "bob@bob.com");
        Assert.assertNotNull(person1);
    }
    @Test
    public void testNullaryConstructor(){
        Person person = new Person();
        Assert.assertNotNull(person);
    }
    @Test
    public void testGetName(){
      //  Person person1 = new Person("Bob", LocalDate.of(1980, 1, 25), Person.Sex.MALE, "bob@bob.com");
        String expected = "Bob";
        String actual = person1.getName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testSetName(){
     //   Person person1 = new Person("Bob", LocalDate.of(1980, 1, 25), Person.Sex.MALE, "bob@bob.com");
        String expected = "Todd";
        person1.setName(expected);
        String actual = person1.getName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testToString(){
     //   Person person1 = new Person("Bob", LocalDate.of(1980, 1, 25), Person.Sex.MALE, "bob@bob.com");
        String expected = "java.Person{" +
                "name='" + person1.getName() + '\'' +
                ", birthday=" + person1.getBirthday() +
                ", gender=" + person1.getGender() +
                ", emailAddress='" + person1.getEmailAddress() + '\'' +
                '}';
        String actual = person1.toString();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetBirthday(){
        LocalDate expected = LocalDate.of(1980, 1, 25);
        LocalDate actual = person1.getBirthday();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testSetBirthday(){
        LocalDate expected = LocalDate.of(1990, 2, 15);
        person1.setBirthday(expected);
        LocalDate actual = person1.getBirthday();
        Assert.assertEquals(expected, actual);
        person1.setBirthday(LocalDate.of(1980, 1, 25));
    }
    @Test
    public void testGetGender(){
        Person.Sex expected = Person.Sex.MALE;
        Person.Sex actual = person1.getGender();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testSetGender(){
        Person.Sex expected = Person.Sex.FEMALE;
        person1.setGender(expected);
        Person.Sex actual = person1.getGender();
        Assert.assertEquals(expected, actual);
        person1.setGender(Person.Sex.MALE);
    }
    @Test
    public void testGetEmail(){
        String expected = "bob@bob.com";
        String actual = person1.getEmailAddress();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testSetEmail(){
        String expected = "johnny@bob.com";
        person1.setEmailAddress(expected);
        String actual = person1.getEmailAddress();
        Assert.assertEquals(expected, actual);
        person1.setEmailAddress("bob@bob.com");
    }
    @Test
    public void testGetAge(){
        int fakeAge = 10;
        int age = person1.getAge();
        Assert.assertNotEquals(fakeAge, age);
    }
    @Test
    public void getAgeTest() {
        //given

        int expectedAge = 40;
        //when
        int actualAge = person1.getAge();
        //then
        Assert.assertEquals(expectedAge, actualAge);
    }
    @Test
    public void printPersonTest(){

    }

    @Test
    public void PrintPersonOlderThanTest(){

        Person.printPersonsOlderThan(people, 50);
    }
    @Test
    public void printPersonsWithinAgeRangeTest(){

        Person.printPersonsWithinAgeRange(people, 30,50);
    }

}