# MySQL 入門

## 安裝 MySQL
1. 安裝 MySQL
   - 創建目錄 "myWeb"
   - 下載 MySQL：mysql-8.0.{xx}-winx64.zip
   - 解壓縮至 "myWeb" 目錄
   - 重命名解壓縮後的目錄為 "myWeb\mysql"
   
2. 初始化數據庫
   - 啟動命令提示符 (以管理員身份運行)
   - 切換到 MySQL 的二進制目錄：cd \myWeb\mysql\bin
   - 初始化數據庫：mysqld --initialize --console
   - 如果出現 "VCRUNTIME140_1.dll 未找到" 錯誤，下載 "x64: vc_redist.x64.exe" 並運行安裝

3. 啟動/關閉服務器
   - 啟動服務器：cd \myWeb\mysql\bin，然後運行 mysqld --console
   - 檢查版本和套接字端口：3306
   - 關閉服務器：Ctrl-C，不要使用窗口的 CLOSE 按鈕

## 啟動客戶端
1. 啟動客戶端
   - 確保服務器正在運行
   - 開啟新的命令提示符
   - 進入 MySQL 的二進制目錄
   - 以超級用戶 "root" 啟動客戶端：mysql -u root -p，輸入密碼

2. 創建新用戶
   - 以超級用戶 "root" 啟動客戶端
   - 創建用戶：create user 'user1'@'localhost' identified by 'xxx'
   - 授予用戶權限：grant all on *.* to 'user1'@'localhost'

## 創建數據庫、表和記錄
1. 創建數據庫、表和記錄
   - 數據庫的數據層次結構：系統包含多個數據庫，數據庫包含多個表，表包含行（記錄）和列（字段）
   - 使用 MySQL 命令進行操作，例如：select * from adv1112;

2. SQL 命令
   - 所有命令以分號結尾，例如：mysql> select * from adv1112;
   - 跨足數行的命令，提示符變為 "->"
   - 使用 \c 來取消當前命令，Ctrl-C 來中止當前命令
   - 使用單引號或雙引號時，未關閉將改變提示符
   - 使用上/下箭頭鍵檢視之前/之後的命令
   - 啟用 CMD 的複製/粘貼功能：工具欄>屬性>選項>編輯選項中勾選 "啟用 Ctrl 鍵快捷鍵"

## JDBC 程序
1. 創建連接對象
   - 使用 DriverManager.getConnection(database-url, db-user, password) 創建 Connection 對象
   - database-url 格式為 "jdbc:mysql://{主機}:{端口}/{數據庫名}"

2. 創建 Statement 對象
   - 使用 conn.createStatement() 創建 Statement 對象

3. 寫/執行 SQL 命令
   - 使用 executeQuery() 執行 SELECT 命令，結果為 ResultSet 對象

4. ResultSet 類
   - 用於模擬返回的表格，使用 next() 方法移動光標並讀取數據
   - 使用 getXxx(columnName) 方法檢索列的值

5. 關閉 Statement 和 Connection
   - 使用 close() 方法關閉 ResultSet、Statement 和 Connection 對象，或使用 try-with-resources 自動關閉

## JDBC 程序練習
- 設計 JDBC 程序查詢數據庫 scores，表 adv1112 的所有記錄

## 更新、插入和刪除
- 使用 executeUpdate() 執行 SQL UPDATE、INSERT 和 DELETE 命令，返回受影響的記錄數
- 注意：不能插入具有相同主鍵值的兩條記錄，應在插入新記錄之前刪除記錄。

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {

    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "your_username";
        String password = "your_password";

        // Establish a connection
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Create a statement
            try (Statement statement = connection.createStatement()) {
                // Execute a query
                String query = "SELECT * FROM adv1112";
                try (ResultSet resultSet = statement.executeQuery(query)) {
                    // Process the result set
                    while (resultSet.next()) {
                        // Retrieve data by column name
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        int score = resultSet.getInt("score");

                        // Process the retrieved data (e.g., print or use it)
                        System.out.println("ID: " + id + ", Name: " + name + ", Score: " + score);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```
