import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class PersonTest {
     List<Person> roster;

    @Before
    public void setup(){
            roster = new ArrayList<>();
            roster.add(
                    new Person(
                            "Fred",
                            LocalDate.of(1980, 6, 20),
                            Person.Sex.MALE,
                            "fred@example.com"));
            roster.add(
                    new Person(
                            "Jane",
                            LocalDate.of(1990, 7, 15),
                            Person.Sex.FEMALE, "jane@example.com"));
            roster.add(
                    new Person(
                            "George",
                            LocalDate.of(1991, 8, 13),
                            Person.Sex.MALE, "george@example.com"));
            roster.add(
                    new Person(
                            "Bob",
                            LocalDate.of(2000, 9, 12),
                            Person.Sex.MALE, "bob@example.com"));



    }
    @Test
    public void testConstructor(){
            Assert.assertNotNull(roster.get(0));
    }
    @Test
    public void testNullaryConstructor(){
        Person person = new Person();
        Assert.assertNotNull(person);
    }
    @Test
    public void testGetName(){
        String expected = "Fred";
        String actual = roster.get(0).getName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testSetName(){
        String expected = "Todd";
        roster.get(0).setName(expected);
        String actual = roster.get(0).getName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testToString(){
         String expected = "java.Person{" +
                "name='" + roster.get(0).getName() + '\'' +
                ", birthday=" + roster.get(0).getBirthday() +
                ", gender=" + roster.get(0).getGender() +
                ", emailAddress='" + roster.get(0).getEmailAddress() + '\'' +
                '}';
        String actual = roster.get(0).toString();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGetBirthday(){
        LocalDate expected =  LocalDate.of(1980, 6, 20);
        LocalDate actual =roster.get(0).getBirthday();
        Assert.assertEquals(expected, actual);
    }
//    @Test
//    public void testSetBirthday(){
//        LocalDate expected = LocalDate.of(1990, 2, 15);
//        roster.get(0).setBirthday(expected);
//        LocalDate actual = roster.get(0).getBirthday();
//        Assert.assertEquals(expected, actual);
//        roster.get(0).setBirthday(LocalDate.of(1980, 1, 25));
//    }
    @Test
    public void testGetGender(){
        Person.Sex expected = Person.Sex.MALE;
        Person.Sex actual = roster.get(0).getGender();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testSetGender(){
        Person.Sex expected = Person.Sex.FEMALE;
        roster.get(0).setGender(expected);
        Person.Sex actual = roster.get(0).getGender();
        Assert.assertEquals(expected, actual);
        roster.get(0).setGender(Person.Sex.MALE);
    }
    @Test
    public void testGetEmail(){
        String expected = "fred@example.com";
        String actual =roster.get(0).getEmailAddress();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testSetEmail(){
        String expected = "johnny@bob.com";
        roster.get(0).setEmailAddress(expected);
        String actual = roster.get(0).getEmailAddress();
        Assert.assertEquals(expected, actual);
        roster.get(0).setEmailAddress("bob@bob.com");
    }
    @Test
    public void testGetAge(){
        int fakeAge = 10;
        int age = roster.get(0).getAge();
        Assert.assertNotEquals(fakeAge, age);
    }
    @Test
    public void getAgeTest() {
        //given

        int expectedAge = 40;
        //when
        int actualAge = roster.get(0).getAge();
        //then
        Assert.assertEquals(expectedAge, actualAge);
    }
    @Test
    public void PrintPersonOlderThanTest(){
    // Prints Fred as age is 40
        Person.printPersonsOlderThan(roster, 35);
    }
    @Test
    public void printPersonsWithinAgeRangeTest(){
      //Prints Fred and Jane
        Person.printPersonsWithinAgeRange(roster, 30,50);
    }

    @Test
    public void printPersonTestForAnonymousClass() {
        //Bob is printed as he has age between 18-25
        Person.printPersons(
                roster,
                (Person p) -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );
    }


}