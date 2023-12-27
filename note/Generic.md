# 泛型

## 什麼是泛型？
- 泛型允許在定義類別、介面和方法時將類型（類別和介面）作為參數
- 優點：
  - 編譯時期更強的類型檢查。修復編譯時錯誤比修復運行時錯誤更容易找到
  - 消除轉型。例子：沒有泛型的程式碼需要轉型
    ```java
    List list = new ArrayList();
    list.add("hello");
    String s = (String) list.get(0);
    ```
    泛型程式碼不需要轉型
    ```java
    List<String> list = new ArrayList<>();
    list.add("hello");
    String s = list.get(0);
    ```
  - 允許程序員實現通用算法。泛型算法可用於不同類型的集合，並且是類型安全且易讀的。

## 泛型範例
### 非泛型的Box類別
```java
public class Box {
    private Object object;
    public void set(Object object) {
        this.object = object;
    }
    public Object get() {
        return object;
    }
}
```

### 泛型的Box類別
```java
public class Box<T> {
    private T t;
    public void set(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }
}
```

- 類型變數可以是任何非原始類型，包括任何類型、介面、數組或其他類型變數。

## 類型參數命名慣例
- 通常，類型參數的名稱是單個大寫字母
- 常用的類型參數名稱：
  - E - 元素（在Java集合框架中廣泛使用）
  - K - Key
  - N - Number
  - T - Type
  - V - Value
  - S, U, V 等 - 第2、3、4類型

## 呼叫和實例化泛型類型
- 進行泛型類別的呼叫，使用具體值替換T
  ```java
  Box<Integer> integerBox;
  ```
- 實例化泛型類型
  ```java
  Box<Integer> integerBox = new Box<Integer>();
  ```
  Java SE 7及更高版本中，如果編譯器能夠從上下文中確定類型參數，可以使用空的類型參數（<>）
  ```java
  Box<Integer> integerBox = new Box<>();
  ```

## 多個類型參數
```java
public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}

public class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
```

## 無界泛型（Raw Types）
- 無界泛型是不帶任何類型參數的泛型類別或介面
- 例子：泛型Box類別的無界形式
  ```java
  Box rawBox = new Box();
  ```
  在這種情況下，`rawBox` 是 `Box` 的無界形式，沒有指定類型參數。

## 泛型方法
- 泛型方法可以是靜態或非靜態的
- 泛型方法的語法：類型參數出現在方法返回類型之前
  ```java
  public static <T> boolean compare(Pair<T, T> p1, Pair<T, T> p2) {
      return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
  }
  ```
- 調用泛型方法的方式
  ```java
  Pair<Integer, String> p1 = new Pair<>(1, "apple");
  Pair<Integer, String> p2 = new Pair<>(2, "pear");
  boolean same = Util.<Integer, String>compare(p1, p2);
  // 或者讓編譯器推斷類型
  boolean same = Util.compare(p1, p2);
  ```

## 上界通配符 - 只能讀取
- 上界通配符使用 `extends` 限定通配符的上界
- 例子：上界通配符的讀取限制
  ```java
  List<? extends Number> numbers = new ArrayList<Integer>();
  Number n = numbers.get(0); // 可以讀取
  numbers.add(42); // 編譯錯誤，不可寫入
  ```

## 下界通配符 - 可讀可寫
- 下界通配符使用 `super` 限定通配符的下界
- 例子：下界通配符的可讀可寫限制
  ```java
  List<? super Double> doubles = new ArrayList<Number>();
  doubles.add(3.14); // 可以

寫入
  Object o = doubles.get(0); // 可以讀取
  ```

## 泛型和子類型
- 泛型和子類型的關係是特殊的
- 例子：List<Integer> 不是 List<Number> 的子類型
  ```java
  List<Number> ln = new ArrayList<>();
  List<Integer> li = new ArrayList<>();
  ln = li; // 編譯錯誤
  ```

## 泛型擦除和橋接方法
- 泛型的擦除：在運行時，泛型類別的類型參數被擦除，變成原始

類型
- 例子：泛型擦除後的橋接方法
  ```java
  class MyNode extends Node {
      // 編譯器生成的橋接方法
      public void setData(Object data) {
          setData((Integer) data);
      }

      public void setData(Integer data) {
          System.out.println("MyNode.setData");
          super.setData(data);
      }
  }
  ```
- 橋接方法的目的是確保泛型類別的繼承關係得以維護，以便運行時的多態性正確運作

## 非實質類型
- 實質類型是在運行時完全可用的類型，包括基本類型、非泛型類型、原始類型和未限定通配符的調用
- 非實質類型是在編譯時被擦除類型信息的類型，包括泛型類型和限定通配符的調用
- 非實質類型不能在 `instanceof` 運算符表達式中使用，也不能用作陣列元素類型

## 非實質類型的堆污染
- 堆污染發生在引用的變數類型與實際存儲的類型不匹配的情況下
- 例子：堆污染
  ```java
  List<String> stringList = new ArrayList<>();
  List rawList = stringList; // 運行時堆污染
  rawList.add(42); // 編譯通過，但運行時會拋出 ClassCastException
  ```

## 上界通配符和只讀特性
- 上界通配符使集合只能讀取，無法寫入
- 例子：上界通配符限制只能讀取
  ```java
  List<? extends Number> l = new ArrayList<Integer>();
  Number n1 = new Double(1.0);
  l.add(n1); // 編譯錯誤
  ```
  

# 多型型別泛型範例 - Java

以下是一個展示多種型別參數的泛型範例，程式中使用了 E、K、N、T、V、S、U 這些泛型標識符。主要展示如何建立一個泛型類別 `MultiTypeBox` 以及如何在主函式中使用它。

```java
// MultiTypeBox.java
public class MultiTypeBox<E, K, N extends Number, T, V, S, U> {
    private E element;
    private K key;
    private N number;
    private T type;
    private V value;
    private S secondType;
    private U thirdType;

    // 建構子
    public MultiTypeBox(E element, K key, N number, T type, V value, S secondType, U thirdType) {
        this.element = element;
        this.key = key;
        this.number = number;
        this.type = type;
        this.value = value;
        this.secondType = secondType;
        this.thirdType = thirdType;
    }

    // 取得各種元素的方法（getter）
    public E getElement() {
        return element;
    }

    public K getKey() {
        return key;
    }

    public N getNumber() {
        return number;
    }

    public T getType() {
        return type;
    }

    public V getValue() {
        return value;
    }

    public S getSecondType() {
        return secondType;
    }

    public U getThirdType() {
        return thirdType;
    }

    // 主要用於展示的方法
    public void displayInfo() {
        System.out.println("MultiTypeBox 元素的組合: " +
                element + ", " +
                key + ", " +
                number + ", " +
                type + ", " +
                value + ", " +
                secondType + ", " +
                thirdType);
    }
}
```

```java
// MainApp.java
public class MainApp {
    public static void main(String[] args) {
        // 創建一個存放不同型別元素的 MultiTypeBox
        MultiTypeBox<String, Integer, Double, Character, Boolean, Float, Long> box1 =
                new MultiTypeBox<>("Hello", 42, 3.14, 'A', true, 3.0f, 123L);

        // 取得並展示 MultiTypeBox 中的元素
        String element = box1.getElement();
        Integer key = box1.getKey();
        Double number = box1.getNumber();
        Character type = box1.getType();
        Boolean value = box1.getValue();
        Float secondType = box1.getSecondType();
        Long thirdType = box1.getThirdType();

        System.out.println("MultiTypeBox 的元素: " +
                element + ", " +
                key + ", " +
                number + ", " +
                type + ", " +
                value + ", " +
                secondType + ", " +
                thirdType);

        // 創建一個存放其他型別元素的 MultiTypeBox
        MultiTypeBox<Boolean, String, Integer, Double, Float, Character, Short> box2 =
                new MultiTypeBox<>(true, "Java", 123, 3.14, 2.5f, 'B', (short) 456);

        // 取得並展示 MultiTypeBox 中的元素
        Boolean element2 = box2.getElement();
        String key2 = box2.getKey();
        Integer number2 = box2.getNumber();
        Double type2 = box2.getType();
        Float value2 = box2.getValue();
        Character secondType2 = box2.getSecondType();
        Short thirdType2 = box2.getThirdType();

        System.out.println("MultiTypeBox 的元素: " +
                element2 + ", " +
                key2 + ", " +
                number2 + ", " +
                type2 + ", " +
                value2 + ", " +
                secondType2 + ", " +
                thirdType2);
    }
}
```

在這個範例中：
- `MultiTypeBox` 是一個泛型類別，包含了多種型別參數：E、K、N、T、V、S、U。
- 主程式 `MainApp` 創建了兩個 `MultiTypeBox` 的實例，分別存放不同型別的元素，並展示了取得元素的過程。
