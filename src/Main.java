class AirTraficControlTower{
    private static AirTraficControlTower instance;
    private AirTraficControlTower(){
        System.out.println("Диспетчерская башня создана Управление начато");
    }
    public static AirTraficControlTower getInstance(){
        if (instance == null){
            instance = new AirTraficControlTower();
        }
        return instance;
    }
    public void requestTakeOff(String fligth){
        System.out.println("Башня: Рейс " + fligth +
                " получил разрешение на взлет ");

    }
    public void requestLanding(String flight) {
        System.out.println("Башня: Рейс " + flight +
                " получил разрешение на посадку");
    }
}

class Airplane{
    private String filghtNumber;
    public Airplane(String fligthNumnber){
        this.filghtNumber=fligthNumnber;
    }
    public void takeOff(){
        AirTraficControlTower tower = AirTraficControlTower.getInstance();
        tower.requestTakeOff(filghtNumber);
    }
    public void land(){
        AirTraficControlTower tower = AirTraficControlTower.getInstance();
        tower.requestLanding(filghtNumber);
    }
}

//----------------------------------------------------------------------------------------------------------------------

// Интерфейс для продукта
interface Weapon {
    String getWeaponName(); // Метод для получения имени меча
}

// Конкретный продукт: Меч викинга
class VikingWeapon implements Weapon {
    private final String weapon = "меч викинга";

    @Override
    public String getWeaponName() {
        return weapon;
    }
}

// Конкретный продукт: Катана
class SamuraiWeapon implements Weapon {
    private final String weapon = "катана";

    @Override
    public String getWeaponName() {
        return weapon;
    }
}

// Абстрактный создатель
abstract class Creator {
    // Фабричный метод
    public abstract Weapon createWeapon();

    // Метод возвращает название кузнеца
    public abstract String getCreatorName();

    // Метод для создания меча с сообщением
    public void createWeaponWithMessage() {
        Weapon weapon = createWeapon(); // Создание конкретного меча
        System.out.println(getCreatorName() + ": " + weapon.getWeaponName() + " это то что я создаю!");
    }
}

// Конкретный создатель: Фабрика для викингского кузнеца
class NorwayCreator extends Creator {
    @Override
    public Weapon createWeapon() {
        return new VikingWeapon();
    }

    @Override
    public String getCreatorName() {
        return "Норвежский кузнец";
    }
}

// Конкретный создатель: Фабрика для японского кузнеца
class JapanCreator extends Creator {
    @Override
    public Weapon createWeapon() {
        return new SamuraiWeapon();
    }

    @Override
    public String getCreatorName() {
        return "Японский кузнец";
    }
}

//----------------------------------------------------------------------------------------------------------------------

// Интерфейс для мечей
interface Sword {
    String getSwordName();
}

// Интерфейс для доспехов
interface Armor {
    String getArmorName();
}

// Интерфейс для особых предметов
interface SpecialItem {
    String getSpecialItemName();
}

// Конкретные продукты для викингов
class VikingSword implements Sword {
    private final String sword = "меч викинга";
    @Override
    public String getSwordName() {
        return sword;
    }
}

class VikingArmor implements Armor {
    private final String armor = "доспехи викинга";
    @Override
    public String getArmorName() {
        return armor;
    }
}

class VikingAxe implements SpecialItem {
    private final String axe = "топор";
    @Override
    public String getSpecialItemName() {
        return axe;
    }
}

// Конкретные продукты для самураев
class Katana implements Sword {
    private final String sword = "катана";
    @Override
    public String getSwordName() {
        return sword;
    }
}

class SamuraiArmor implements Armor {
    private final String armor = "доспехи самурая";
    @Override
    public String getArmorName() {
        return armor;
    }
}

class Shuriken implements SpecialItem {
    private final String shuriken = "сюрикен";
    @Override
    public String getSpecialItemName() {
        return shuriken;
    }
}

// Абстрактный кузнец
abstract class BlackSmith {
    public abstract Sword createSword();
    public abstract Armor createArmor();
    public abstract SpecialItem createItem();
    public abstract String getBlackSmithName();
    public abstract String getType();

    public void CreateForWarrior() {
        Sword sword = createSword();
        Armor armor = createArmor();
        SpecialItem item = createItem();
        System.out.println(getBlackSmithName() + ": я создаю " + getType() +
                " (" + sword.getSwordName() + ", " + armor.getArmorName() + ", " + item.getSpecialItemName() + ") !");
    }
}

// Конкретные кузнецы
class NorwayBlackSmith extends BlackSmith {
    @Override
    public Sword createSword() {
        return new VikingSword();
    }
    @Override
    public Armor createArmor() {
        return new VikingArmor();
    }
    @Override
    public SpecialItem createItem() {
        return new VikingAxe();
    }
    @Override
    public String getBlackSmithName() {
        return "Норвежский Кузнец";
    }
    @Override
    public String getType() {
        return "доспехи викинга";
    }
}

class JapanBlackSmith extends BlackSmith {
    @Override
    public Sword createSword() {
        return new Katana();
    }
    @Override
    public Armor createArmor() {
        return new SamuraiArmor();
    }
    @Override
    public SpecialItem createItem() {
        return new Shuriken();
    }
    @Override
    public String getBlackSmithName() {
        return "Японский Кузнец";
    }
    @Override
    public String getType() {
        return "доспехи самурая";
    }
}

//----------------------------------------------------------------------------------------------------------------------

// Продукт
class Burger {
    private String buns;
    private String steak;
    private String sauce;
    private String salad;
    private String cheese;

    public void setBuns(String buns) {
        this.buns = buns;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setSteak(String steak) {
        this.steak = steak;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setSalad(String salad) {
        this.salad = salad;
    }

    @Override
    public String toString() {
        return "(" +
                buns + ", " +
                sauce + ", " +
                steak + ", " +
                cheese + (salad != null ? ", " + salad : "") +
                ")";
    }
}

// Интерфейс строителя
interface BurgerBuilder {
    void buildBuns();
    void buildSauce();
    void buildSteak();
    void buildCheese();
    void buildSalad();
    Burger getResult();
}

// Конкретный строитель для БигТести
class BigTastyBuilder implements BurgerBuilder {
    private Burger burger;

    public BigTastyBuilder() {
        this.burger = new Burger();
    }

    @Override
    public void buildBuns() {
        burger.setBuns("большая булочка с кунжутом");
    }

    @Override
    public void buildSauce() {
        burger.setSauce("соус БигТести");
    }

    @Override
    public void buildSteak() {
        burger.setSteak("большой рубленный бифштекс из 100% отборной говядины");
    }

    @Override
    public void buildCheese() {
        burger.setCheese("три кусочка сыра Эмменталь");
    }

    @Override
    public void buildSalad() {
        burger.setSalad("два ломтика помидора, свежий салат, лук");
    }

    @Override
    public Burger getResult() {
        return burger;
    }
}

// Конкретный строитель для Чизбургера
class CheeseburgerBuilder implements BurgerBuilder {
    private Burger burger;

    public CheeseburgerBuilder() {
        this.burger = new Burger();
    }

    @Override
    public void buildBuns() {
        burger.setBuns("карамелизованная булочка");
    }

    @Override
    public void buildSauce() {
        burger.setSauce("горчица и кетчуп");
    }

    @Override
    public void buildSteak() {
        burger.setSteak("рубленый бифштекс из натуральной цельной говядины");
    }

    @Override
    public void buildCheese() {
        burger.setCheese("кусочки сыра Чеддер");
    }

    @Override
    public void buildSalad() {
        burger.setSalad("лук и кусочки маринованного огурчика");
    }

    @Override
    public Burger getResult() {
        return burger;
    }
}

// Повар
class Chief {
    private BurgerBuilder builder;

    public Chief(BurgerBuilder builder) {
        this.builder = builder;
    }

    public void constructBurger() {
        builder.buildBuns();
        builder.buildSauce();
        builder.buildSteak();
        builder.buildCheese();
        builder.buildSalad();
    }

    public Burger getBurger() {
        return builder.getResult();
    }
}

//----------------------------------------------------------------------------------------------------------------------

public class Main {
    public static void main(String[] args) {

        //Abstract Factory
        BlackSmith norwayBlackSmith = new NorwayBlackSmith();
        norwayBlackSmith.CreateForWarrior();

        BlackSmith japanBlackSmith = new JapanBlackSmith();
        japanBlackSmith.CreateForWarrior();

        System.out.println("\n");

        //Factory Method
        // Создаём кузнеца из Норвегии
        Creator norway = new NorwayCreator();
        norway.createWeaponWithMessage(); // Вывод: Норвежский кузнец: меч викинга это то что я создаю!

        // Создаём кузнеца из Японии
        Creator japan = new JapanCreator();
        japan.createWeaponWithMessage(); // Вывод: Японский кузнец: катана это то что я создаю!

        System.out.println("\n");

        //Builder Method
        // Создаём БигТести
        BurgerBuilder bigTastyBuilder = new BigTastyBuilder();
        Chief chief1 = new Chief(bigTastyBuilder);
        chief1.constructBurger();
        Burger bigTasty = chief1.getBurger();
        System.out.println("Повар: я приготовил БигТести " + bigTasty);

        // Создаём Чизбургер
        BurgerBuilder cheeseburgerBuilder = new CheeseburgerBuilder();
        Chief chief2 = new Chief(cheeseburgerBuilder);
        chief2.constructBurger();
        Burger cheeseburger = chief2.getBurger();
        System.out.println("Повар: я приготовил Чизбургер " + cheeseburger);

        System.out.println("\n");

        //Singleton
        Airplane fligth1 = new Airplane("AB123");
        Airplane fligth2 = new Airplane("CD456");

        fligth1.takeOff();
        fligth2.land();

        AirTraficControlTower towerA = AirTraficControlTower.getInstance();
        AirTraficControlTower towerB = AirTraficControlTower.getInstance();

        System.out.println(towerA==towerB);
    }
}