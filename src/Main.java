public class Main {
    public int i;
    public String Name;

    public Main(String name) {
        Name = name;
    }

    public static void main(String[] args) {

        var list = new CustomListClass();

        for (int i = 0; i < 18; i++) {
            list.add(i, new Main("NameMan"));
        }

        // ызов всех реализованых методов кастомной коллекции
        System.out.println(list.get(0));
        System.out.println(list.size());
        System.out.println(list.isEmpty());

    }

        // Метод возвращает значение поля Name
        public String toString() {
            return this.Name;
        }


}
