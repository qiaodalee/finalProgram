# 簡報標題：例外處理（Exceptions）

---

## 1. 什麼是例外？
- 例外是在程式執行期間發生的事件，打斷了程式正常執行流程。
- 當方法內部發生錯誤時，該方法會建立一個例外物件並將其傳遞給運行時系統。
- 例外物件包含有關錯誤的信息，包括其類型以及錯誤發生時程式的狀態。
- 將例外物件建立並傳遞給運行時系統稱為拋出例外。

---

## 2. 例外處理器
- 例外處理器在呼叫堆疊中尋找包含可以處理例外的程式碼區塊的方法。
- 呼叫堆疊：搜尋呼叫堆疊
- 處理例外的方法：try 區塊，包含 catch 和 finally 區塊。
  
---

## 3. 捕捉或指定的要求
- 可能引發某些例外的程式碼必須包含以下之一：
  - 用於捕捉例外的 try 區塊，並提供例外處理器。
  - 指定可能拋出例外的方法，該方法必須提供包含例外列表的 throws 子句。
- 不是所有例外都受捕捉或指定要求的約束。

---

## 4. 三種例外情況
1. **檢查例外（Checked Exception）**
   - 良好撰寫的應用程式應該預期和從中恢復的例外狀況。
   - 例子：使用者提供了一個不存在的檔案名稱。
   ```java
   try {
       FileReader fileReader = new FileReader("nonexistent.txt");
   } catch (FileNotFoundException e) {
       System.err.println("Caught FileNotFoundException: " + e.getMessage());
   }
   ```

2. **錯誤（Error）**
   - 外部應用程式通常無法預測或從中恢復的嚴重例外狀況。
   - 例子：因硬體或系統故障無法讀取檔案。
   ```java
   try {
       int[] array = new int[Integer.MAX_VALUE];
   } catch (OutOfMemoryError e) {
       System.err.println("Caught OutOfMemoryError: " + e.getMessage());
   }
   ```

3. **執行時例外（Runtime Exception）**
   - 內部應用程式通常無法預測或從中恢復的例外狀況。
   - 例子：傳遞 null 檔案名稱。
   ```java
   try {
       String fileName = null;
       int length = fileName.length(); // This will throw NullPointerException
   } catch (NullPointerException e) {
       System.err.println("Caught NullPointerException: " + e.getMessage());
   }
   ```

---

## 5. 檢查和未檢查例外
- **未檢查例外（Unchecked Exception）**：不需要明確捕捉或指定的例外狀況。
  - 例子：陣列越界。
  ```java
  int[] numbers = {1, 2, 3};
  System.out.println(numbers[5]);  // This will throw ArrayIndexOutOfBoundsException
  ```

---

## 6. try 區塊
- 語法：
  ```java
  try {
      // 可能拋出例外的程式碼
  } catch and finally 區塊 . . .
  ```
- 範例：為 ListOfNumbers 類別的 writeList 方法建立例外處理器。
  ```java
  public void writeList() {
      PrintWriter out = null;
      try {
          System.out.println("Entered try statement");
          out = new PrintWriter(new FileWriter("OutFile.txt"));
          for (int i = 0; i < SIZE; i++) {
              out.println("Value at: " + i + " = " + list.get(i));
          }
      } catch and finally 區塊 . . .
  }
  ```

---

## 7. catch 區塊
- 將例外處理器與 try 區塊相關聯，提供一個或多個 catch 區塊。
- 語法：
  ```java
  try {} catch (ExceptionType name) {} catch (ExceptionType name) {}
  ```
- 例外處理器處理與其引數指示的例外類型相符的例外。
- ExceptionType 必須是繼承自 Throwable 類的類別名稱。

---

## 8. 例外在 try 區塊中發生
- 例子：在 writeList 方法的 try 區塊中發生 IndexOutOfBoundsException 和 IOException。
  ```java
  public void writeList() {
      PrintWriter out = null;
      try {
          System.out.println("Entering try statement");
          out = new PrintWriter(new FileWriter("OutFile.txt"));
          for (int i = 0; i < SIZE; i++)
              out.println("Value at: " + i + " = " + list.get(i));
      } catch (IndexOutOfBoundsException e) {
          System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());
      } catch (IOException e) {
          System.err.println("Caught IOException: " + e.getMessage());
      } finally {
          if (out != null) {
              System.out.println("Closing PrintWriter");
              out.close();
          } else {
              System.out.println("PrintWriter not open");
          }
      }
  }
  ```

---

## 9. try 區塊正常退出
- 例子：writeList 方法的 try 區塊正常退出。
  ```java
  public void writeList() {
      PrintWriter out = null;
      try {
          System.out.println("Entering try statement");
          out = new PrintWriter(new FileWriter("OutFile.txt"));
          for (int

 i = 0; i < SIZE; i++)
              out.println("Value at: " + i + " = " + list.get(i));
      } catch (IndexOutOfBoundsException e) {
          System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());
      } catch (IOException e) {
          System.err.println("Caught IOException: " + e.getMessage());
      } finally {
          if (out != null) {
              System.out.println("Closing PrintWriter");
              out.close();
          } else {
              System.out.println("PrintWriter not open");
          }
      }
      // After the finally block finishes executing,
      // the program continues with the first statement after the finally block
  }
  ```

---

## 10. 鏈結例外
- 應用程式通常會對例外作出響應，並拋出另一個例外。
- 例子：在捕捉 IOException 時拋出 SampleException。
  ```java
  try {
      // File operations that may cause IOException
  } catch (IOException e) {
      throw new SampleException("Custom error message", e);
  }
  ```

---

## 11. 支援鏈結例外的方法
- Throwable 類的方法和建構子支援鏈結例外。
- ```java
  Throwable getCause()     // 返回導致當前例外的例外
  Throwable initCause(Throwable)    // initCause 設定當前例外的原因，引數是導致當前例外的例外
  Throwable(String, Throwable)      // 建構子
  Throwable(Throwable)      // 建構子，引數是導致當前例外的例外
  ```

---

## 12. 存取堆疊跟蹤資訊
- 使用較高級別的例外處理器將堆疊跟蹤資訊轉儲出來。
- 例子：調用例外物件上的 getStackTrace 方法。
  ```java
  catch (Exception cause) {
      StackTraceElement elements[] = cause.getStackTrace();
      for (int i = 0, n = elements.length; i < n; i++) {
          System.err.println(elements[i].getFileName() + ":" + elements[i].getLineNumber() +
                  ">> “+ elements[i].getMethodName() + "()");
      }
  }
  ```

---

## 13. 日誌 API
- 使用 java.util.logging 套件的日誌設施將輸出發送到檔案。
- 例子：將輸出發送到檔案的日誌設施。
  ```java
  try {
      Handler handler = new FileHandler("OutFile.log");
      Logger.getLogger("").addHandler(handler);
  } catch (IOException e) {
      Logger logger = Logger.getLogger("package.name");
      StackTraceElement elements[] = e.getStackTrace();
      for (int i = 0, n = elements.length; i < n; i++) {
          logger.log(Level.WARNING, elements[i].getMethodName());
      }
  }
  ```

---

## 14. 建立例外類別
- 創建新的例外類別的原因：
  - 如果需要一個在 Java 平台上未表示的例外類型。
  - 如果讓使用者能夠區分您的例外和其他供應商編寫的類別拋出的例外有所幫助。
  - 如果您的代碼拋出多個相關例外，是否應該使用您自己的例外？
  - 如果使用其他人的例外，使用者是否能夠訪問這些例外？類似的問題是，您的包是否獨立且自包含？

---

## 15. 建立例外類別範例 - 1
- 範例：一個連結列表類別，支援以下方法。
  - objectAt(int n)：返回列表中第 n 個位置的對象。
  - firstObject()：返回列表中的第一個對象。
  - indexOf(Object o)：搜索列表以查找指定的對象並返回其在列表中的位置。
  ```java
  public class LinkedListException extends Exception {
      // 例外的相應建構子和方法
  }
  ```

---

## 16. 建立例外類別範例 - 2
- LinkedListException 類的父類別。
  ```java
  public class CustomException extends Exception {
      // 例外的相應建構子和方法
  }
  ```

---

## 17. 建立例外類別範例 - 3
- 例外類別：ObjectNotFoundException。
  ```java
  public class ObjectNotFoundException extends CustomException {
      // 例外的相應建構子和方法
  }
  ```

---

## 結論
- 例外處理是一種重要的編碼實踐，有助於提高程式的穩定性和可讀性。
- 正確處理例外有助於確保程式在面對錯誤時能夠優雅地處理，並提供有意義的錯誤信息。
- Java 提供了豐富的例外處理機制，開發人員應熟練掌握並合理運用。


# Java 程式碼範例：例外處理與自訂例外
以下是一個完整的 Java 程式碼範例，包括 `main` 函式、Java 內建的例外（`ArithmeticException`）、以及開發者自訂的例外類別（`CustomException`）。程式演示了如何處理例外和建立自訂的例外類別。

```java
public class ExceptionExample {

    // 自訂義的例外類別
    static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        try {
            // 造成算術例外
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Caught ArithmeticException: " + e.getMessage());
        }

        try {
            // 造成自訂義例外
            throwCustomException();
        } catch (CustomException e) {
            System.err.println("Caught CustomException: " + e.getMessage());
        }
    }

    // 除法函式，可能拋出算術例外
    private static int divide(int dividend, int divisor) {
        return dividend / divisor;
    }

    // 丟擲自訂義例外的函式
    private static void throwCustomException() throws CustomException {
        throw new CustomException("這是一個自訂的例外！");
    }
}
```

這個範例中，`ExceptionExample` 類別包含了 `main` 函式，用於執行程式。它示範了兩種不同的例外狀況：一個是算術例外，另一個是自訂的 `CustomException`。在 `divide` 函式中，若除數為零，就會拋出算術例外；而在 `throwCustomException` 函式中，則主動拋出自訂的例外。

在 `main` 函式中，透過 `try-catch` 區塊來捕捉並處理例外。若發生算術例外，會輸出相應的錯誤訊息；若發生自訂例外，則同樣輸出相應的錯誤訊息。
