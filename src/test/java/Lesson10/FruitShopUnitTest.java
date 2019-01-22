package Lesson10;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static Lesson10.FruitType.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(JUnitParamsRunner.class)
public class FruitShopUnitTest {

    private static Fruit apple;
    private static Fruit pear;
    private static Fruit strawberry;
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private FruitShop fruitShop;

    @BeforeClass
    public static void setUp() {
        System.out.println("Before Class MainJunitTest.class");

        apple = new Fruit(APPLE, 30, LocalDate.of(2019, Month.JANUARY, 1), 12, null);
        strawberry = new Fruit(STRAWBERRY, 30, LocalDate.of(2019, Month.JANUARY, 1), 24, null);
        pear = new Fruit(PEAR, 20, LocalDate.of(2019, Month.JANUARY, 19), 25, null);
    }

    @AfterClass
    public static void close() {
        System.out.println("After Class");
    }

    @Before
    public void initTest() {
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(apple);
        fruits.add(pear);
        fruitShop = new FruitShop("shop", fruits);
    }

    @After
    public void afterTest() {
        fruitShop = null;
    }


    @Test
    public void testGetFruits() {
        List<Fruit> expected = fruitShop.getFruits();
        Assert.assertNotNull(expected);
    }


    @Test
    public void testAllFresh() {

        List<Fruit> exp = new ArrayList<>();
        exp.add(apple);

        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, Month.JANUARY, 2));
        assertEquals(exp, actual);
    }

    @Test
    public void testAllFreshNothing() {
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2099, Month.APRIL, 2));
        assertEquals(0, actual.size());
    }

    @Test(expected = NullPointerException.class)
    public void testAllFreshDateNull() {
        fruitShop.allFresh(null);
    }

    @Test
    public void testAllFruitOfFruitType() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(pear);
        List<Fruit> actual = fruitShop.allFruitOfFruitType(PEAR);

        assertEquals(actual, expected);
    }

    @Test
    @Parameters({" -1 ", "0"})
    public void testCheckByExpireDate(int day) {
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        expected.add(pear);
        List<Fruit> actual = fruitShop.checkByExpireDate(day);

        assertEquals(expected, actual);
    }

    @Test
    public void testCheckByExpireDateShouldBeNotEquals() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);
        expected.add(pear);
        List<Fruit> actual = fruitShop.checkByExpireDate(100);

        assertNotEquals(expected, actual);
    }

    @Test
    public void testAllFreshAndFruitType() {
        List<Fruit> expected = new ArrayList<>();
        expected.add(apple);

        List<Fruit> actual = fruitShop.allFreshAndFruitType(APPLE, LocalDate.now());
        assertEquals(expected, actual);
    }

    @Test
    public void testAllFreshAndFruitTypeNullPointer() {
        exception.expect(NullPointerException.class);
        fruitShop.allFreshAndFruitType(APPLE, null);
    }

    @Test
    @Parameters({"50, 30, APPLE",
                "50, 20, APPLE"
    })
    public void testReSetPricexRealization(int percent, int daysToChange, FruitType fruitTypes) {

        List<Fruit> actual = fruitShop.reSetPricexRealization(percent, daysToChange, fruitTypes);

        assertEquals(apple.getPrice() / 2, actual.get(0).getPrice());
        System.out.println(actual.get(0).getPrice() + " Price ");
    }

}