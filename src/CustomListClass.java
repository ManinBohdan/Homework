public class CustomListClass  implements CustomList  {
   public int ArraySize = 10;
   public Object[] Array;
   public Object[] tmpArray;

   public CustomListClass () {
       // Инициализация основного и временного массивов
       Array = new Object[ArraySize];
       tmpArray = new Object[ArraySize];
   }

   // Проверка на наличие ненулевых элементов массива, и определение размера списка, в зависимости от количества таких элементов
    @Override
    public int size() {
       int counter = 0;
        for (int i = 0; i < Array.length; i++) {
            if (Array[i] != null) {
                counter++;
            }
        }
        return counter;
    }
    // Проверка на наличие элементов в самом списке
    @Override
    public boolean isEmpty() {
        if (size() > 0) {
            return false;
        }
        return true;
    }

    // Получение обьекта по его индексу в коллекции
    @Override
    public Object get(int index) {
        return Array[index];
    }

    // Добавление обьектов в коллекцию по индексу
    @Override
    public void add(int index, Object element) {
        // Если индекс больше чем количество элементов в коллекции выдавать exception
        if (index > size()) System.exit(1);

        // Кастомная реализация динамического массива
        if (size() == ArraySize) {
            ArraySize = (int) (ArraySize * 1.5);
            tmpArray = new Object[ArraySize];
            for (int i = 0; i < Array.length; i++) {
                tmpArray[i] = Array[i];
            }

            Array = new Object[ArraySize];

            for (int i = 0; i < Array.length; i++) {
                Array[i] = tmpArray[i];
            }
        }

        // Если коллекция не пустая
        if (size() > 0) {
            // Если элемент добавляеться в конец коллекции
            if (size() == index) {
                Array[index] = element;
            }
            // Если элемент добавляеться в другое любое место списка
            else {
                for (int i = 0; i <= size(); i++) {
                    if (index > i) {
                        tmpArray[i] = Array[i];
                    }
                    else if (index == i) {
                        tmpArray[i] = element;
                    }
                    else {
                        tmpArray[i] = Array[i - 1];
                    }
                }

                // Копирование элементов в первоначальный массив
                Array = tmpArray;
            }
        }
        // Если коллекция пустая
        else {
            // Если элемент хотят поместить в начало коллекции
            if (index == 0) Array[index] = element;
            // Если обьект хотят поместить в другое место списка, пишет ошибку и завершает выполнение программы
            else System.exit(1);
        }
    }

    // Получает обьект и вызывает метод toString конкретного класса полученого ранее обьекта
    public static void toString(Object o) {
       o.toString();
    }
}
