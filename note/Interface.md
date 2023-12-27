# PPT 整理：介面、繼承和多型

## 介面、繼承和多型

---

## 介面（Interface）

- **定義：**
  - 介面是一種參考類型
  - 類似於類別，僅包含常數、方法簽名、預設方法、靜態方法和巢狀類型
  - 方法僅有預設方法和靜態方法有實作
  - 抽象方法沒有實作
  - 介面中的所有方法都是隱含 `public`
  
- **例子：**
  ```java
  public interface GroupedInterface extends Interface1, Interface2, Interface3 {
      // 常數宣告
      double E = 2.718282;
      
      // 抽象方法簽名
      void doSomething(int i, double x);
      
      // 抽象方法簽名
      int doSomethingElse(String s);
  }
  ```

---

## 實作介面

- **實作方法：**
  - 類別實作介面使用 `implements` 關鍵字
  - 一個類別可以實作多個介面
  - 介面的實作方法需要在類別中提供實際的實作
  
- **例子：**
  ```java
  public class RectanglePlus implements Relatable {
      // 實作方法
      public int isLargerThan(Relatable other) {
          // 實作比較邏輯
      }
  }
  ```

---

## 介面的演進

- **新增方法：**
  - 新增介面方法可能導致所有實作該介面的類別需要更新
  - 解決方法：
    1. 創建新介面擴充舊介面
    2. 使用預設方法或靜態方法
  
- **預設方法或靜態方法：**
  - 新增介面方法作為預設方法或靜態方法
  - 不需要修改所有實作類別
  
- **例子：**
  ```java
  public interface DoIt {
      void doSomething(int i, double x);
      int doSomethingElse(String s);
  
      // 新增方法，使用預設方法
      default boolean didItWork(int i, double x, String s) {
          // 實作
      }
  }
  ```

---

## 多型（Polymorphism）

- **定義：**
  - 多型允許一個物件以多種型別的方式呈現
  - 在Java中，主要實現多型的方式是通過繼承和介面
  
- **例子：**
  ```java
  public class RoadBike extends Bicycle {
      // 子類別繼承父類別
      public void printDescription() {
          super.printDescription();
          System.out.println("The RoadBike has " + getTireWidth() + " MM tires.");
      }
  }
  ```

---

## 物件作為超類別

- **Object 類別：**
  - 所有類別都繼承自 `Object` 類別
  - `Object` 類別提供一些基本方法
    - `equals()`: 比較兩物件是否相等
    - `hashCode()`: 取得物件的雜湊碼
    - `toString()`: 取得物件的字串表示
  
- **例子：**
  ```java
  public class Book {
      public boolean equals(Object obj) {
          // 實作比較邏輯
      }
  }
  ```

---

## 總結

- 介面提供一種多重繼承的方式
- 介面的演進可以透過預設方法或靜態方法實現
- 多型允許一個物件以多種形式呈現
- 所有類別都繼承自 `Object` 類別，可以使用 `equals()`、`hashCode()`、`toString()` 等方法

---

# Example Interface: Printable

```java
public interface Printable {
    // Abstract method declaration
    void print();
    
    // Default method with implementation
    default void printHeader() {
        System.out.println("Printable Content:");
    }
    
    // Static method with implementation
    static void printFooter() {
        System.out.println("End of Page");
    }
}
```


### Example Interface: `Printable`

```java
// Printable.java
public interface Printable {
    void print();
}
```

### Example Class Implementing the Interface: `Book`

```java
// Book.java
public class Book implements Printable {
    private String title;

    // Constructor
    public Book(String title) {
        this.title = title;
    }

    // Implementation of the Printable interface method
    @Override
    public void print() {
        System.out.println("Printing Book: " + title);
    }
}
```

### Main Function: `MainApp`

```java
// MainApp.java
public class MainApp {
    public static void main(String[] args) {
        // Create an instance of the class that implements the interface
        Printable printableItem = new Book("Java Programming");

        // Call the print method using the interface reference
        printableItem.print();
    }
}
```
